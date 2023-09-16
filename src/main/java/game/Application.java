package game;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		Answer answer = new Answer(RandomNumberGenerator.makeRandomAnswer());
		Game game = new Game(answer);

		while(true) {
			List<Integer> inputBallNumbers = Ball.fromStringArray(UIController.inputBallNumbers());
			Result result = game.start(inputBallNumbers);

			UIController.printResult(result);

			if(result.isThreeStrike()) {
				if(UIController.printFinish()) break;

				answer = new Answer(RandomNumberGenerator.makeRandomAnswer());
				game = new Game(answer);
			}
		}
	}
}
