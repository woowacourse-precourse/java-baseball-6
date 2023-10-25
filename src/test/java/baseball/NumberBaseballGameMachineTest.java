package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberBaseballGameMachineTest {

    @DisplayName("console 테스트")
    @Test
    void input() {
        //given
        String inputLine = "콘솔로 입력합니다.";
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);

        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        String input = numberBaseballGameMachine.getInputLine();
        //then
        assertThat(inputLine).isEqualTo(input);
    }

    @DisplayName("유저 input이 3스트라이크 일때, 게임이 성공 했는지 판단하는 테스트")
    @Test
    void isSuccessThreeStrikeTest() {
        //given
        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        final List<Integer> playerAnswer = List.of(0, 3);
        //then
        assertThat(numberBaseballGameMachine.isSuccess(playerAnswer)).isEqualTo(true);
    }

    @DisplayName("유저 input이 낫싱 일때, 게임 성공을 판단하는 테스트")
    @Test
    void isSuccessNothingTest() {
        //given
        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        final List<Integer> playerAnswer = List.of(0, 0);
        //then
        assertThat(numberBaseballGameMachine.isSuccess(playerAnswer)).isEqualTo(false);
    }

    @DisplayName("유저 input이 3 스트라이크 아닐 경우, 게임 성공을 판단하는 테스트")
    @Test
    void isSuccessBallStrikeTest() {
        //given
        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        final List<Integer> playerAnswer = List.of(1, 2);
        //then
        assertThat(numberBaseballGameMachine.isSuccess(playerAnswer)).isEqualTo(false);
    }

    @DisplayName("유저 input이 1일 때, 새로운 게임의 여부를 판단하는 테스트")
    @Test
    void isNewGameTest() {
        //given
        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        final String playerResponse = "1";
        //then
        assertThat(numberBaseballGameMachine.isGameEnd(playerResponse)).isEqualTo(false);
    }

    @DisplayName("유저 input이 2일 때, 게임 종료 여부를 판단하는 테스트")
    @Test
    void isEndGame() {
        //given
        NumberBaseballGameMachine numberBaseballGameMachine = new NumberBaseballGameMachine();
        //when
        final String playerResponse = "2";
        //then
        assertThat(numberBaseballGameMachine.isGameEnd(playerResponse)).isEqualTo(true);
    }
}