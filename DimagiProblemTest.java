package dimagi;

import static org.junit.Assert.*;

import org.junit.Test;

public class DimagiProblemTest {
	DimagiProblem d = new DimagiProblem();

	@Test
	public void testConversion() {
		assertEquals("zero", d.intToSpoken(0));
		assertEquals("five", d.intToSpoken(5));
		assertEquals("fourteen", d.intToSpoken(14));
		assertEquals("five hundred", d.intToSpoken(500));
		assertEquals("six hundred eighty", d.intToSpoken(680));
		assertEquals("nine thousand eight hundred five", d.intToSpoken(9805));
		assertEquals("sixty five thousand two", d.intToSpoken(65002));
		assertEquals("one thousand", d.intToSpoken(1000));
		assertEquals("five hundred thousand", d.intToSpoken(500000));
		assertEquals("six million", d.intToSpoken(6000000));
		assertEquals("six million five hundred eighty nine thousand two hundred thirty five", d.intToSpoken(6589235));
		assertEquals("seventy billion", d.intToSpoken(70000000000L));
		assertEquals("seventy billion four", d.intToSpoken(70000000004L));
		assertEquals("three hundred million twenty thousand", d.intToSpoken(300020000L));
		assertEquals("three hundred quadrillion", d.intToSpoken(300000000000000000L));
		assertEquals("nine quintillion two hundred twenty three quadrillion three hundred seventy two trillion thirty six billion eight hundred fifty four million seven hundred seventy five thousand eight hundred seven", d.intToSpoken(Long.MAX_VALUE));
	}

}
