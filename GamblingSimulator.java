package com.bridgelabz;
import java.util.*;

public class GamblingSimulator {
	private static final int DAILY_STAKE=100;
    private static final int GAME_BET=1;
   private static final Random random = new Random();
   private static final int IS_WON=1;


   public static void main(String[] args) {


        //int i=1;
        int j=1;
        int totalWon=0;
        int totalLoss=0;

        int winMax=0;
        int lossMax=0;
        int luckDay=0;
        int unluckDay=0;
        while(j<20)
        {
            int winCount = 0;
            int loseCount=0;
            int i=1;
            while (i <= DAILY_STAKE) {
                int betResult = random.nextInt(2);
                //System.out.println(betResult);
                if (betResult == IS_WON)
                    winCount++;
                else
                    loseCount++;
                if (winCount == DAILY_STAKE / 2) {
                    System.out.println("Won 50% Daily Stake for the Day");
                    break;
                }
                if (loseCount == DAILY_STAKE / 2) {
                    System.out.println("Loss 50% Daily Stake for the Day");
                    break;
                }
                i++;

                //System.out.println();
            }
            //This is Day Count
             totalWon=totalWon+winCount;
            totalLoss=totalLoss+loseCount;
            int diff=winCount-loseCount;
            if(diff>0)
                System.out.println("Day " + j + " Win " + winCount + " Loss " + loseCount+" Won By "+diff);
            else
                System.out.println("Day " + j + " Win " + winCount + " Loss " + loseCount+" Lost By "+(-diff));

            if(winCount>winMax) {
                winMax = winCount;
               luckDay=j;
            }
            if (loseCount>lossMax) {
                lossMax = loseCount;
                unluckDay=j;
            }

            j++;

        }

       System.out.println("Total Win " +totalWon);

       System.out.println("Total Loss " +totalLoss);
       System.out.println("Luckesty Day "+luckDay+"  Won by "+winMax);
       System.out.println("Unluckesty Day "+unluckDay+"  Lost by "+lossMax);

	    }
	}
