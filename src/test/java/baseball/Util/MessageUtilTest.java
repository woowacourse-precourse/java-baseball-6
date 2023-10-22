package baseball.Util;

import baseball.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageUtilTest {
    private final MessageUtil messageUtil = new MessageUtil();

    @Test
    @DisplayName("스트라이크와 볼의 개수에 따라 다른 메시지를 출력")
    public void should_printDiffMsg_ByAmount(){
        messageUtil.printResult(new Result(0, 1));
        messageUtil.printResult(new Result(1, 0));
        messageUtil.printResult(new Result(1,1));
    }
}