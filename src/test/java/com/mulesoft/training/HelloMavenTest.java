package com.mulesoft.training;


import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
        runFlowAndExpect("muleFlow", "This is a Munit Testing Flow");
    }
    
    @Override
    protected String getConfigFile() {
        return "mule.xml";
    }

}
