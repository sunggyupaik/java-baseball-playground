package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Calculator {
	@Nested
	@DisplayName("calculate 메서드는")
	class Describe_calculate {
		@Nested
		@DisplayName("만약 2개의 숫자와 덧셈 연산자가 주어진다면")
		class Context_with_plusOperation_num1_num2 {
			private final String operation = "+";
			private final double num1 = 5d;
			private final double num2 = 10d;

			private final double result = Operation.calculate(operation, num1, num2);

			@Test
			@DisplayName("덧셈 결과를 리턴한다")
			void it_returns_a_valid_plus_result() {
				Assertions.assertEquals(result, num1 + num2);
			}
		}

		@Nested
		@DisplayName("만약 2개의 숫자와 뺄셈 연산자가 주어진다면")
		class Context_with_minusOperation_num1_num2 {
			private final String operation = "-";
			private final double num1 = 10d;
			private final double num2 = 5d;

			private final double result = Operation.calculate(operation, num1, num2);

			@Test
			@DisplayName("뺄셈 결과를 리턴한다")
			void it_returns_a_valid_minus_result() {
				Assertions.assertEquals(result, num1 - num2);
			}
		}

		@Nested
		@DisplayName("만약 2개의 숫자와 곱셈 연산자가 주어진다면")
		class Context_with_timesOperation_num1_num2 {
			private final String operation = "*";
			private final double num1 = 10d;
			private final double num2 = 5d;

			private final double result = Operation.calculate(operation, num1, num2);

			@Test
			@DisplayName("곱셈 결과를 리턴한다")
			void it_returns_a_valid_times_result() {
				Assertions.assertEquals(result, num1 * num2);
			}
		}

		@Nested
		@DisplayName("만약 2개의 숫자와 나눗셈 연산자가 주어진다면")
		class Context_with_divideOperation_num1_num2 {
			private final String operation = "/";
			private final double num1 = 10d;
			private final double num2 = 5d;

			private final double result = Operation.calculate(operation, num1, num2);

			@Test
			@DisplayName("곱셈 결과를 리턴한다")
			void it_returns_a_valid_times_result() {
				Assertions.assertEquals(result, num1 / num2);
			}
		}
	}
}
