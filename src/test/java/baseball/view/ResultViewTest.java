package baseball.view;

import javax.xml.transform.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultViewTest {
    @Test
    void 게임_시작시_출력메시지(){
        ResultView.startMessage();
    }
    @Test
    void 게임_진행_입력메시지(){
        ResultView.processMessage();
    }
    @Test
    void 게임_종료시_출력메시지(){
        ResultView.endMessage();
    }
    @Test
    void 재시작_여부_메시지(){
        ResultView.isReplayMessage();
    }
}
