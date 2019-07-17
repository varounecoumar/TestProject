package testNG;

import org.testng.annotations.Test;

public class TestException {
	
  @Test
  public void f() {	
	 
	  int a = 20;
	  int result = a/0;
	  System.out.println(result);
	  
  }
}
