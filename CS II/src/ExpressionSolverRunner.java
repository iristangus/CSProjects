// Iris T
// CS 2 Summer 2022-2023
// Expression Solver
// Tests and runs ExpressionSolver
// ExpressionSolverRunner
// 7/5/22
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.*;
import static java.lang.System.*;

public class ExpressionSolverRunner {
	
	/*
	 * calls upon ExpressionSolver for various expressions
	 */
	public static void main( String args[] ){
		
		ExpressionSolver.solveExpression("3 + 5");
		ExpressionSolver.solveExpression("3 * 5");
		ExpressionSolver.solveExpression("3 - 5");
		ExpressionSolver.solveExpression("3 / 5");
		ExpressionSolver.solveExpression("5 / 5 * 2 + 8 / 2 + 5");
		ExpressionSolver.solveExpression("5 * 5 + 2 / 2 - 8 + 5 * 5 - 2");
        
	}
}