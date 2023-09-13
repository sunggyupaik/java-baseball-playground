package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
	private char operation = ' ';
	private double result = 0;
	List<Character> operationList = Arrays.asList('+', '-', '*', '/');

	public void calculate(String[] values) {
		for (String value : values) {
			if (operationList.contains(value.charAt(0))) {
				operation = value.charAt(0);
				continue;
			}

			if (operation == '+') {
				result = add(result, Double.parseDouble(value));
				continue;
			}

			if (operation == '-') {
				result = minus(result, Double.parseDouble(value));
				continue;
			}

			if (operation == '*') {
				result = times(result, Double.parseDouble(value));
				continue;
			}

			if (operation == '/') {
				result = divide(result, Double.parseDouble(value));
				continue;
			}

			if (operation == ' ') {
				result = Integer.parseInt(value);
			}
		}

		System.out.println((int) result);
	}

	private double add(Double result, Double value) {
		return Operation.PLUS.apply(result, value);
	}

	private double minus(Double result, Double value) {
		return Operation.MINUS.apply(result, value);
	}

	private double times(Double result, Double value) {
		return Operation.TIMES.apply(result, value);
	}

	private double divide(Double result, Double value) {
		return Operation.DIVIDE.apply(result, value);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String value = scanner.nextLine();
		String[] values = value.split(" ");

		Calculator cal = new Calculator();
		cal.calculate(values);
	}
}
