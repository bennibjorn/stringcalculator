package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testOneNumber2() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    // 3rd Kata step
    
    @Test
    public void testNewLineDelimiter() {
        assertEquals(3, Calculator.add("1/n2"));
    }
    @Test
    public void testNewlineDelimiter() {
        assertEquals(60, Calculator.add("10/n20/n30"));
    }
    @Test
    public void testNewlineAndComma() {
        assertEquals(10, Calculator.add("3/n5,2"));
    }
    @Test
    public void testDifferentDelimiter() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
    @Test
    public void testDifferentDelimiter2() {
        assertEquals(6, Calculator.add("//;\n1;2;3"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegatives1() {
        assertEquals("Negatives not allowed: -2", Calculator.add("1,-2"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegatives2() {
        assertEquals("Negatives not allowed: -1, -4", Calculator.add("-1,2,3,-4"));
    }
    @Test
    public void testOver1000() {
    	assertEquals(1, Calculator.add("1, 1001"));
    }
    @Test
    public void testOver1000again() {
    	assertEquals(6, Calculator.add("1,2,3,5000"));
    }

}