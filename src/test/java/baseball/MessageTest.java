package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessageTest {

    @Test
    public void 올바른_안내_메시지_출력() throws Exception{

        //given
        String START = "숫자 야구 게임을 시작합니다.";
        String INPUT = "숫자를 입력해주세요";
        String EXIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        String CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        String BALL = "볼";
        String NOTHING = "낫싱";
        String STRIKE = "스트라이크";

        //then
        Assertions.assertEquals(START, Message.START.getMessage());
        Assertions.assertEquals(INPUT, Message.INPUT.getMessage());
        Assertions.assertEquals(EXIT, Message.EXIT.getMessage());
        Assertions.assertEquals(CHOICE, Message.CHOICE.getMessage());
        Assertions.assertEquals(BALL, Message.BALL.getMessage());
        Assertions.assertEquals(NOTHING, Message.NOTHING.getMessage());
        Assertions.assertEquals(STRIKE, Message.STRIKE.getMessage());
    }

}