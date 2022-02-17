package com.java;

import java.util.Random;

public class SnakeLadderComputation {

	static int position = 0;

	public static int RollDice() {
		Random Random = new Random();
		int diceRoll = Random.nextInt(6) + 1;
		return diceRoll;
	}

	public static void main(String[] args) {
		System.out.println("diceRoll= " + RollDice());

	}

}