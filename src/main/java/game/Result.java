package game;

public class Result {
	private int strike;
	private int ball;
	private int nothing;

	public void add(PlayStatus playStatus) {
		if(playStatus == PlayStatus.STRIKE) strike++;
		if(playStatus == PlayStatus.BALL) ball++;
		if(playStatus == PlayStatus.NOTHING) nothing++;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public int getNothing() {
		return nothing;
	}

	public boolean isEndGame() {
		return this.strike == 3;
	}
}
