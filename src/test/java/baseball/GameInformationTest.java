package baseball;

import baseball.model.GameInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameInformationTest {

    private int numberCount = 3;
    private GameInformation gameInformation = new GameInformation(numberCount);

    @Test
    void 랜덤_숫자_생성시_numberCount_개의_숫자_생성_확인() {
        Assertions.assertEquals(gameInformation.makeRandomNumber().length(), numberCount);
    }

    @Test
    void 정답과_입력값_비교후_힌트_출력_3스트라이크(){
        String input = gameInformation.makeRandomNumber();

        gameInformation.compareAndSetStrikeBallCount(input);
        int strike = gameInformation.getStrikeCount();
        int ball = gameInformation.getBallCount();

        Assertions.assertEquals(input.length(), strike);
        Assertions.assertEquals(0, ball);
    }
}
