package fhv.tests;

import java.math.BigDecimal;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import fhv.math.EquationFormatUtil;
import fhv.math.EquationUtil;

@RunWith(JUnit4.class)
public class EquationFormatUtilTest {
	
	//TEST validate and prepare quadratic equation --------------------------------------------------
	
	@Test
	public void test1_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "10x^2 - x + 2 = 1";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals(null, prepared);
	}
	@Test
	public void test2_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "x^2 + x + 2 = 0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals("x^2+x+2=0", prepared);
	}
	@Test
	public void test3_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "x^2 + 2x +       2 = 0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals("x^2+2x+2=0", prepared);
	}
	@Test
	public void test4_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "x^2+2d+2=0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals(null, prepared);
	}
	@Test
	public void test5_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "1x^2+x+2";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals(null, prepared);
	}
	@Test
	public void test6_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "-1x^2+x+2=0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals("-1x^2+x+2=0", prepared);
	}
	@Test
	public void test7_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "-x^2+x+2=0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals(null, prepared);
	}
	@Test
	public void test8_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "-1x^2 - x  + 2=0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals("-1x^2-x+2=0", prepared);
	}
	@Test
	public void test9_validateAndPrepareQadraticZeroEquation() {
		String equationStr = "-1x^2 -- x  + 2=0";
		String prepared = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(equationStr);
		Assert.assertEquals(null, prepared);
	}

	//TEST A Part extraction ----------------------------------------------------------------
	
	@Test
	public void test1_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "12x^2 + 10x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("12x^2", aPart);
	}
	@Test
	public void test2_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "3x^2 + x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("3x^2", aPart);
	}
	@Test
	public void test3_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 + 22x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("x^2", aPart);		
	}
	@Test
	public void test4_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "22x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals(null, aPart);		
	}
	@Test
	public void test5_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 + 22x + 10 + 10x^2 + 2x + 2 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals(null, aPart);
	}
	@Test
	public void test6_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "-2x^2 + 22x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("-2x^2", aPart);
	}
	@Test
	public void test7_GetAPartOfQuadraticZeroEquation() {
		String equationStr = "-2x^2 +- 22x + 10 = 0";
		String aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals(null, aPart);
	}
	
	//TEST Get Constant of A Part ----------------------------------------------------------------
	
	@Test
	public void test1_GetQuadraticAPartConstant() {
		String str = "-2x^2";
		String c = EquationFormatUtil.getQuadraticAPartConstant(str);
		Assert.assertEquals("-2", c);
	}
	@Test
	public void test2_GetQuadraticAPartConstant() {
		String str = "x^2";
		String c = EquationFormatUtil.getQuadraticAPartConstant(str);
		Assert.assertEquals("1", c);
	}
	@Test
	public void test3_GetQuadraticAPartConstant() {
		String str = "-x^2";
		String c = EquationFormatUtil.getQuadraticAPartConstant(str);
		Assert.assertEquals(null, c);
	}
	
	
	//TEST B Part extraction ----------------------------------------------------------------
	
	@Test
	public void test1_GetBPartOfQuadraticZeroEquation() {
		String equationStr = "-2x^2 - 22x + 10 = 0";
		String bPart = EquationFormatUtil.getBPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("-22x", bPart);
	}
	@Test
	public void test2_GetBPartOfQuadraticZeroEquation() {
		String equationStr = "-2x^2 +- 22x + 10 = 0";
		String bPart = EquationFormatUtil.getBPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals(null, bPart);
	}
	@Test
	public void test3_GetBPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 - x + 10 = 0";
		String bPart = EquationFormatUtil.getBPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("-x", bPart);
	}
	@Test
	public void test4_GetBPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 + 1x + 10 = 0";
		String bPart = EquationFormatUtil.getBPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("+1x", bPart);
	}
	
	//TEST Get Constant of B Part ----------------------------------------------------------------
	
	@Test
	public void test1_GetQuadraticBPartConstant() {
		String str = "-x";
		String c = EquationFormatUtil.getQuatdraticBPartConstant(str);
		Assert.assertEquals("-1", c);
	}
	@Test
	public void test2_GetQuadraticBPartConstant() {
		String str = "-2x";
		String c = EquationFormatUtil.getQuatdraticBPartConstant(str);
		Assert.assertEquals("-2", c);
	}
	@Test
	public void test3_GetQuadraticBPartConstant() {
		String str = "+2x";
		String c = EquationFormatUtil.getQuatdraticBPartConstant(str);
		Assert.assertEquals("2", c);
	}
	
	//TEST C Part extraction ----------------------------------------------------------------
	
	@Test
	public void test1_GetCPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 + 1x + 10 = 0";
		String cPart = EquationFormatUtil.getCPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("+10", cPart);
	}
	@Test
	public void test2_GetCPartOfQuadraticZeroEquation() {
		String equationStr = "x^2 + 1x - 22222 = 0";
		String cPart = EquationFormatUtil.getCPartOfQuadraticZeroEquation(equationStr);
		Assert.assertEquals("-22222", cPart);
	}
	
	//TEST Solve Quadratic Equation ----------------------------------------------------------------
	
	@Test
	public void test1_solveQuadraticZeroEquation() {
		BigDecimal aPartConstant = new BigDecimal("1");
		BigDecimal bPartConstant = new BigDecimal("-1");
		BigDecimal cPartConstant = new BigDecimal("-6");
		
		BigDecimal xVals[] = EquationUtil.solveQuadraticZeroEquation(aPartConstant, bPartConstant, cPartConstant);
		
		BigDecimal x1 = new BigDecimal("-2");
		BigDecimal x2 = new BigDecimal("3");
		boolean calculationAsExpected = checkQuadraticEquationOutcome(xVals, x1, x2);
		Assert.assertTrue(calculationAsExpected);
		
	}
	/**
	 * 
	 * @param calculatedValues
	 * @param expectedX1
	 * @param expectedX2
	 * @return false on calculation values are not as expected otherwise true
	 */
	private static boolean checkQuadraticEquationOutcome(BigDecimal[] calculatedValues, BigDecimal expectedX1, BigDecimal expectedX2) {
		boolean retVal = false;
		int foundCtr = 0;
		for(int i = 0; i < 2; i++) {
			if(calculatedValues[i].equals(expectedX1) || calculatedValues[i].equals(expectedX2))
				foundCtr++;
		}
		if(foundCtr == 2) {
			retVal = true;
		}
		return retVal;
	}
}
