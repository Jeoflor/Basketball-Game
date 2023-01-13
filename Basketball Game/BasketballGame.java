/*
*  This program simulates a one-on-one basketball game.
*  The random() function will generate a random integer
*  from 0 - 3.
*  These numbers represent hte shots that players will make,
*  0 for airball, 1 for freethrow, 2 for 2 Points, 3 for 3 Pointer
*  We keep track of each player's score over the 4 quarters if the game.
*  We are assuming that each player takes a shot in 30 second intervals.
*/

import java.util.Random;      //Needed to generate random #
import java.util.Scanner;     //Needed for keyboard input
public class BasketballGame
{
   public static void main(String [] args)
   {
      final int QUARTERS = 4;
      final int SECONDS = 720;
      
      Random generator = new Random();
      Scanner keyboard = new Scanner(System.in);
      
      int player1Value = 0;
      int player2Value = 0;
      int count = 0;                //inner loop counter
      int player1Score = 0;
      int player2Score = 0;
      String player1Name = " ";
      String player2Name = " ";
      int shot = 0;                 //count of shots taken
      String winner = " ";          //Name of winner
      String player1Shot = " ";     //"Air Ball", "Free throw", etc
      String player2Shot = " ";
      String runProgram = " ";
      int winningScore = 0;
      
      System.out.print("March Madness is next month. Let's play a one-on-one game with 2 of ");
      System.out.println("your favorite players.");
      System.out.println("Please enter PLAY to play the game or STOP to quit.");
      runProgram = keyboard.nextLine();
      runProgram = runProgram.toUpperCase();
      
      while (runProgram.equals ("PLAY"))
      {
         System.out.println("Please enter the name of Player 1:");
         player1Name = keyboard.nextLine();
         System.out.println("Please enter the name of Player 2:");
         player2Name = keyboard.nextLine();
         
         player1Score = 0;                //re-initializing this for each new game
         player2Score = 0;
         shot = 0;
         
         for (int i = 1; i <= 4; i++)     //Outer for  loop in count quarters from 1 to 4
         {
            System.out.printf("%-30s%-10s%30s\n", "*****************", ("Quarter " + i), "*****************");
            System.out.printf("%-10s%-14s%-14s%-14s%-14s\n", "Shot#", (player1Name + " Shot"), (player1Name + " Score"), (player2Name + " Shot"), (player2Name + " Score"));
            for (count = 720; count > 0; count-=30)
            {
               player1Value = generator.nextInt(4); //Will generate 0, 1, 2, 3 (Use a value 1 higher than what you need)
               player2Value = generator.nextInt(4);
               shot = shot + 1;
               
               if (player1Value == 0)        //This begins the if structure for the player 1 and player 2 shots and scores
               {
                  player1Shot = "Air Ball";
                  player1Score = player1Score + 0;
               }
               if (player1Value == 1)
               {
                  player1Shot = "Free throw";
                  player1Score = player1Score + 1;
               }   
               if (player1Value == 2)
               {
                  player1Shot = "2 Points";
                  player1Score = player1Score + 2;
               }
               if (player1Value == 3)
               {
                  player1Shot = "3 Points";
                  player1Score = player1Score + 3;
               }
               
               if (player2Value == 0) 
               {
                  player2Shot = "Air Ball";
                  player2Score = player2Score + 0;
               }
               if (player2Value == 1)
               {
                  player2Shot = "Free throw";
                  player2Score = player2Score + 1;
               }   
               if (player2Value == 2)
               {
                  player2Shot = "2 Points";
                  player2Score = player2Score + 2;
               }
               if (player2Value == 3)
               {
                  player2Shot = "3 Points";
                  player2Score = player2Score + 3;
               }
               
               System.out.printf("%-10d%-14s%-14d%-14s%-14d\n", shot, player1Shot, player1Score, player2Shot, player2Score);

            }
         }
         
         if (player1Score > player2Score)
         {
            winner = player1Name;
            winningScore = player1Score;
         }
         else if (player2Score > player1Score)
         {
            winner = player2Name;
            winningScore = player2Score;
         }
         else
         {
            winner = "Tie Game... Play again later.";
            winningScore = player1Score;
         }
         
         System.out.print("The winner is " + winner);
         System.out.println(" with a score of " + winningScore);
         System.out.println("Please enter PLAY to play the game or STOP to quit.");
         runProgram = keyboard.nextLine();
         runProgram = runProgram.toUpperCase();
                           
      }      
   }
}