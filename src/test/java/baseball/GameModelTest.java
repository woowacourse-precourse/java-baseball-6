package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameModelTest {
    private GameModel gameModel;

    @BeforeEach
    public void setUp() {
        gameModel = new GameModel(new Computer("123"));
    }

    @Test
    @DisplayName("컴퓨터 숫자가 123이고, 유저 숫자가 123일 때 3스트라이크를 반환한다.")
    public void compareUserAndComputerNumberTest() {
        //given
        ResultAndView result = new ResultAndView("3스트라이크", false);

        // when
        ResultAndView response = gameModel.compareUserAndComputerNumber("123");
        //when
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("컴퓨터 숫자가 123이고, 유저 숫자가 321일 때 2볼 1스트라이크를 반환한다.")
    public void compareUserAndComputerNumberTest2() {
        //given
        ResultAndView result = new ResultAndView("2볼 1스트라이크", true);
        // when
        ResultAndView response = gameModel.compareUserAndComputerNumber("321");
        //when
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("컴퓨터 숫자가 123이고, 유저 숫자가 456일 때 낫싱을 반환한다.")
    public void compareUserAndComputerNumberTest3() {
        //given
        ResultAndView result = new ResultAndView("낫싱", true);
        // when
        ResultAndView response = gameModel.compareUserAndComputerNumber("456");
        //when
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("컴퓨터 숫자가 123이고, 유저 숫자가 231일 때 3볼을 반환한다.")
    public void compareUserAndComputerNumberTest5() {
        //given
        ResultAndView result = new ResultAndView("3볼", true);
        // when
        ResultAndView response = gameModel.compareUserAndComputerNumber("231");
        //when
        assertThat(response).isEqualTo(result);
    }

    @DisplayName("유저가 3자리 미만 또는 이상 숫자를 입력했을 때 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2314", "23"})
    public void compareUserAndComputerNumberTest6(String userInput) {
        //when, then
        assertThatThrownBy(() -> {
            gameModel.compareUserAndComputerNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 숫자 외 문자를 입력했을 때 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"23a", "2a3", "a23", "$23", "3.a", "3 2", " 32"})
    public void compareUserAndComputerNumberTest7(String userInput) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.compareUserAndComputerNumber(userInput);
        });
    }

    @DisplayName("유저가 같은 숫자를 입력했을 때 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"113", "111", "1231"})
    public void compareUserAndComputerNumberTest8(String userInput) {
        //when, then
        assertThatThrownBy(() -> {
            gameModel.compareUserAndComputerNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 3자리 숫자 중에 0을 하나라도 입력했다면 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"120", "012", "203"})
    public void compareUserAndComputerNumberTest9(String userInput) {
        //when, then
        assertThatThrownBy(() -> {
            gameModel.compareUserAndComputerNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("컴퓨터의 숫자는 서로 다른 3자리 수로 설정한다.")
    public void setRandomNumberInComputerTest() {
        // when
        gameModel.setRandomNumberInComputer();
        String computerNumber = gameModel.getComputer().getNumber();

        // then
        assertThat(computerNumber.length()).isEqualTo(3);
        assertThat(computerNumber.charAt(0)).isNotEqualTo(computerNumber.charAt(1));
        assertThat(computerNumber.charAt(0)).isNotEqualTo(computerNumber.charAt(2));
        assertThat(computerNumber.charAt(1)).isNotEqualTo(computerNumber.charAt(2));
    }

    @DisplayName("유저가 1자리 미만 또는 이상 숫자를 입력했을 때 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "23"})
    public void isGameExitTest(String userInput) {
        //when, then
        assertThatThrownBy(() -> {
            gameModel.compareUserAndComputerNumber(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저가 숫자 외 문자를 입력했을 때 IllegalArgumentException 을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", "a", "이", "%"})
    public void isGameExitTest2(String userInput) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            gameModel.compareUserAndComputerNumber(userInput);
        });
    }
}
