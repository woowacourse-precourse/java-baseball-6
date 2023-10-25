package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Game.class 테스트 코드 이다.
 */
class GameTest {
    private PrintStream originalOuput = System.out;
    private OutputStream ouputCaptor;
    private Game game;

    @BeforeEach
    void testInit() {
        ouputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ouputCaptor));

        game = Game.newGame();
    }

    @AfterEach
    void testCleanUp() {
        System.setOut(originalOuput);
        Console.close();
    }

    private String getOutput() {
        return ouputCaptor.toString();
    }

    private void setInputs(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 게임이_정상적으로_시작해서_게임시작_메시지가_출력되는지_확인한다() {
        System.setIn(new ByteArrayInputStream("\n".getBytes()));

        try {
            game.start();
        } catch (Exception e) {
            assertThat(getOutput()).contains("숫자 야구 게임을 시작합니다.\n");
        }
    }

    @Test
    void 게임이_정상적으로_시작해서_숫자_입력_요청_메시지가_출력되는지_확인한다() {
        System.setIn(new ByteArrayInputStream("\n".getBytes()));

        try {
            game.start();
        } catch (Exception e) {
            assertThat(getOutput()).contains("숫자를 입력해주세요 : \n");
        }
    }

    @Test
    void 게임_결과가_정상적으로_출력되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    game = Game.newGame();

                    setInputs("519", "138", "152", "246", "135", "2");
                    game.start();
                    assertThat(getOutput()).contains("2볼", "2스트라이크", "1볼 1스트라이크", "낫싱", "3스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임_종료_메시지가_정상적으로_출력되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    game = Game.newGame();

                    setInputs("135", "2");
                    game.start();
                    assertThat(getOutput()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임_종료시_재시작_메시지가_정상적으로_출력되는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    game = Game.newGame();

                    setInputs("135", "2");
                    game.start();
                    assertThat(getOutput()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                },
                1, 3, 5
        );
    }

    @Test
    void 재시작이_정상적으로_동작하는지_확인한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    game = Game.newGame();

                    setInputs("135", "1", "589", "2");
                    game.start();
                    assertThat(getOutput()).contains("3스트라이크", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                },
                1, 3, 5, 5, 8, 9
        );
    }
}