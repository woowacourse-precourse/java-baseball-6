package baseball;

import java.util.List;

public class Application {
    // 야구 게임 자릿수
    private static final int COUNT = 3;
    // 시작 범위
    private static final int START_RANGE = 1;
    // 종료 범위
    private static final int LAST_RANGE = 9;

    // 컴퓨터 3자리 숫자
    private static List<Integer> computer = null;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 시작 메시지 호출
        System.out.println(Message.START_MSG);

        // 2. 컴퓨터 숫자 생성
        List<Integer> computer = RandomNumberUtils.pickUniqueNumbersInRange(START_RANGE, LAST_RANGE, COUNT);

        System.out.println(Message.INPUT_MSG);


    }


}
