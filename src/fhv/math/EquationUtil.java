package fhv.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EquationUtil {
	
	/**
	 * @param a constant of a part
	 * @param b constant of b part
	 * @param c constant of c part
	 * @return null on failure or BigDecimal[] array of lenth two with x1 and x2
	 */
	public static BigDecimal[] solveQuadraticZeroEquation(BigDecimal aPartConst, BigDecimal bPartConst, BigDecimal cPartConst) {
		try {
			BigDecimal bPow = bPartConst.pow(2);
			BigDecimal four = new BigDecimal("4");
			BigDecimal valueToGetSqrtFrom = bPow.subtract(aPartConst.multiply(cPartConst).multiply(four));
			
			double sqrt = Math.sqrt(valueToGetSqrtFrom.doubleValue());
			
			BigDecimal numeratorXOne = bPartConst.negate().add(new BigDecimal(sqrt));
			BigDecimal numeratorXTwo = bPartConst.negate().subtract(new BigDecimal(sqrt));
			BigDecimal x1 = numeratorXOne.divide(new BigDecimal("2").multiply(aPartConst));
			BigDecimal x2 = numeratorXTwo.divide(new BigDecimal("2").multiply(aPartConst));
			x1 = x1.setScale(2, RoundingMode.HALF_UP);
			x2 = x2.setScale(2, RoundingMode.HALF_UP);
			
			BigDecimal[] result = new BigDecimal[2];
			result[0] = x1;
			result[1] = x2;
			return result;	
		} catch(Exception e) {
			//System.out.println("Exception caught in solveQuadraticZeroEquation: "+e.toString());
			return null;
		}
	}
}
