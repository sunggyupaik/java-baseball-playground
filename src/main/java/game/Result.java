package game;

public class Result {
	private int strike;
	private int ball;
	private int nothing;

	public void add(PlayStatus playStatus) {
		if(playStatus.isStrike()) strike++;
		if(playStatus.isBall()) ball++;
		if(playStatus.isNothing()) nothing++;
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
}
