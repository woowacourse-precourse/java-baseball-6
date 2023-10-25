package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.ui.ConsoleInput;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {
    private static User user;
    private static InputStream originalSystemIn;
    private static final int NUMBER_BALLS = 3;

    @BeforeAll
    public static void setupAll() {
        user = new User(new ConsoleInput());
        originalSystemIn = System.in;
    }

    @AfterAll
    public static void cleanupAll() {
        System.setIn(originalSystemIn);
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    public void 유저는_게임_볼_개수_규칙_만큼의_입력을_통해_숫자를_생성할_수_있어야_함() {
        // given
        String input = "321";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);
        user.generatePlayerNumber(NUMBER_BALLS);

        // then
        assertEquals(NUMBER_BALLS, user.countNumberBalls());

    }

    @Test
    public void 유저가_게임_룰에_맞지_않는_공의_갯수를_입력하면_예외가_발생됨() {
        // given
        String input = "123456789";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);

        // then
        assertThatThrownBy(() -> user.generatePlayerNumber(NUMBER_BALLS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공의 개수는 " + NUMBER_BALLS + "개를 입력해야 합니다.");
    }

    @Test
    public void 유저가_중복되는_숫자를_입력하면_예외가_발생함() {
        // given
        String input = "111";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);

        // then
        assertThatThrownBy(() -> user.generatePlayerNumber(NUMBER_BALLS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("서로 다른 숫자를 입력해야 합니다.");
    }

    @Test
    public void 유저가_숫자가_아닌_값을_입력하면_예외가_발생됨() {
        // given
        String input = "Hello";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);

        // then
        assertThatThrownBy(() -> user.generatePlayerNumber(NUMBER_BALLS))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값은 양의 일의자리 정수이어야 합니다.");
    }

    @Test
        public void 유저는_게임_명령어_1을_입력할_수_있음() {
        // given
        String input = "1";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);
        Command command = user.selectCommand();

        // then
        assertEquals(Command.RESTART, command);
    }

    @Test
    public void 유저는_게임_명령어_2를_입력할_수_있음() {
        // given
        String input = "2";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);
        Command command = user.selectCommand();

        // then
        assertEquals(Command.END, command);
    }

    @Test
    public void 유저가_잘못된_게임_명령어를_입력하면_예외가_발생함() {
        // given
        String input = "3";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());

        // when
        System.setIn(mockInput);

        // then
        assertThatThrownBy(() -> user.selectCommand())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 명령어를 입력했습니다.");
    }

}