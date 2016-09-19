/* Name: Elizabeth Davis
 * OBJ: Create a program that allows a user to play Rock-Paper-Scissors with the computer.
 * Keep track of the wins, losses, ties, and win percentage for the duration of the game.
 * Date: April 7th, 2016
 * Last Modified: April 7th, 2016
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		RPSGame game = new RPSGame();

		Scanner scan = new Scanner(System.in);
		
	while(true) {			
		System.out.println("Rock, paper, scissors ... shoot! Please type rock, paper, or scissors to play!");

		String playerChoice = scan.nextLine().toUpperCase();
		String computerChoice = game.getRandom();

		//A recap of who chose what
		System.out.println("You chose " + playerChoice + ".");
		System.out.println("The computer chose " + computerChoice + ".");

		RPSGame.GameOutcome outcome = game.getOutcome(playerChoice, computerChoice);

		//Prints out who won the game, or if it was a tie game
		if(outcome == RPSGame.GameOutcome.WIN)
		{
			System.out.println("You won!");			
		}

		else if(outcome == RPSGame.GameOutcome.LOSE)
		{
			System.out.println("The computer won!");
		}

		else
		{
			System.out.println("Tie game!");
		}

		//Prints out statistics from the game
		System.out.println("Wins: " + game.getWins());
		System.out.println("Losses: " + game.getLosses());
		System.out.println("Ties: " + game.getTies());
		System.out.println("Win Percentage: " + game.getPercent() + "%");

		//Loops until user decides not to play anymore
		System.out.println("Want to play again? (Y/N)");

		String answer = scan.nextLine();

		//If user does not want to play anymore, the game exits
		if(answer.equalsIgnoreCase("NO"))
		{
			System.out.println("Thank you for playing!");
			break;
		}
	}

	scan.close();

	}
}