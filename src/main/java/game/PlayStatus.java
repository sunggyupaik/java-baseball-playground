package game;

public enum PlayStatus {
	STRIKE, BALL, NOTHING;

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isNothing() {
		return this == NOTHING;
	}
}
