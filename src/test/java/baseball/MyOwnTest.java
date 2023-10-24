package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class MyOwnTest extends NsTest {

    @Test
    @DisplayName("3자리지만_숫자가_아닌경우")
    void 숫자가_아닌_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                                when(Console.readLine()).thenReturn("테스트");
                                Application.getNumbers();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("input length should exactly be three.")
        );
    }

    @Test
    void 세_자리보다_짧은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                                when(Console.readLine()).thenReturn("1");
                                Application.getNumbers();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("input length should exactly be three.")
        );

    }

    @Test
    void 세_자리보다_긴_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                                when(Console.readLine()).thenReturn("1234");
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
                    try (MockedStatic<Console> console = mockStatic(Console.class)) {
                        when(Console.readLine()).thenReturn("158");
                        assertThat(Application.getNumbers()).containsExactly(1, 5, 8);
                    }
                }
        );
    }

    @Test
    @DisplayName("정답리스트는_중복이_없는_3자리이다.")
    void 정답리스트는_3자리이다() {
        assertSimpleTest(() -> assertThat(Application.prepareAnswer())
                .isNotEmpty()
                .hasSize(3)
                .doesNotHaveDuplicates()
                .filteredOn(integer -> 1 <= integer && integer <= 9)
        );
    }

    @Test
    @DisplayName("모든_자리가_같으면_3스트라이크를_반환한다")
    void 정답이면_0과3을_원소로_갖는다() {
        assertSimpleTest(() -> {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> userGuess = List.of(1, 2, 3);


            assertThat(Application.getScoreMessage(computer, userGuess))
                    .isEqualTo("3스트라이크");
        });
    }

    @Test
    void 원_볼_원_스트라이크() {
        assertSimpleTest(() -> {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> user = List.of(2, 9, 3);

            assertThat(Application.getScoreMessage(computer, user))
                    .isEqualTo("1볼 1스트라이크");

        });
    }

    @Test
    void 볼만_있을_경우() {
        assertSimpleTest(() -> {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> user = List.of(2, 9, 7);

            assertThat(Application.getScoreMessage(computer, user))
                    .isEqualTo("1볼");
        });
    }

    @Test
    void 낫싱() {
        assertSimpleTest(() -> {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> user = List.of(4, 5, 6);

            assertThat(Application.getScoreMessage(computer, user))
                    .isEqualTo("낫싱");

        });
    }

    @Test
    @DisplayName("다시_시작할_때_숫자를_넣어야_합니다.")
    void 다시_시작할_때_숫자가_아닐_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                                when(Console.readLine()).thenReturn("q");
                                Application.isGameOver();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("your choice should be in range 1 to 2.")
        );

    }

    @Test
    @DisplayName("다시_시작할_때_한_자리_수를_넣어야_합니다.")
    void 다시_시작할_때_한자리가_아닐_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                                when(Console.readLine()).thenReturn("1234");
                                Application.isGameOver();
                            }
                        }
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("your choice should exactly be one digit.")
        );
    }

    @Test
    @DisplayName("다시_시작할때_정상적인_입력을_넣으면_boolean을_반환합니다")
    void 다시_시작할_때_정상값을_넣으면() {
        assertSimpleTest(() -> {
            try (MockedStatic<Console> console = mockStatic(Console.class)) {
                when(Console.readLine()).thenReturn("1", "2");
                assertThat(Application.isGameOver()).isTrue();
                assertThat(Application.isGameOver()).isFalse();
            }
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}