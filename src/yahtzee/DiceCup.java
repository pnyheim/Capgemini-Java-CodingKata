package yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceCup {
	
	List<Integer> dice  = new ArrayList<Integer>();
	
	public DiceCup(int die1, int die2, int die3, int die4, int die5) {
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		dice.add(die4);
		dice.add(die5);
		Collections.sort(dice);
	}

	public int get(int i) {
		return dice.get(i);
	}
}
