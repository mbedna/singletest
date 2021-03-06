package org.junit.runner;

import org.junit.runner.notification.Failure;

public class SingleJUnitTestRunner {
	public static void main(String[] args) {
        if (args == null) {
            System.out.println("Input should be Class#method.");
            return;
        }
		String[] classAndMethod = args[0].split("#");
        if (classAndMethod.length < 2) {
            System.out.println("Test method not found.");
            return;
        }

		System.out.println("class: " + classAndMethod[0] + ", method: " + classAndMethod[1]);
        Class clazz = null;
        try {
            clazz = Class.forName(classAndMethod[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

		Request request = Request.method(clazz, classAndMethod[1]);
		Result result = new JUnitCore().run(request);
		if (result.wasSuccessful()) { 
            System.out.println("Success");
        } else { 
            System.out.println("Failure");
        }  
        for(Failure failure : result.getFailures()) {
            System.out.println(failure);
        }
		System.exit(result.wasSuccessful() ? 0 : 1);
	}
}
