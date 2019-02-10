package ru.job4j.calculate;

/**
 * Calculate. The home of a 'Hello World' method
 *
 * @author Denis Abakumov
 */
public class Calculate {

	/**
	 * Main method, the app's entry point
	 * 
	 * @param args - CLI arguments. Not used
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	/**
	 * Method echo.
	 * 
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}