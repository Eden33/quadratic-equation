package fhv.tests;

import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.Test;

import fhv.math.EquationUtil;

public class EquationUtilTest {
	@Test
	public void test1_solveQuadraticZeroEquation() {
		BigDecimal aPartConstant = new BigDecimal("1");
		BigDecimal bPartConstant = new BigDecimal("-1");
		BigDecimal cPartConstant = new BigDecimal("-6");
		
		BigDecimal xVals[] = EquationUtil.solveQuadraticZeroEquation(aPartConstant, bPartConstant, cPartConstant);
		
		BigDecimal x1 = new BigDecimal("-2.00");
		BigDecimal x2 = new BigDecimal("3.00");
		boolean calculationAsExpected = checkQuadraticEquationOutcome(xVals, x1, x2);
		Assert.assertTrue(calculationAsExpected);
		
	}
	@Test
	public void test2_solveQuadraticZeroEquation() {
		BigDecimal aPartConstant = new BigDecimal("4");
		BigDecimal bPartConstant = new BigDecimal("-12");
		BigDecimal cPartConstant = new BigDecimal("-40");
		
		BigDecimal xVals[] = EquationUtil.solveQuadraticZeroEquation(aPartConstant, bPartConstant, cPartConstant);
		
		BigDecimal x1 = new BigDecimal("5.00");
		BigDecimal x2 = new BigDecimal("-2.00");
		boolean calculationAsExpected = checkQuadraticEquationOutcome(xVals, x1, x2);
		Assert.assertTrue(calculationAsExpected);
		
	}
	@Test
	public void test3_solveQuadraticZeroEquation() {
		BigDecimal aPartConstant = new BigDecimal("1");
		BigDecimal bPartConstant = new BigDecimal("-1");
		BigDecimal cPartConstant = new BigDecimal("-4");
		
		BigDecimal xVals[] = EquationUtil.solveQuadraticZeroEquation(aPartConstant, bPartConstant, cPartConstant);
		
		BigDecimal x1 = new BigDecimal("2.56");
		BigDecimal x2 = new BigDecimal("-1.56");
		boolean calculationAsExpected = checkQuadraticEquationOutcome(xVals, x1, x2);
		Assert.assertTrue(calculationAsExpected);
		
	}

	@Test
	public void test4_solveQuadraticZeroEquation() {
		BigDecimal aPartConstant = new BigDecimal("1");
		BigDecimal bPartConstant = new BigDecimal("0");
		BigDecimal cPartConstant = new BigDecimal("-4");
		
		BigDecimal xVals[] = EquationUtil.solveQuadraticZeroEquation(aPartConstant, bPartConstant, cPartConstant);
		
		BigDecimal x1 = new BigDecimal("2.00");
		BigDecimal x2 = new BigDecimal("-2.00");
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
