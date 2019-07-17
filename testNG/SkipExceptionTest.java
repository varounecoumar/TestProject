package testNG;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipExceptionTest {
	
  @Test
  public void f() {
	  
	  for(int i =0; i<10; i++){
		  System.out.println(i);
		  if(i==5){			  
			  throw new SkipException("I don't want this number...");
		  }
	  }
  }
}
