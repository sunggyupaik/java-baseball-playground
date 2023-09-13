package calculator;

import java.util.Arrays;

public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	public static Operation fromString(String inputOperation) {
		return Arrays.stream(Operation.values())
				.filter(operation -> operation.symbol.equals(inputOperation))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}

	public static double calculate(String operation, double num1, double num2) {
		return Operation.fromString(operation).apply(num1, num2);
	}
}
