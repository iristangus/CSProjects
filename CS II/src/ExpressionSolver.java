// Iris T
// CS 2 Summer 2022-2023
// Expression Solver
// Solves an expression using an ArrayList
// ExpressionSolver
// 7/5/22

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.*;
import static java.lang.System.*;


public class ExpressionSolver
{
	
    /*
     * solves the expression and displays the output
     * @param s	string of the expression
     */
	public static void solveExpression(String s){
		
		System.out.print(s + " = ");
		
		String[] splitStr = s.split(" ");
		ArrayList <String> expression = new ArrayList<String>(Arrays.asList(splitStr));
		
		// multiplication & division
		while (expression.contains("*") == true || expression.contains("/") == true) {
			int operator1 = expression.indexOf("*");
			int operator2 = expression.indexOf("/");
			int operator = 1;
			if (operator1 == -1 || operator2 == -1) {
				operator = Math.max(operator1, operator2);
			} else if (operator1 != -1 && operator2 != -1){
				operator = Math.min(operator1, operator2);
			}

			int operand1 = Integer.parseInt(expression.get(operator - 1));
			int operand2 = Integer.parseInt(expression.get(operator + 1));
			int newValue;
			if (expression.get(operator).equals("*")) {
				newValue = operand1 * operand2;
			} else {
				newValue = operand1 / operand2;
			}
			for (int i = 0; i < 3; i++) {
				expression.remove(operator-1);
			}
			expression.add(operator-1, String.valueOf(newValue));
			
		}
		
		
			// addition & subtraction
			while (expression.contains("+") == true || expression.contains("-") == true) {
				int operator1 = expression.indexOf("+");
				int operator2 = expression.indexOf("-");
				int operator = 0;
				if (operator1 == -1 || operator2 == -1) {
						operator = Math.max(operator1, operator2);
				} else if (operator1 != -1 && operator2 != -1){
						operator = Math.min(operator1, operator2);
				}

				int operand1 = Integer.parseInt(expression.get(operator - 1));
				int operand2 = Integer.parseInt(expression.get(operator + 1));
				int newValue;
				if (expression.get(operator).equals("+")) {
					newValue = operand1 + operand2;
				} else {
					newValue = operand1 - operand2;
				}
				expression.remove(operator-1);
				expression.remove(operator-1);
				expression.set(operator-1, String.valueOf(newValue));
					
				}
				
			System.out.println(expression.get(0));
		
		}
		
		
	}

	
