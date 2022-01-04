package com.bridgelabz;
import java.util.*;

public class GamblingSimulator {
	Scanner sc = new Scanner(System.in);
	private static final int stakeCost = 100;
    private static final int stakeBetCost = 1;
    
	public static void main(String[] args) {
		
	       System.out.println("Welcome to the Gambling Simulator!");
//	        initializing random to generate values for win or loss decision
	        Random random = new Random();
	        int betResult = random.nextInt(2);
//	        a function to check if the gambler wins or looses
	        winOrLoss(betResult);
	}
	
	 static void winOrLoss(int betResult){
//       win
       if(betResult == 1){
           System.out.println("Gambler Wins!");
       }
//       loss
       else{
           System.out.println("Gambler Losses!");
       }
  }
}
