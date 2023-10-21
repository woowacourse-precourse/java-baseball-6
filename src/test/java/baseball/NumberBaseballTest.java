package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballTest {

    private Game game;
    private Computer computer;

    @BeforeEach
    void setUp() {
        game = new Game();
        computer = new Computer();
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자가_3자리 서로 다른 임의의 숫자이면_성공한다")
    void generateNumber_is3DifferentRandomNumber_Success() {
        String number = computer.generateRandomNumber();
        System.out.println(number);
        assertThat(number.charAt(0))
                .isNotEqualTo(number.charAt(1))
                .isNotEqualTo(number.charAt(2));
        assertThat(number.charAt(1))
                .isNotEqualTo(number.charAt(2));
    }

    @Test
    @DisplayName("사용자로부터 받은 숫자가_3자리 서로다른 숫자가 아닐경우_예외를 발생한다.")
    void userNumber_isNot3DifferentNumber_throwException() {
        assertThatThrownBy(() -> game.validateUserNumber("21a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아니다");
        assertThatThrownBy(() -> game.validateUserNumber("224"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 숫자가 존재한다");
        assertThat(game.validateUserNumber("234"))
                .isEqualTo("234");
    }

    @Test
    @DisplayName("사용자 숫자를 넣고_컴퓨터 숫자와 모두 같다면_3 스트라이크를 반환한다")
    void userNumber_isEqualAllComputerNumber_3Strike() {
        assertThat(game.compareNumber("111"))
                .isEqualTo("3 스트라이크");
    }
}
