package game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class validation {
	@Test
	public void validate_number_strike() {
		BallNumber ballNumber = new BallNumber(1, 1); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.start(ballNumber);
		assertThat(playStatus).isEqualTo(PlayStatus.STRIKE);
	}

	@Test
	public void validate_number_ball() {
		BallNumber ballNumber = new BallNumber(2, 1); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.start(ballNumber);
		assertThat(playStatus).isEqualTo(PlayStatus.BALL);
	}

	@Test
	public void validate_number_nothing() {
		BallNumber ballNumber = new BallNumber(1, 4); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.start(ballNumber);
		assertThat(playStatus).isEqualTo(PlayStatus.NOTHING);
	}

	@Test
	public void validate_three_strike() {
		List<Integer> tryBallNumbers = Arrays.asList(1, 2, 3);
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		Result result = game.start(tryBallNumbers);
		assertThat(result.getStrike()).isEqualTo(3);
	}

	@Test
	public void validate_one_strike_two_ball() {
		List<Integer> tryBallNumbers = Arrays.asList(1, 2, 3);
		Answer answer = new Answer(Arrays.asList(1, 3, 2));
		Game game = new Game(answer);

		Result result = game.start(tryBallNumbers);
		assertThat(result.getStrike()).isEqualTo(1);
		assertThat(result.getBall()).isEqualTo(2);
	}

	@Test
	public void validate_three_nothing() {
		List<Integer> tryBallNumbers = Arrays.asList(1, 2, 3);
		Answer answer = new Answer(Arrays.asList(4, 5, 6));
		Game game = new Game(answer);

		Result result = game.start(tryBallNumbers);
		assertThat(result.getNothing()).isEqualTo(3);
	}
}
