package baseball;

import static baseball.Message.BALL_MSG;
import static baseball.Message.END_MSG;
import static baseball.Message.INPUT_MSG;
import static baseball.Message.NON_MSG;
import static baseball.Message.REGAME_MSG;
import static baseball.Message.STRIKE_MSG;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for (Integer i : computer) {
            System.out.println("i = " + i);
        }

        // 3. 사용자의 입력 값 받기
        System.out.print(INPUT_MSG);
        String inputStr = Console.readLine();

        // 4. 입력 받은 사용자 값 확인
        // 입력된 값 - 빈값 / 숫자 / 3자리 숫자 / 중복 확인
        CheckUtils.userInputCheck(inputStr, COUNT);

        // 체크 정상 처리 된 경우
        List<Integer> user = new ArrayList<>(COUNT);
        char[] charArray = inputStr.toCharArray();
        for (char c : charArray) {
            user.add(Integer.parseInt(c + ""));
        }

        // 5. 야구 게임 결과 체크
        Map<String, Integer> result = baseballCount(computer, user);

        // 6. 결과 해석 및 게임 종료 여부 체크
        if (result.get(BaseBall.STRIKE) == COUNT) {
            System.out.println(END_MSG);
            System.out.print(REGAME_MSG);
            if (Console.readLine().equals("1")) {
                System.out.println("재게임");
            } else {
                return;
            }
        } else if (result.get(BaseBall.NOTHING) == COUNT) {
            System.out.println(NON_MSG);
            // 다시 사용자 입력 받기
        } else {
            StringBuilder sb = new StringBuilder();
            int ball = result.get(BaseBall.BALL);
            int strike = result.get(BaseBall.STRIKE);
            if (ball != 0) {
                sb.append(ball + BALL_MSG + " ");
            }
            if (strike != 0) {
                sb.append(strike + STRIKE_MSG);
            }
            System.out.println(sb.toString());
        }

    }

    private static Map<String, Integer> baseballCount(List<Integer> computer, List<Integer> user) {
        Map<String, Integer> result = new HashMap<>();
        result.put(BaseBall.STRIKE, 0);
        result.put(BaseBall.BALL, 0);
        result.put(BaseBall.NOTHING, 0);

        for (int i = 0; i < computer.size(); i++) {
            int computerValue = computer.get(i);
            int userValue = user.get(i);
            if (computerValue == userValue) {
                result.put(BaseBall.STRIKE, result.get(BaseBall.STRIKE) + 1);
            } else if (user.contains(computerValue)) {
                result.put(BaseBall.BALL, result.get(BaseBall.BALL) + 1);
            } else {
                result.put(BaseBall.NOTHING, result.get(BaseBall.NOTHING) + 1);
            }
        }
        return result;
    }


}
