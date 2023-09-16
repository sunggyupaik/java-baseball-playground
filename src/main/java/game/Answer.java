package game;

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

	public boolean isStrike(Ball ball) {
		return this.getNumberAt(ball.getIndex()) == ball.getNumber();
	}

	public boolean isBall(Ball ball) {
		for(int i=1; i<=3; i++) {
			if(i == ball.getIndex()) continue;

			if(this.getNumberAt(i) == ball.getNumber()) return true;
		}

		return false;
	}
}
