package baseball;

import java.util.Scanner;

public class Baseball {
	public static void baseball() {
		int answer = makeRandomNumber();
		Scanner scanner = new Scanner(System.in);
		int strike = 0;
		int ball = 0;

		while(true) {
			ResultView.printInputNumber();
			String value = scanner.nextLine();
			String[] values = value.split("");

			strike = 0;
			ball = 0;

			for(int i=1; i<=3; i++) {
				if(Integer.parseInt(values[i-1]) == cal(answer, i)) {
					strike++;
					continue;
				}

				for(int j=1; j<=3; j++) {
					if(i == j) continue;
					if(Integer.parseInt(values[i-1]) == cal(answer, j)) {
						ball++;
						break;
					}
				}
			}

			ResultView.printResult(strike, ball);

			if(strike == 3) {
				ResultView.printFinish();
				int input = Integer.parseInt(scanner.nextLine());
				if(input == 1) {
					answer = makeRandomNumber();
					continue;
				}

				if(input == 2) {
					break;
				}
			}
		}
	}

	public static int makeRandomNumber() {
		return (int)(Math.random() * 899) + 100;
	}

	public static int cal(int num, int index) {
		int n = 3 - index;

		while (n > 0) {
			num /= 10;

			n--;
		}

		return num % 10;
	}
}
