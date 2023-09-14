package game;

import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game(new Answer(Answer.makeRandomAnswer()));

		while(true) {
			String[] values = Print.printInputNumber(scanner);
			Result result = game.start(BallNumber.combine(values));

			Print.printResult(result);

			if(result.isEndGame()) {
				boolean isFinished = Print.printFinish(scanner);
				if(isFinished) break;

				game = new Game(new Answer(Answer.makeRandomAnswer()));
			}
		}
	}
}
