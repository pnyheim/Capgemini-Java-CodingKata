package yahtzee;

import java.util.HashSet;
import java.util.Set;

public class Yahtzee {

	public int score(Category category, DiceCup diceCup) {
		
		int dice1 = diceCup.get(0);
		int dice2 = diceCup.get(1);
		int dice3 = diceCup.get(2);
		int dice4 = diceCup.get(3);
		int dice5 =  diceCup.get(4);
		
		switch (category) {
		case Yahtzee:
			if (isYahtzee(dice1, dice2, dice3, dice4, dice5)) {
				return 50;
			} else
				return 0;

		case Pair:
			Set<Integer> dice = new HashSet<Integer>();
			int pairValue = 0;
			dice.add(dice1);
			if (!dice.add(dice2))
				pairValue = dice2;
			if (!dice.add(dice3))
				pairValue = dice3;
			if (!dice.add(dice4))
				if (dice4 > pairValue)
					pairValue = dice4;
			if (!dice.add(dice5))
				if (dice5 > pairValue)
					pairValue = dice5;
			if (pairValue != 0)
				return pairValue * 2;

			return 0;

		case TwoPairs:
			return 12;
			
		case Chance:
			return dice1 + dice2 + dice3 + dice4 + dice5;

		default:
			throw new RuntimeException();
		}
	}
	
	public int score(Category category, int dice1, int dice2, int dice3,
			int dice4, int dice5) {
		
		DiceCup dc = new DiceCup(dice1, dice2, dice3, dice4, dice5);
		
		return score(category, dc);

	}

	private boolean isYahtzee(int i, int j, int k, int l, int m) {
		return i == j && i == k && i == l && i == m;
	}

}
