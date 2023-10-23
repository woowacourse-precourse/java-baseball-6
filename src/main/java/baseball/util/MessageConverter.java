package baseball.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 플레이어와 컴퓨터의 숫자를 비교하여 스트라이크, 볼로 변환하는 클래스
 * */
public class MessageConverter {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private Map<String, Integer> resultMessage;

    /*
    * 점수 초기화 메서드
    * */
    public void initializeResultMessage() {
        this.resultMessage = new ConcurrentHashMap<>() {
            {
                put(STRIKE, 0);
                put(BALL, 0);
            }
        };
    }
}
