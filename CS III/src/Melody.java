// Iris T
// CS 3 Summer 2022-2023
// Assignment 12
// Creates and manipulates a melody, made of note objects
// Melody
// 7/22/22

import java.util.*;

public class Melody {
	
	// Queue of note objects --> song
	private Queue<Note> song;
	
	/*
	 * Constructor for Melody object
	 * 
	 * @param song	queue of note objects
	 */
	public Melody(Queue<Note> song) {
		if (song == null) {
			throw new IllegalArgumentException();
		}
		this.song = song;
	}
	
	/*
	 * Calculates the total length of the song
	 * including repeated sections
	 * 
	 * @return total length in seconds
	 */
	public double getLength() {
		double totalTime = 0;
		
		// Goes through every note in the queue
		for (int i = 0; i < song.size(); i++) {
			// Removes the node, adds to the total time, and adds it back to the queue
			Note removedNote = song.remove();
			totalTime += removedNote.getDuration();
			song.add(removedNote);
			
			// If the note is the start of a repeating section
			if (removedNote.isRepeat()) {
				// Creates a new note queue and adds the note
				Queue<Note> repeated = new LinkedList<Note>();
				repeated.add(removedNote);
				
				// Whether the next note is the end of the repeating section
				boolean check;
				// Goes through notes in the repeating section
				// Do-while loop so it runs at least once
				do {
					// Adds to i so the outer for loop knows notes have been processed
					i++;
					// Updates check
					check = song.peek().isRepeat();
					Note repeatedNode = song.remove();
					totalTime += repeatedNode.getDuration();
					song.add(repeatedNode);
					repeated.add(repeatedNode);
				}
				while(!check);
				
				// Goes through repeated notes again
				while (!repeated.isEmpty()) {
					totalTime += repeated.remove().getDuration();
				}
				
			}
			
		}
		return totalTime;
	}
	
	/*
	 * Returns a text representation of the melody
	 * 
	 * @return string of the notes in the melody
	 */
	public String toString() {
		String allNotes = "";
		// Goes through notes in the song and adds them to the string
		for (int i = 0; i < song.size(); i++) {
			Note removedNote = song.remove();
			allNotes += removedNote + "\n";
			song.add(removedNote);
		}
		return allNotes;
	}
	
	/*
	 * Changes the duration of all notes
	 * 
	 * @param tempo	how much faster/slower the notes will be
	 */
	public void changeTempo(double tempo) {
		if (tempo <= 0) {
			throw new IllegalArgumentException();
		}
		// Goes through all notes in the song and sets their duration
		for (int i = 0; i < song.size(); i++) {
			Note removedNote = song.remove();
			double oldDuration = removedNote.getDuration();
			removedNote.setDuration(oldDuration/tempo);
			song.add(removedNote);
		}
	}
	
	/*
	 * Reverses the notes of the song
	 */
	public void reverse() {
		// Temporary stack
		Stack<Note> temp = new Stack<Note>();
		// Transfers all notes from queue to stack
		while (!song.isEmpty()) {
			temp.push(song.remove());
		}
		// Transfers all notes from stack to queue, will be reversed
		while (!temp.isEmpty()) {
			song.add(temp.pop());
		}
	}
	
	/*
	 * Adds the notes of one melody to the end of the current melody
	 * 
	 * @param other	melody to append
	 */
	public void append(Melody other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}
		// Goes through notes from the other melody and adds them to this melody
		for (int i = 0; i < other.song.size(); i++) {
			Note removedNote = other.song.remove();
			song.add(removedNote);
			other.song.add(removedNote);
		}
	}
	
	/*
	 * Plays the melody, note by note
	 */
	public void play() {
		// Goes through all notes in the song and plays them
		for (int i = 0; i < song.size(); i++) {
			Note removedNote = song.remove();
			removedNote.play();
			song.add(removedNote);
			
			// If the note is the beginning of a repeating section
			if (removedNote.isRepeat()) {
				// New queue for the repeated notes, adds beginning note
				Queue<Note> repeated = new LinkedList<Note>();
				repeated.add(removedNote);
				
				// Whether the note is the end of the repeated section
				boolean check;
				// Goes through every repeated note
				// Do-while loop so it runs at least once
				do {
					// Adds to i so the for loop knows notes have been processed
					i++;
					// Updates check
					check = song.peek().isRepeat();
					Note repeatedNote = song.remove();
					repeatedNote.play();
					song.add(repeatedNote);
					repeated.add(repeatedNote);
				} while (!check);
				
				// Goes through repeated notes and plays them again
				while (!repeated.isEmpty()) {
					repeated.remove().play();
				}
				
			}
			
			
		}
	}

}
