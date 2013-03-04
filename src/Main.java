import java.math.BigDecimal;
import java.util.Scanner;

import fhv.math.EquationFormatUtil;
import fhv.math.EquationUtil;


public class Main {

	public static void main(String[] args) {
		String theEquation = null;
		Scanner scanner = new Scanner(System.in);
		
		BigDecimal[] calculatedXValues = null;
		String aPart, bPart, cPart = null;
		String aPartConst, bPartConst = null;
		
		String failedMessage = "Sorry this release unfortunately can't calculate the equation you entered ...";
		String pleaseEnterEquationMessage = "Please enter a quadratic equation to solve or 'exit': ";
		
		if(scanner != null) {
			System.out.println("Welcome ...");
			System.out.println("Example equations: ");
			System.out.println("x^2-1x-6=0 -> results in (x1: 3.00 and x2: -2.00");
			System.out.println("4x^2-12x-40=0 -> results in (x1: 5:00 and x2: -2.00");
			System.out.println("----------------------------------------------------------");
			System.out.println(pleaseEnterEquationMessage);
			
			while(!"exit".equals(theEquation)) {
				theEquation = scanner.nextLine();
				calculatedXValues = null;
				aPart = EquationFormatUtil.getAPartOfQuadraticZeroEquation(theEquation);
				bPart = EquationFormatUtil.getBPartOfQuadraticZeroEquation(theEquation);
				cPart = EquationFormatUtil.getCPartOfQuadraticZeroEquation(theEquation);
				if(aPart != null && bPart != null & cPart != null) {
					aPartConst = EquationFormatUtil.getQuadraticAPartConstant(aPart);
					bPartConst = EquationFormatUtil.getQuatdraticBPartConstant(bPart);
					if(aPartConst != null && bPartConst != null) {
						calculatedXValues = EquationUtil.solveQuadraticZeroEquation(
													new BigDecimal(aPartConst),
													new BigDecimal(bPartConst), 
													new BigDecimal(cPart));
					}
				}
				if(calculatedXValues != null) {
					System.out.println("x1: "+calculatedXValues[0]);
					System.out.println("x2: "+calculatedXValues[1]);
				} else {
					System.out.println(failedMessage);
				}
				System.out.println(pleaseEnterEquationMessage);
			}
			
			System.out.println("By by ...");
			scanner.close();
		}
	}

}
