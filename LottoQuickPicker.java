/**
 * LAB 3 -  Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import java.util.Arrays;
import java.util.Date;

import edu.cuny.csi.csc330.util.Randomizer;

public class LottoQuickPicker {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private static int GAME_COUNT = 1;
	private final static String GAME_NAME = "Lotto"; 
	private final static int SELECTION_POOL_SIZE = 59; 
	private final static int SELECTION_COUNT = 6; 
	private final static String STORE_NAME = "Dan's Deli";
	private int[][] lottoArray = new int[GAME_COUNT][SELECTION_COUNT]; 


/** 
 * Default Constructor that makes a single game.
 */	
	public LottoQuickPicker() {
		init(DEFAULT_GAME_COUNT); 
	} // END LOTTOQUICKPICKER

	
/** 
 * Constructor that creates "games" number of games.
 */
	public LottoQuickPicker(int games) {
		GAME_COUNT = games;
		init(games); 
	} // end LOTTOQUICKPICKER
  
	/*
	 * This method will create a unique array of ints
	 * and sort them in ascending order and return the array
	 * @param sizeOfArray represents the size of the array that will be created and returned
	 * @return An int 2D array of unique integers sorted in ascending order.
	 */
	public int[][] uniqueNumArray() {
		int[][] uniqueArray = new int[GAME_COUNT][SELECTION_COUNT];
		
		/*
		 * 1. For loop to generate a unique number from 1 to 59
		 * in each index.
		 * 2. Another for-loop once complete to check for non-unique numbers
		 * 3. If any ints are the same, add or subtract one to the element and run again.
		 * 4. Return the array.
		 */
		
		for (int i = 0; i < GAME_COUNT; i++) {
			for (int j = 0; j < SELECTION_COUNT; j++) {
				uniqueArray[i][j] = Randomizer.generateInt(1,SELECTION_POOL_SIZE);
			}
			// Sort the i'th array row
			Arrays.sort(uniqueArray[i]);
		} // end for loop
		return uniqueArray;
		
	} // END UNIQUENUMARRAY
	
/** 
 * 
 * @param games An integer that is the number of games that will be generated.
 */
	private void init(int games) {
		
		/**
		 * 
		 * Now what ... START FROM HERE 
		 * What additional methods do you need?
		 * What additional data properties/members do you need? 
		 */

		lottoArray = Arrays.copyOf(uniqueNumArray(), lottoArray.length);
	}
	


	/**
	 * @param gameNumber An int that will be used to display what game number we're on
	 */
	public void displayTicket() {
		
		/**
		 * display heading 
		 * Game ticket should display a game specific heading including date/time.
		 * 
		 * for i in gameCount 
		 * 		generate selectionCount number of unique random selections in ascending order
		 * 		 * Each game will be numbered/indexed - 1,2,3 ... n
		 *      game numbers will be evenly spaced/formatted and single digit nums will be padded
		 *      with a leading 0.
		 *        		
		 * 
		 * display footer 
		 */
		
		
		
		// display ticket heading 
		displayHeading(); 
		
		
		
		/**
		 * Display selected numbers 
		 */
		// Iterate through each row, which is a single lotto QP game
		// Display each game number as "i+1".
		// Display each element of the rows, zero padded
		for (int i = 0; i < lottoArray.length; i++) {
			System.out.printf("(%d)   ", i+1);
			for (int j = 0; j < lottoArray[i].length; j++) {
				System.out.printf(" %02d ", lottoArray[i][j]);
			}
			System.out.println();
		}
		

		
		
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
	 System.out.println("-----------------------------------");
	 System.out.println("-------------- " + GAME_NAME + " --------------");
	 Date today = new Date();
	 System.out.printf("    %s", today);
	 System.out.println();
	 System.out.println();
	}
	
	protected void displayFooter() {
		 //calculateOdds();
		System.out.println();
		System.out.println();
		 System.out.println("--------- (c) " + STORE_NAME + " ----------");
		 System.out.println("-----------------------------------");

	}
	
	
	/**
	 * 
	 * @return
	 */
	private long calculateOdds() {
		
		return 0;
	}
  

	/**
	 * @param args String passed from the command line
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = DEFAULT_GAME_COUNT; 
				
		if(args.length > 0) {  // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]);  // [0] is the 1st element!
			GAME_COUNT = numberOfGames;
		}
		
		LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
		// now what 
		 
		lotto.displayTicket(); 
	}

}
