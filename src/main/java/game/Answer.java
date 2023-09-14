package game;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	List<Integer> answerList;

	@Override
	public String toString() {
		return "Answer{" +
				"answerList=" + answerList +
				'}';
	}

	public Answer(List<Integer> list) {
		this.answerList = list;
	}

	public int getNumberAt(int index) {
		return answerList.get(index - 1);
	}

	public boolean isStrike(BallNumber ballNumber) {
		return this.getNumberAt(ballNumber.getIndex()) == ballNumber.getNumber();
	}

	public boolean isBall(BallNumber ballNumber) {
		for(int i=1; i<=3; i++) {
			if(i == ballNumber.getIndex()) continue;

			if(this.getNumberAt(i) == ballNumber.getNumber()) return true;
		}

		return false;
	}

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
