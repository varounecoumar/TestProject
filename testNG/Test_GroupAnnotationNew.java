package testNG;

import org.testng.annotations.Test;

public class Test_GroupAnnotationNew {
	
	@Test(groups = { "checkintest" })
	public void sampleTest1() {
		System.out.println("Inside test1()");
		
	}
	
	@Test(groups = { "A" })
	public void SampleTest2() {
		System.out.println("Inside test2()");
		
	}
	
}
