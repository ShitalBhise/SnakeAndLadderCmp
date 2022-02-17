package com.java;

import java.util.Random;

public class SnakeLadderComputation {

	static int position = 0;
	static final int NO_PLAY = 0;
	static final int LADDER = 1;
	static final int SNAKE = 2;

	public static int RollDice() {
		Random Random = new Random();
		int diceRoll = Random.nextInt(6) + 1;
		return diceRoll;
	}

	public static void optionCheck(int diceRoll) {
		Random random = new Random();
		int option = random.nextInt(3);

		// Ladder
		if (option == LADDER) {
			position += diceRoll;
		}
		// Snak
		else if (option == SNAKE) {
			position -= diceRoll;
		} else {
			position = position;
		}
	}

	public static void main(String[] args) {
		int diceRoll = RollDice();
		System.out.println("diceRoll= " + RollDice());
		optionCheck(diceRoll);
		System.out.println("position = " + position);

	}

}