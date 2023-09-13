package calculator;

import java.util.Scanner;

public class Calculator {
	public void start(String[] values) {
		double result = Double.parseDouble(values[0]);

		for(int i=1; i<values.length; i +=2) {
			String operation = values[i];
			double number = Double.parseDouble(values[i + 1]);
			result = calculate(operation, result, number);
		}

		System.out.println((int) result);
	}

	public double calculate(String operation, double num1, double num2) {
		Operation op = Operation.fromString(operation);
		return Operation.calculate(op, num1, num2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String value = scanner.nextLine();
		String[] values = value.split(" ");

		Calculator cal = new Calculator();
		cal.start(values);
	}
}
