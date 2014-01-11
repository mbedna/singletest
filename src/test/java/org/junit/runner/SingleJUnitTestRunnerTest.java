package org.junit.runner;

import org.junit.Test;

public class SingleJUnitTestRunnerTest {

    @Test
    public void should_Return_Error_When_Null_Was_Sent() throws Exception {
        SingleJUnitTestRunner.main(null); 
    }

    @Test
    public void should_Return_Error_When_Only_Class_Was_Sent() throws Exception {
        SingleJUnitTestRunner.main(new String[] {"Test"}); 
    }
}
