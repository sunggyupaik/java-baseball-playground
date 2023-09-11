package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(Arrays.asList(actual)).contains("1");
        assertThat(Arrays.asList(actual)).contains("2");

        String[] actual2 = "1,".split(",");
        assertThat(Arrays.asList(actual2)).containsExactly("1");
    }

    @Test
    @DisplayName("charAt 메서드는 문자열 범위를 벗어난 index의 문자를 조회할 때 예외를 던진다.")
    void charAt() {
        assertThatThrownBy(() -> {
            String inputs = "abc";
            char FourthCharacter = inputs.charAt(4);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
