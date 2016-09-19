/* Name: Elizabeth Davis
 * OBJ: Create a program that allows a user to play Rock-Paper-Scissors with the computer.
 * Keep track of the wins, losses, ties, and win percentage for the duration of the game.
 * Date: April 7th, 2016
 * Last Modified: April 7th, 2016
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class RPSGame {
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;

	public static enum GameOutcome {
		WIN, LOSE, TIE;
	}

	//Rock-Paper-Scissors rules. Takes user input and computer input and compares them
	public GameOutcome getOutcome(String user, String computer) {
		if(user.equalsIgnoreCase("ROCK"))
		{
			if(computer.equalsIgnoreCase("SCISSORS"))
			{
				wins++;
				return GameOutcome.WIN;
			}

			else if(computer.equalsIgnoreCase("PAPER"))
			{
				losses++;
				return GameOutcome.LOSE;
			}
		}

		else if(user.equalsIgnoreCase("PAPER"))
		{
			if(computer.equalsIgnoreCase("ROCK"))
			{
				wins++;
				return GameOutcome.WIN;
			}

			else if(computer.equalsIgnoreCase("SCISSORS"))
			{
				losses++;
				return GameOutcome.LOSE;
			}
		}

		else if(user.equalsIgnoreCase("SCISSORS"))
		{
			if(computer.equalsIgnoreCase("PAPER"))
			{
				wins++;
				return GameOutcome.WIN;
			}

			else if(computer.equalsIgnoreCase("ROCK"))
			{
				losses++;
				return GameOutcome.LOSE;
			}
		}

		ties++;
		return GameOutcome.TIE;
	}

	//The random function gets a random number and assigns rock, paper, or scissors based on the value
	public String getRandom() {
		double value = Math.random();

		if(value <= .33)
		{
			return "ROCK";
		}

		else if(value <= .66)
		{
			return "PAPER";
		}

		else 
		{
			return "SCISSORS";
		}
	}

	public int getWins()
	{
		return wins;
	}

	public int getLosses()
	{
		return losses;
	}

	public int getTies()
	{
		return ties;
	}

	//Calculations for win percentage
	public double getPercent()
	{
		int total = wins + losses + ties;
		double winTotal = wins * 100.0/total;
		return winTotal;
	}
}

