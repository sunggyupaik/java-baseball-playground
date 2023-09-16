package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game 클래스")
public class GameTest {
	abstract static class ContextNumber {
		Answer ONE_TWO_THREE_ANSWERS() {
			return new Answer(Arrays.asList(1, 2, 3));
		}
	}

	static class Utils {
		static Result makeResult(int strikeCount, int ballCount, int nothingCount) {
			Result result = new Result();

			addStrike(result, strikeCount);
			addBall(result, ballCount);
			addNothing(result, nothingCount);

			return result;
		}

		static void addStrike(Result result, int count) {
			for(int i=0; i<count; i++)
				result.add(PlayStatus.STRIKE);
		}

		static void addBall(Result result, int count) {
			for(int i=0; i<count; i++)
				result.add(PlayStatus.BALL);
		}

		static void addNothing(Result result, int count) {
			for(int i=0; i<count; i++)
				result.add(PlayStatus.NOTHING);
		}
	}

	@Nested
	@DisplayName("start 메서드는")
	class Describe_start {
		private final List<Integer> ONE_TWO_THREE_INPUT_BALLS = Arrays.asList(1, 2, 3);
		private final List<Integer> TWO_ONE_THREE_INPUT_BALLS = Arrays.asList(2, 1, 3);
		private final List<Integer> THREE_FOUR_FIVE_INPUT_BALLS = Arrays.asList(3, 4, 5);
		private final Result THREE_STRIKE_RESULT = Utils.makeResult(3, 0,0);
		private final Result ONE_STRIKE_TWO_BALL_RESULT = Utils.makeResult(1, 2,0);
		private final Result ONE_BALL_TWO_NOTHING_RESULT = Utils.makeResult(0, 1,2);

		@Nested
		@DisplayName("1, 2, 3이 정답인 야구숫자 게임에서")
		class Given_wih_one_two_three_answer extends ContextNumber {
			private final Answer answer = ONE_TWO_THREE_ANSWERS();
			private final Game game = new Game(answer);

			@Nested
			@DisplayName("만약 1, 2, 3 공이 주어진다면")
			class Context_with_one_two_three_balls {
				private final List<Integer> inputBallNumbers = ONE_TWO_THREE_INPUT_BALLS;
				private final Result result = THREE_STRIKE_RESULT;

				@Test
				@DisplayName("3 STRIKE 결과를 리턴한다")
				void it_returns_three_strikes_result() {
					Assertions.assertEquals(game.start(inputBallNumbers), result);
				}
			}

			@Nested
			@DisplayName("만약 2, 1, 3 공이 주어진다면")
			class Context_with_two_one_three_balls {
				private final List<Integer> inputBallNumbers = TWO_ONE_THREE_INPUT_BALLS;
				private final Result result = ONE_STRIKE_TWO_BALL_RESULT;
				@Test
				@DisplayName("1 STRIKE 2 BALL 결과를 리턴한다")
				void it_returns_one_strike_two_balls_result() {
					Assertions.assertEquals(game.start(inputBallNumbers), result);
				}
			}

			@Nested
			@DisplayName("만약 3, 4, 5 공이 주어진다면")
			class Context_with_three_four_five_balls {
				private final List<Integer> inputBallNumbers = THREE_FOUR_FIVE_INPUT_BALLS;
				private final Result result = ONE_BALL_TWO_NOTHING_RESULT;

				@Test
				@DisplayName("1 BALL 2 NOTHING 결과를 리턴한다")
				void it_returns_one_ball_two_nothings_result() {
					Assertions.assertEquals(game.start(inputBallNumbers), result);
				}
			}
		}
	}

	@Nested
	@DisplayName("play 메서드는")
	class Describe_play {
		private final Ball ONE_INDEX_ONE_NUMBER_BALL = new Ball(1, 1);
		private final Ball ONE_INDEX_TWO_NUMBER_BALL = new Ball(1, 2);
		private final Ball ONE_INDEX_FOUR_NUMBER_BALL = new Ball(1, 4);
		private final Ball TWO_INDEX_TWO_NUMBER_BALL = new Ball(2, 2);
		private final Ball TWO_INDEX_ONE_NUMBER_BALL = new Ball(2, 1);
		private final Ball TWO_INDEX_FOUR_NUMBER_BALL = new Ball(2, 4);
		private final Ball THREE_INDEX_THREE_NUMBER_BALL = new Ball(3, 3);
		private final Ball THREE_INDEX_TWO_NUMBER_BALL = new Ball(3, 2);
		private final Ball THREE_INDEX_FOUR_NUMBER_BALL = new Ball(3, 4);

