package calculator;

import java.util.Scanner;

public class Calculator {
	int input = 0;
	char operation = ' ';
	int result = 0;

	public void calculate(String[] values) {
		for (String value : values) {
			if (value.charAt(0) == '+') {
				operation = '+';
				continue;
			}

			if (value.charAt(0) == '-') {
				operation = '-';
				continue;
			}

			if (value.charAt(0) == '*') {
				operation = '*';
				continue;
			}

			if (value.charAt(0) == '/') {
				operation = '/';
				continue;
			}

			if (operation == '+') {
				result = result + Integer.parseInt(value);
				continue;
			}

			if (operation == '-') {
				result = result - Integer.parseInt(value);
				continue;
			}

			if (operation == '*') {
				result = result * Integer.parseInt(value);
				continue;
			}

			if (operation == '/') {
				result = result / Integer.parseInt(value);
				continue;
			}

			if (operation == ' ') {
				input = Integer.parseInt(value);
				result = input;
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String value = scanner.nextLine();
		String[] values = value.split(" ");

		Calculator cal = new Calculator();
		cal.calculate(values);
	}
}
