// Iris T
// CS 2 Summer 2022-2023
// TicTacToe Lab
// Displays the results of several tictactoe games
// TicTacToe
// 6/30/22

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
	
	/*
	 * Scans TicTacToe.txt for the game information, then creates a 2D array with the games
	 * Checks if there are any horizontal, vertical, or diagonal wins
	 * Displays individual games and the outcomes
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("C:\\Users\\irist\\eclipse-workspace\\CS II\\src\\TicTacToe.txt"));
			int numGames = scan.nextInt();
			String[][] gameArray = new String[numGames][9];
			
			for (int r = 0; r < numGames; r++) {
				String str = scan.next();
				for (int c = 0; c < str.length(); c++) {
					gameArray[r][c] = str.substring(c, c+1);
				}
			}
			
			for (String[] ray:gameArray) {
				
				//print game
				for (int i = 0; i < ray.length; i++) {
					if ((i + 1) % 3 != 0) {
						System.out.print(ray[i] + " ");
					} else {
						System.out.println(ray[i]);
					}
				}
				
				//horizontal check
				String winnerH = "";
				for (int i = 0; i < 3; i++) {
					int index = 3*i;
					String first = ray[index];
					if (ray[index + 1].equals(first) && ray[index + 2].equals(first)) {
							winnerH = first;
					}

				}
				
				
				//vertical check
				String winnerV = "";
				for (int i = 0; i < 3; i++) {
					String first = ray[i];
					if (ray[3+i].equals(first) && ray[6+i].equals(first)) {
						winnerV = first;
					}
				}
				
				
				//diagonal checks
				String winnerD = "";
				String first = ray[0];
				if (ray[4].equals(first) && ray[8].equals(first)) {
					winnerD = first;
				}
				
				first = ray[2];
				if (ray[4].equals(first) && ray[6].equals(first)) {
					winnerD = first;
				}
				
				
				//print results
				if (!winnerH.equals("")) {
					System.out.println(winnerH + " wins horizontally!");
				} else if(!winnerV.equals("")) {
					System.out.println(winnerV + " wins vertically!");
				} else if(!winnerD.equals("")) {
					System.out.println(winnerD + " wins diagonally!");
				} else {
					System.out.println("cat's game - no winner!");
				}
				
				
				System.out.println();
			}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}

}
}
