package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void setSize() {
		assertThat(numbers.size()).isEqualTo(4);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains(int input) {
		assertThat(numbers.contains(input)).isTrue();
		assertThat(numbers.contains(input)).isTrue();
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1, 2, 3, 4, 5"})
	void containsReturnsTrueAndFalse(int input) {
		if(numbers.contains(input))
			assertThat(numbers.contains(input)).isTrue();

		if(!numbers.contains(input))
			assertThat(numbers.contains(input)).isFalse();
	}
}
