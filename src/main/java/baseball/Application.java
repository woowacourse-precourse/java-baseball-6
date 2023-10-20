package baseball;

import static baseball.Message.BALL;
import static baseball.Message.BALL_MSG;
import static baseball.Message.END_MSG;
import static baseball.Message.INPUT_MSG;
import static baseball.Message.NON_MSG;
import static baseball.Message.NOTHING;
import static baseball.Message.REGAME_MSG;
import static baseball.Message.STRIKE;
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

    // 게임 진행 여부
    private static boolean gameState;

    // 컴퓨터 3자리 숫자
    private static List<Integer> computer = null;

    // 사용자 3자리 숫자
    private static List<Integer> user = null;

    // 결과 맵
    private static Map<String, Integer> result = null;

    public static void main(String[] args) throws IllegalArgumentException {
        gameStart();
    }

    private static void gameStart() {
        // 시작 메시지 호출
        System.out.println(Message.START_MSG);
        gameState = true;

        while (gameState) {
            // 컴퓨터 숫자 생성
            computer = RandomNumberUtils.pickNumberInRange(START_RANGE, LAST_RANGE);
            // 사용자 입력 및 결과 초기화
            init();
            // 게임 동작
            process();
        }
    }

    private static void process() {
        while (!success()) {
            // 사용자 입력 및 결과 초기화
            init();

            // 사용자 입력 값 받기
            String inputStr = getUserInput();

            // 입력 받은 사용자 값 리스트 등록
            StringToUserList(inputStr);

            // 야구 게임 결과
            result = baseballCount(computer, user);

            // 결과 메시지 출력
            outputMessage();
        }
    }

    private static void init() {
        // 사용자 리스트 초기화
        user = new ArrayList<>(COUNT);

        // 결과 초기화
        result = new HashMap<>();
        result.put(STRIKE, 0);
        result.put(BALL, 0);
        result.put(NOTHING, 0);
    }

    private static String getUserInput() {
        System.out.print(INPUT_MSG);
        String inputStr = Console.readLine();
        // 입력값 검증
        // 입력된 값 - 빈값 / 숫자 / 3자리 숫자 / 중복 확인
        CheckUtils.userInputCheck(inputStr, COUNT);
        return inputStr;
    }

    private static void StringToUserList(String inputStr) {
        char[] charArray = inputStr.toCharArray();
        for (char c : charArray) {
            user.add(Integer.parseInt(c + ""));
        }
    }

    private static Map<String, Integer> baseballCount(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < computer.size(); i++) {
            int computerValue = computer.get(i);
            int userValue = user.get(i);
            if (computerValue == userValue) {
                result.put(STRIKE, result.get(STRIKE) + 1);
            } else if (user.contains(computerValue)) {
                result.put(BALL, result.get(BALL) + 1);
            } else {
                result.put(NOTHING, result.get(NOTHING) + 1);
            }
        }
        return result;
    }

    private static boolean success() {
        if (result.get(STRIKE) == COUNT) {
            System.out.println(END_MSG);
            System.out.print(REGAME_MSG);
            if (!Console.readLine().equals("1")) {
                gameState = false;
            }
            return true;
        }
        return false;
    }

    private static void outputMessage() {
        StringBuilder sb = new StringBuilder();
        int ball = result.get(BALL);
        int strike = result.get(STRIKE);
        if (ball != 0) {
            sb.append(ball + BALL_MSG + " ");
        }
        if (strike != 0) {
            sb.append(strike + STRIKE_MSG);
        }

        if (sb.isEmpty()) {
            System.out.println(NON_MSG);
        } else {
            System.out.println(sb.toString());
        }
    }
}
