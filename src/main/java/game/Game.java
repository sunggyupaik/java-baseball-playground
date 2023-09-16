package game;

import java.util.List;

public class Game {
	private final Answer answer;

	public Game(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Game{" +
				"answer=" + answer +
				'}';
	}

	public Result start(List<Integer> inputBallNumbers) {
		Result result = new Result();

		for(int i=1; i<=3; i++) {
			Ball ball = new Ball(i, inputBallNumbers.get(i-1));
			PlayStatus playStatus = this.play(ball);
			result.add(playStatus);
		}

		return result;
	}

	public PlayStatus play(Ball ball) {
		if(answer.isStrike(ball)) {
			return PlayStatus.STRIKE;
		}

		if(answer.isBall(ball)) {
			return PlayStatus.BALL;
		}

		return PlayStatus.NOTHING;
	}
}
