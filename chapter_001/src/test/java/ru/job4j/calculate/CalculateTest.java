package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Denis Abakumov";
		String expected = "Echo, echo, echo : Denis Abakumov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expected));
	}

}