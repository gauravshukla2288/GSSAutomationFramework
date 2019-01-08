package mygss.framework.WebAutomation.controller;

import java.util.Collection;

import org.testng.Assert;

public class Assertion {


	public static void assertEquals(boolean actual, boolean expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(byte actual, byte expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(byte[] actual, byte[] expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(char actual, char expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	@SuppressWarnings("rawtypes")
	public static void assertEquals(Collection actual, Collection expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(double actual, double expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(float actual, float expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(int actual, int expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(long actual, long expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(Object actual, Object expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(Object[] actual, Object[] expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(short actual, short expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertEquals(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertFalse(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}

	public static void assertNotNull(Object object, String message) {
		Assert.assertNotNull(object, message);
	}

	public static void assertNotSame(Object actual, Object expected, String message) {
		Assert.assertNotSame(actual, expected, message);
	}

	public static void assertNull(Object object, String message) {
		Assert.assertNull(object, message);
	}

	public static void assertSame(Object actual, Object expected, String message) {
		Assert.assertSame(actual, expected, message);
	}

	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	public static void fail(String message) {
		Assert.fail(message);
	}

	
}
