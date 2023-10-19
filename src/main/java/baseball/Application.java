package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // 야구 게임 자릿수
    public static final int COUNT = 3;
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
        List<Integer> computer = RandomNumberUtils.pickNumberInRange(START_RANGE, LAST_RANGE);

        // 3. 사용자의 입력 값 받기
        System.out.print(Message.INPUT_MSG);
        String inputStr = Console.readLine();

        // 4. 입력 받은 사용자 값 확인
        List<Integer> user = new ArrayList<>(COUNT);
        // 5. 입력된 값 - 빈값 / 숫자 / 3자리 숫자 / 중복 확인
        CheckUtils.userInputCheck(inputStr, COUNT);

        // 체크 정상 처리 된 경우
        char[] charArray = inputStr.toCharArray();
        for (char c : charArray) {
            user.add(Integer.parseInt(c + ""));
        }


    }


}
