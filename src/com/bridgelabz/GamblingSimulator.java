package com.bridgelabz;
import java.util.*;

public class GamblingSimulator {
	Scanner sc = new Scanner(System.in);
	private static final int stakeCost = 100;
    private static final int stakeBetCost = 1;
    private static final int BET_WIN = 1;
    
  //Winning and Loosing Amount
    private static int winStack = 0;
    private static int looseStack = 0;
    
    //Random Class Object for Playing Status
    private static Random randamStatus = new Random();

    //Method to Show the Status of Gambler
    private static void showGamblerStatus() {
        System.out.println("Per Day Stack : $"+ stakeCost);
        System.out.println("Bet Per Game : $"+ stakeBetCost);
    }
    
	
	 static void winOrLoss(){
		 while(true) {
	            int gameStatus = randamStatus.nextInt(2) + 1;
	            if (gameStatus == BET_WIN) {
	                winStack += stakeBetCost;
	                System.out.println("Win the GAME !!! WIN STACK : " + winStack);
	            } else {
	                looseStack += stakeBetCost;
	                System.out.println("Loose the Game. LOOSE STACK :" + looseStack);
	            }
	            //Checking for the Winning Stack is 50% of PER DAY STACK
	            if(winStack == stakeCost / 2) {
	                System.out.println("Win Stack is 50% of PER DAY STACK. So, Gambler Resigning for the DAY.");
	                break;
	            }
	            //Checking for the Winning Stack is 50% of PER DAY STACK
	            if(looseStack == stakeCost / 2) {
	                System.out.println("Loose Stack is 50% of PER DAY STACK. So, Gambler is Resigning for the DAY");
	                break;
	            }
	        }
  }

public static void main(String[] args) {
	
    System.out.println("Welcome to the Gambling Simulator program !");
    showGamblerStatus();

    //Starting the Game Play for a day
    winOrLoss();
  }
}