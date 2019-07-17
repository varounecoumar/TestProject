package testNG;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGExceptions {

	@Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = "Pass Message test")
	public void exceptionTestOne() throws Exception {
		throw new IOException("Pass Message test");
	}

	@Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = ".* Message .*")
	public void exceptionTestTwo() throws Exception {
		throw new IOException("Pass Message test");
	}

	@Test(expectedExceptions = { IOException.class }, expectedExceptionsMessageRegExp = "Pass Message test")
	public void exceptionTestThree() throws Exception {
		throw new IOException("Fail Message test");
	}

	@Test
	public void AddnewTag() {
		System.out.println(" Testing Add new Tag");
	}

	@Test
	public void EditTag() {
		System.out.println(" Testing Edit Tag");
	}

	@Test
	public void ViewTag() {
		System.out.println(" Testing View Tag");
		throw new SkipException("Skipping – This is not ready for testing ");
	}

	@Test
	public void DeleteTag() {
		System.out.println(" Testing Delete Tag");
	}
}
