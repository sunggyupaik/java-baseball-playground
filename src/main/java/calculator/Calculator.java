package calculator;

import java.util.Scanner;

public class Calculator {
	public double calculate(String operation, double num1, double num2) {
		return Operation.calculate(operation, num1, num2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String value = scanner.nextLine();
		String[] values = value.split(" ");

		Calculator cal = new Calculator();

		double result = Double.parseDouble(values[0]);

		for(int i=1; i<values.length; i +=2) {
			String operation = values[i];
			double number = Double.parseDouble(values[i + 1]);
			result = cal.calculate(operation, result, number);
		}
	}
}
