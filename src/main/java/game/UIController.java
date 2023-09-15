package game;

import java.util.Scanner;

public class UIController {
	private static Scanner scanner;

	public UIController() {
		scanner = new Scanner(System.in);
	}

	public static String[] inputBallNumbers() {
		String value = "";

		while(value.length() != 3) {
			System.out.print("숫자를 입력해 주세요 : ");
			value = scanner.nextLine();
		}

		return value.split("");
	}

	public static boolean printFinish() {
		int input = 0;

		while(true) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
					"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = Integer.parseInt(scanner.nextLine());

			if(input == 1) return false;
			if(input == 2) return true;
		}
	}

	public static void printResult(Result result) {
		System.out.printf("%d 볼 %d 스트라이크", result.getBall(), result.getStrike());
		System.out.println();
	}
}
