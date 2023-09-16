package game;

import java.util.Objects;

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

	public boolean isThreeStrike() {
		return this.strike == 3;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Result result = (Result) o;
		return getStrike() == result.getStrike() && getBall() == result.getBall() && getNothing() == result.getNothing();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStrike(), getBall(), getNothing());
	}
}