		@Nested
		@DisplayName("1, 2, 3이 정답인 야구숫자 게임에서")
		class Given_wih_one_two_three_answer extends ContextNumber {
			private final Answer answer = ONE_TWO_THREE_ANSWERS();
			private final Game game = new Game(answer);

			@Nested
			@DisplayName("만약 첫번째 숫자가 1인 공이 주어진다면")
			class Context_with_first_one_ball {
				private final Ball ball = ONE_INDEX_ONE_NUMBER_BALL;

				@Test
				@DisplayName("STRIKE 요소를 리턴한다")
				void it_returns_one_strike_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.STRIKE);
				}
			}

			@Nested
			@DisplayName("만약 첫번째 숫자가 2인 공이 주어진다면")
			class Context_with_first_two_ball {
				private final Ball ball = ONE_INDEX_TWO_NUMBER_BALL;

				@Test
				@DisplayName("BALL 요소를 리턴한다")
				void it_returns_one_ball_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.BALL);
				}
			}

			@Nested
			@DisplayName("만약 첫번째 숫자가 4인 공이 주어진다면")
			class Context_with_first_four_ball {
				private final Ball ball = ONE_INDEX_FOUR_NUMBER_BALL;

				@Test
				@DisplayName("NOTHING 요소를 리턴한다")
				void it_returns_one_nothing_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.NOTHING);
				}
			}

			@Nested
			@DisplayName("만약 두번째 숫자가 2인 공이 주어진다면")
			class Context_with_second_two_ball {
				private final Ball ball = TWO_INDEX_TWO_NUMBER_BALL;

				@Test
				@DisplayName("STRIKE 요소를 리턴한다")
				void it_returns_one_strike_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.STRIKE);
				}
			}

			@Nested
			@DisplayName("만약 두번째 숫자가 1인 공이 주어진다면")
			class Context_with_second_one_ball {
				private final Ball ball = TWO_INDEX_ONE_NUMBER_BALL;

				@Test
				@DisplayName("BALL 요소를 리턴한다")
				void it_returns_one_ball_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.BALL);
				}
			}

			@Nested
			@DisplayName("만약 두번째 숫자가 4인 공이 주어진다면")
			class Context_with_second_four_ball {
				private final Ball ball = TWO_INDEX_FOUR_NUMBER_BALL;

				@Test
				@DisplayName("NOTHING 요소를 리턴한다")
				void it_returns_one_nothing_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.NOTHING);
				}
			}

			@Nested
			@DisplayName("만약 세번째 숫자가 3인 공이 주어진다면")
			class Context_with_third_three_ball {
				private final Ball ball = THREE_INDEX_THREE_NUMBER_BALL;

				@Test
				@DisplayName("STRIKE 요소를 리턴한다")
				void it_returns_one_strike_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.STRIKE);
				}
			}

			@Nested
			@DisplayName("만약 세번째 숫자가 2인 공이 주어진다면")
			class Context_with_third_two_ball {
				private final Ball ball = THREE_INDEX_TWO_NUMBER_BALL;

				@Test
				@DisplayName("BALL 요소를 리턴한다")
				void it_returns_one_ball_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.BALL);
				}
			}

			@Nested
			@DisplayName("만약 세번째 숫자가 4인 공이 주어진다면")
			class Context_with_third_four_ball {
				private final Ball ball = THREE_INDEX_FOUR_NUMBER_BALL;

				@Test
				@DisplayName("NOTHING 요소를 리턴한다")
				void it_returns_one_nothing_result() {
					PlayStatus playStatus = game.play(ball);

					Assertions.assertEquals(playStatus, PlayStatus.NOTHING);
				}
			}
		}
	}

	@Test
	public void validate_number_strike() {
		Ball ball = new Ball(1, 1); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.play(ball);
		assertThat(playStatus).isEqualTo(PlayStatus.STRIKE);
	}

	@Test
	public void validate_number_ball() {
		Ball ball = new Ball(2, 1); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.play(ball);
		assertThat(playStatus).isEqualTo(PlayStatus.BALL);
	}

	@Test
	public void validate_number_nothing() {
		Ball ball = new Ball(1, 4); // index, number
		Answer answer = new Answer(Arrays.asList(1,2,3));
		Game game = new Game(answer);

		PlayStatus playStatus = game.play(ball);
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
