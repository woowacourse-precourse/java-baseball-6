package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameMachineTest {

    @DisplayName("console 테스트")
    @Test
    void input() {
        //given
        String inputLine = "콘솔로 입력합니다.";
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);

        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        //when
        String input = baseballGameMachine.input();
        //then
        assertThat(inputLine).isEqualTo(input);
    }

    @DisplayName("게임 실행 테스트")
    @Test
    void gamePlayTest() {
        //given
        String inputLine = "351";
        InputStream inputStream = new ByteArrayInputStream(inputLine.getBytes());
        System.setIn(inputStream);

        BaseballGameMachine gameMachine = new BaseballGameMachine();
        //when
        gameMachine.play();
    }
}