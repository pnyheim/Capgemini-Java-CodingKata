package yahtzee;

import static org.junit.Assert.*;
import static yahtzee.Category.*;

import org.junit.Before;
import org.junit.Test;

public class YahtzeeTest {
	private Yahtzee yahtzee;

	@Before
	public void Setup() {
		yahtzee = new Yahtzee();
	}

	@Test
	public void shouldReturnSumOfValuesWhenGivenChance() {
		int score = yahtzee.score(Chance, 1, 2, 3, 4, 5);
		assertEquals(15, score);
	}

	@Test
	public void shouldReturnAnotherSumOfValuesWhenGivenChance() {
		int score = yahtzee.score(Chance, 1, 1, 1, 1, 1);
		assertEquals(5, score);
	}

	@Test
	public void shouldReturn50IfYahtzee() {
		int score = yahtzee.score(Yahtzee, 2, 2, 2, 2, 2);
		assertEquals(50, score);
	}

	@Test
	public void shouldReturn0IfNotYahtzee() {
		int score = yahtzee.score(Yahtzee, 1, 2, 2, 2, 2);
		assertEquals(0, score);
	}

	@Test
	public void shouldReturn2IfPairOfOnes() {
		int score = yahtzee.score(Pair, 1, 1, 2, 4, 5);
		assertEquals(2, score);
	}

	@Test
	public void shouldReturn0IfNotPair() {
		int score = yahtzee.score(Pair, 1, 2, 3, 4, 5);
		assertEquals(0, score);
	}

	@Test
	public void shouldReturnSumOfTwoEqualDiceIfPair() {
		int score = yahtzee.score(Pair, 2, 2, 3, 4, 5);
		assertEquals(4, score);
	}

	@Test
	public void shouldReturnHigherOfTwoPairs() {
		int score = yahtzee.score(Pair, 2, 2, 3, 4, 4);
		assertEquals(8, score);
	}

	@Test
	public void shouldReturnHigherOfTwoPairsForReal() {
		int score = yahtzee.score(Pair, 4, 4, 3, 2, 2);
		assertEquals(8, score);
	}

	@Test
	public void shouldReturnSumOfTwoPairsForTwoPairs() {
		DiceCup dc = new DiceCup(4,4,3,2,2);
		int score = yahtzee.score(TwoPairs, dc);
		assertEquals(12, score);
	}

	@Test
	public void shouldReturnSumOfTwoPairsForTwoPairsForReal() {
		DiceCup diceCup = new DiceCup(1,1,2,2,3);
		int score = yahtzee.score(TwoPairs, diceCup);
		assertEquals(6, score);
	}
}
