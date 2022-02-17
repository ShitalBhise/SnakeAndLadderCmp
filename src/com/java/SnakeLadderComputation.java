package com.java;

import java.util.Random;

public class SnakeLadderComputation {

	static int player1Position = 0;
	static int player2Position = 0;
	static final int NO_PLAY = 0;
	static final int LADDER = 1;
	static final int SNAKE = 2;
	static final int PLAYER1 = 1;
	static final int PLAYER2 = 2;
	static final int WINNING_POS = 100;
	static int player = PLAYER1;
	static int dicePlayer1Count = 0;
	static int dicePlayer2Count = 0;
	static int optionPlayer1;
	static int optionPlayer2;
	static int option = 0;
	static int dice;

	public static int diceRoll() {
		Random random = new Random();
		int dice = random.nextInt(6) + 1;
		return dice;
	}

	public static int optionCheck(int dice, int position) {
		Random random = new Random();
		int option = random.nextInt(3);

		return option;
	}

	public static void playerPlayCheck(int option) {
		if (player == PLAYER1) {
			if ((option == SNAKE) || (option == NO_PLAY)) {
				player = PLAYER2;
			}
		} else if (player == PLAYER2) {
			if ((option == SNAKE) || (option == NO_PLAY)) {
				player = PLAYER1;
			}
		}
	}

	public static void positionCheck(int option, int position, int dice) {
		if ((option == LADDER) && (position + dice <= WINNING_POS)) {
			position += dice;
		} else if (option == SNAKE) {
			position -= dice;
		} else {
			position = position;
		}
		if (position < 0) {
			position = 0;
		}
		if (player == PLAYER1) {
			player1Position = position;
		} else if (player == PLAYER2) {
			player2Position = position;
		}
	}

	public static void playerDiceCount() {

		// for player1
		if (player == PLAYER1) {
			optionPlayer1 = optionCheck(dice, player1Position);
			positionCheck(optionPlayer1, player1Position, dice);
			option = optionPlayer1;
			dicePlayer1Count++;
		}
		// for player2
		else if (player == PLAYER2) {
			optionPlayer2 = optionCheck(dice, player2Position);
			positionCheck(optionPlayer2, player2Position, dice);
			option = optionPlayer2;
			dicePlayer2Count++;
		}

	}

	public static void playerWinStatus() {
		if (player1Position == WINNING_POS) {
			System.out.println("Player One Wins");
		} else {
			System.out.println("Player Two Wins");
		}
	}

	public static void main(String[] args) {

		while (player1Position < WINNING_POS && player2Position < WINNING_POS) {
			dice = diceRoll();
			playerPlayCheck(option);
			playerDiceCount();

		}
		System.out.println("player1Position = " + player1Position + "\nplayer2Position = " + player2Position);

		System.out.println("dicePlayer1Count = " + dicePlayer1Count + "\ndicePlayer2Count = " + dicePlayer2Count);
		playerWinStatus();

	}

}