package testNG;

import org.testng.annotations.Test;

public class Test_GroupAnnotation {


	@Test(groups = {"functest", "checkintest"})
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		
	}

	@Test(groups = { "functest" })
	public void testingExitMessage() {
		System.out.println("Inside testExitMessage()");
		
	}

	@Test(groups = { "checkintest" })
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		
	}
	@Test
	public void testMyTest(){
		System.out.println("Not included in groups....");
	}

}
