// Iris T
// CS 3 Summer 2022-2023
// Who won the election
// Using a TreeMap, finds the winner of elections
// Election
// 7/19/22

import java.util.*;
import java.io.*;

public class Election {
	
	/*
	 * Scans election.txt
	 * For each region, stores names and votecount in a map
	 * Finds the name with more than half the votes
	 * Displays winner (or lack thereof)
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("election.txt"));
			
			int regional = scan.nextInt();
			
			// Repeats for each regional election
			for (int i = 0; i < regional; i++) {
				int numVotes = scan.nextInt();
				
				Map<String, Integer> votes = new TreeMap<String, Integer>();
				
				for (int j = 0; j < numVotes; j++) {
					String ballot = scan.next();
					
					// If the key doesn't exist yet, set it to 1
					// Otherwise, add 1 to the count
					if (!votes.containsKey(ballot)) {
						votes.put(ballot, 1);
					} else {
						votes.put(ballot, votes.get(ballot) + 1);
					}
				}
				
				int threshold = numVotes/2;
				boolean hasWinner = false;
				
				// Checks if there's a winner
				for (String key : votes.keySet()) {
					if (votes.get(key) > threshold) {
						System.out.println(key + " won the election.");
						hasWinner = true;
					}
				}
				
				// If nobody has more than half the votes
				if (!hasWinner) {
					System.out.println("Nobody won! A special runoff election will be held.");
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}
