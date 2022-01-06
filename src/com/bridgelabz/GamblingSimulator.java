package com.bridgelabz;
import java.util.*;

public class GamblingSimulator {
	Scanner sc = new Scanner(System.in);
	private static final int stakeCost = 100;
    private static final int stakeBetCost = 1;
    private static final int BET_WIN = 1;
    
      
    //Array Variables for Win or Loose Count
    private static int[] winCountArr = new int[20];
    private static int[] looseCountArr = new int[20];
    private static String[] dayStatus = new String[20];
    private static int[] luckyDays = new int[20];
    private static int[] unluckyDays = new int[20];
    private static int luckyDayCount = 0;
    private static int unluckyDayCount = 0;
    private static String playChoice;
    
    //Random Class Object for Playing Status
    private static Random randamStatus = new Random();

    //Method to Show the Status of Gambler
    private static void showGamblerStatus() {
        System.out.println("Per Day Stack : $"+ stakeCost);
        System.out.println("Bet Per Game : $"+ stakeBetCost);
    }
    
	
	 public static void winOrLoss(int i){
		 
		//Winning and Loosing Amount
	        int winStack = 0;
	        int looseStack = 0;
	        int winCount = 0;
	        int looseCount = 0;
	        
	      //Simulating the Game Until Win or Loose Reach 50% of Day Stack
	        while(true) {
	            int gameStatus = randamStatus.nextInt(2) + 1;
	            if (gameStatus == BET_WIN) {
	                winCount++;
	                winStack += stakeBetCost;
	                //System.out.println("Win the GAME !!! WIN STACK : " + winStack);
	            } else {
	                looseCount++;
	                looseStack += stakeBetCost;
	                //System.out.println("Loose the Game. LOOSE STACK :" + looseStack);
	            }
	            //Checking for the Winning Stack is 50% of PER DAY STACK
	            if(winStack == stakeCost / 2) {
	                //Adding Won Status for the Day
	                luckyDays[luckyDayCount] = i+1;
	                luckyDayCount++;
	                System.out.println("Win Stack is 50% of PER DAY STACK. So, Gambler Resigning for the DAY.");
	                break;
	            }
	            //Checking for the Winning Stack is 50% of PER DAY STACK
	            if(looseStack == stakeCost	 / 2) {
	                //Adding Lost Status for the Day
	                unluckyDays[unluckyDayCount] = i+1;
	                unluckyDayCount++;
	                System.out.println("Loose Stack is 50% of PER DAY STACK. So, Gambler is Resigning for the DAY");
	                break;
	            }
	        }

	        //Win and Loose Counter Array Storing Values
	        winCountArr[i] = winCount;
	        looseCountArr[i] = looseCount;
	    }
	

	//Method to Print the Win and Loose Count for 20 Days
	    private static void showWinLooseCount() {
	        for(int i= 0; i < 20; i++) {
	        	System.out.println("Gambler has "+ dayStatus[i] +" Games on Day "+ (i+1));
	            System.out.println("Day "+ (i+1) +" Total Win Count :"+ winCountArr[i]);
	            System.out.println("Day "+ (i+1) +" Total Loose Count :"+ looseCountArr[i]);
	            
	        }
	    }
	    
	    //Method to check luckiest and unluckiest day
	    private static void luckyUnluckyDay() {
	        //Showing the Luckiest Days of Gambler
	        for(int i = 0; i < luckyDayCount; i++) {
	            System.out.println("Luckiest Day : "+luckyDays[i]);
	        }
	        //Showing the Unluckiest Days of Gambler
	        for(int i = 0; i < unluckyDayCount; i++) {
	            System.out.println("Unluckiest Day : "+unluckyDays[i]);
	        }
	    }

	    public static void main(String[] args) {
	        //Starting Message for User
	        System.out.println("Welcome to Gambling Simulation Problem developed by Tahir Mansuri.");

	        //Shows the Initial Status of Gambler
	        showGamblerStatus();

	        //Starting the Game Play for a day and Ask for Continue to next Month if Won
	        do {
	            for (int i = 0; i < 20; i++) {
	                System.out.println("Day " + (i + 1) + " Play Start.");
	                winOrLoss(i);
	                System.out.println("Day " + (i + 1) + " Play End.");
	            }
	            //Method for Showing 20Days Win Loose Counter
	            showWinLooseCount();

	            //Method call for Checking the Luckiest and Unluckiest Days
	            luckyUnluckyDay();
	            if(luckyDayCount > unluckyDayCount) {
	                System.out.println("You have Won Maximum Days in this Month. \nSo, Do you want to continue ? (Y / N) :");
	                Scanner sc = new Scanner(System.in);
	                playChoice = sc.next();
	                luckyDayCount = 0;
	                unluckyDayCount = 0;

	            } else {
	                System.out.println("You have Lost Many Times as compare to Wining Days. \nSo, Quit the Game.");
	                break;
	            }
	        } while(playChoice.equalsIgnoreCase("Y") || playChoice.equalsIgnoreCase("y"));


	    }
	}
