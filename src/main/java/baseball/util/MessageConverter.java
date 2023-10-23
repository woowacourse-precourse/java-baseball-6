package baseball.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 플레이어와 컴퓨터의 숫자를 비교하여 스트라이크, 볼로 변환하는 클래스
 * */
public class MessageConverter {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final int NUMBER_SIZE = 3;

    private static Map<String, Integer> resultMessage;

    /*
    * ConcurrentHashMap 초기화 메서드
    * */
    private static void initializeResultMessage() {
        resultMessage = new ConcurrentHashMap<>() {
            {
                put(STRIKE, 0);
                put(BALL, 0);
            }
        };
    }

    /*
    * 플레이어와 컴퓨터의 숫자를 비교하는 전체 메서드
    * @Param input 플레이어의 숫자
    * @Param computerNumber 컴퓨터의 숫자
    * */
    public static Map<String, Integer> getResultMessage(List<Integer> input, List<Integer> computerNumber) {
        initializeResultMessage();

        for(int index = 0; index < NUMBER_SIZE; index++) {
            getStrikeOrBall(input, computerNumber, index);
        }

        return resultMessage;
    }

    /*
     * 플레이어와 컴퓨터의 숫자를 비교하는 메서드
     * @Param input 플레이어의 숫자
     * @Param computerNumber 컴퓨터의 숫자
     * @Param index 리스트의 인덱스
     * */
    private static void getStrikeOrBall(List<Integer> input, List<Integer> computerNumber, Integer index) {
        if (input.get(index).equals(computerNumber.get(index))) {
           resultMessage.put(STRIKE, resultMessage.get(STRIKE) + 1);
        }

        if (input.contains(computerNumber.get(index)) && !input.get(index).equals(computerNumber.get(index))) {
            resultMessage.put(BALL, resultMessage.get(BALL) + 1);
        }
    }

}
