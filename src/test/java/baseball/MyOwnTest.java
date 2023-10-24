package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyOwnTest {

    @Test
    @DisplayName("3자리지만_숫자가_아닌경우")
    void 숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
                                Mockito.when(Console.readLine()).thenReturn("테스트");
                                Application.getNumbers();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("input length should exactly be three.")
        );
    }

    @Test
    @DisplayName("3자리보다 짧은 경우")
    void 세_자리보다_짧은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
                                Mockito.when(Console.readLine()).thenReturn("1");
                                Application.getNumbers();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("input length should exactly be three.")
        );

    }

    @Test
    @DisplayName("3자리보다_긴_경우")
    void 세_자리보다_긴_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
                                Mockito.when(Console.readLine()).thenReturn("1234");
                                Application.getNumbers();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("input length should exactly be three.")
        );
    }

    @Test
    @DisplayName("정상_입력의_경우_리스트를_반환한다")
    void 정상_입력의_경우() {
        assertSimpleTest(() -> {
            try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
                Mockito.when(Console.readLine()).thenReturn("158");
                Assertions.assertThat(Application.getNumbers()).containsExactly(1, 5, 8);
            }
        });
    }

}