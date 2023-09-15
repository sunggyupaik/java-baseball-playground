package game;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
	public static List<Integer> makeRandomAnswer() {
		List<Integer> list = new ArrayList<>();
		int randomNumber = 0;

		while(list.size() != 3) {
			randomNumber = (int) ((Math.random() * 10000) % 10);
			if(!list.contains(randomNumber)) list.add(randomNumber);
		}

		return list;
	}
}
