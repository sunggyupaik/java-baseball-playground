package game;

import java.util.List;

public class Game {
	private final Answer answer;

	public Game(Answer answer) {
		this.answer = answer;
	}

	public PlayStatus start(BallNumber ballNumber) {
		if(answer.isStrike(ballNumber)) {
			return PlayStatus.STRIKE;
		}

		if(answer.isBall(ballNumber)) {
			return PlayStatus.BALL;
		}

		return PlayStatus.NOTHING;
	}

	public Result start(List<Integer> tryBallNumbers) {
		Result result = new Result();

		for(int i=1; i<=3; i++) {
			BallNumber ballNumber = new BallNumber(i, tryBallNumbers.get(i-1));
			PlayStatus playStatus = this.start(ballNumber);
			result.add(playStatus);
		}

		return result;
	}
}
