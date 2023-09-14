package baseball;

public class ResultView {
	public static void printInputNumber() {
		System.out.print("숫자를 입력해 주세요 : ");
	}

	public static void printFinish() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
				"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public static void printResult(int strike, int ball) {
		System.out.printf("%d 볼 %d 스트라이크", ball, strike);
		System.out.println();
	}
}
