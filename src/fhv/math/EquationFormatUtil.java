package fhv.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationFormatUtil {

	/**
	 * @param theEquation - the quadratic equation like "ax^2 + bx + c = 0"
	 * @return null on format error, else the c constant of the A part -> ax^2
	 */
	public static String getAPartOfQuadraticZeroEquation(String theEquation) {
		String retVal = null;
		theEquation = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(theEquation);
		if(theEquation != null) {
			Pattern p = Pattern.compile("^((\\+|-)?\\d+|\\d*)x\\^2");
			Matcher m = p.matcher(theEquation);
			if(m.find()) {			
				retVal = m.group();
			}	
		}
		return retVal;
	}
	/**
	 * @param theEquation - the quadratic equation like "ax^2 + bx + c = 0"
	 * @return null on format error, else the b constant of the B part -> bx
	 */
	public static String getBPartOfQuadraticZeroEquation(String theEquation) {
		String retVal = null;
		theEquation = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(theEquation);
		if(theEquation != null) {
			Pattern p = Pattern.compile("(\\+|-)\\d*x(\\+|-)");
			Matcher m = p.matcher(theEquation);
			if(m.find()) {			
				retVal = m.group();
				retVal = retVal.substring(0, retVal.length() - 1);
			}	
		}
		return retVal;
	}
	
	/**
	 * @param theEquation - the quadratic equation like "ax^2 + bx + c = 0"
	 * @return null on format error, else the c constant of the C part -> c
	 */
	public static String getCPartOfQuadraticZeroEquation(String theEquation) {
		String retVal = null;
		theEquation = EquationFormatUtil.validateAndPrepareQadraticZeroEquation(theEquation);
		if(theEquation != null) {
			Pattern p = Pattern.compile("(\\+|-)\\d+=");
			Matcher m = p.matcher(theEquation);
			if(m.find()) {			
				retVal = m.group();
				retVal = retVal.substring(0, retVal.length() - 1);
			}	
		}
		return retVal;
	}
	
	
	/**
	 * @param str - the a part like "ax^2"
	 * @return null on format error, else the a
	 */
	public static String getQuadraticAPartConstant(String str) {
		String retVal = null;
		if(str != null) {
			try {
				str = str.replace("x^2", "");
				if(str.length() == 0) {
					str = "1";
				}
				Integer i = new Integer(str);
				retVal = i.toString();
			} catch(NumberFormatException e) { }
		}
		return retVal;
	}
	/**
	 * @param str - the b part like "(-|+)bx"
	 * @return null on format error, else the b
	 */
	public static String getQuatdraticBPartConstant(String str) {
		String retVal = null;
		if(str != null) {
			try {
				str = str.replace("x", "");
				//if string only contains (-|+)
				if(str.length() == 1) {
					str += "1";
				}
				Integer i = new Integer(str);
				retVal = i.toString();
			} catch(NumberFormatException e) { }
		}
		return retVal;
	}
	
	/**
	 * Validates and prepares the String for further processing.
	 * First the method removes all whitespaces and validating the correct form of passed quadratic equation.
	 * 
	 * Valid form of quadratic equation is "((+|-)a+|a*)x^2 (+|-) b*x (+|-) c = 0"
	 * 
	 * If you call other methods of this Utility class you normally must not call this function directly.
	 * 
	 * @param theEquation
	 * @return The quadraticEquation without withespaces or null if validation failed.
	 */
	public static String validateAndPrepareQadraticZeroEquation(String theEquation) {
		if(theEquation == null)
			return theEquation;
		theEquation = theEquation.replace(" ", "");
		Pattern p = Pattern.compile("^((\\+|-)?\\d+|\\d*)x\\^2(\\+|-)\\d*x(\\+|-)[1-9]{1}\\d*=0");
		Matcher m = p.matcher(theEquation);
		if(m.find() == false) {			
			theEquation = null;
		}
		return theEquation;	
	}
}
