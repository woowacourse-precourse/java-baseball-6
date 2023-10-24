package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Comparer;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.RetryNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("게임종료 후 재시작")
    void startGameAndRetry() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("컴퓨터 랜덤값 생성")
    void generateComputerRandomNumber(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.generateComputerNumber();
    }

    @DisplayName("사용자 입력 예외사항 처리")
    @ParameterizedTest
    @ValueSource(strings = {"31","i","3a6","abc","012","311",""," "})
    void validatePlayerNumber(String playerInput) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new PlayerNumber(playerInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("컴퓨터 숫자와 사용자입력 숫자 비교하기")
    @ParameterizedTest
    @CsvSource({"123,713", "145,145", "216,384"})
    void compareComputerNumberAndPlayerNumber(String computerNumber, String playerNumber){
        Comparer comparer = new Comparer(computerNumber, playerNumber);
        System.out.println("볼: "+comparer.getBallCount());
        System.out.println("스트라이크: "+comparer.getStrikeCount());
    }

    @Test
    @DisplayName("비교 결과 출력하기")
    void printResult(){
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.printResult(new int[] {1,1});
    }


    @DisplayName("게임종료 후 사용자 입력 예외사항 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0","i","3",""," "})
    void validateRetryNumber(String playerInput){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RetryNumber(playerInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
