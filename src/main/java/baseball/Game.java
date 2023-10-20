package baseball;

import static baseball.Message.BALL;
import static baseball.Message.COUNT;
import static baseball.Message.END_MSG;
import static baseball.Message.INPUT_MSG;
import static baseball.Message.LAST_RANGE;
import static baseball.Message.NOTHING;
import static baseball.Message.REGAME_MSG;
import static baseball.Message.START_MSG;
import static baseball.Message.START_RANGE;
import static baseball.Message.STRIKE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    // 게임 진행 여부
    private static boolean gameState;

    // 컴퓨터 3자리 숫자
    private static List<Integer> computer = null;

    // 사용자 3자리 숫자
    private static List<Integer> user = null;

    // 결과 맵
    private static Map<String, Integer> result = null;

    public static void gameStart() {
        // 시작 메시지 호출
        PrintMessage.println(START_MSG);

        // 게임 start 시 1회는 무조건 진행되야 함으로 while 보단 do while 사용
        do {
            // 사용자 입력 및 결과 초기화
            init();
            // 게임 동작
            process();
        } while (gameState);
    }

    private static void process() {
        while (!success()) {
            // 사용자 입력 및 결과 초기화
            reset();

            // 사용자 입력 값 받기
            String inputStr = getUserInput();

            // 입력 받은 사용자 값 리스트 등록
            StringToUserList(inputStr);

            // 야구 게임 결과
            baseballCount(computer, user);

            // 결과 메시지 출력
            PrintMessage.outputMessage(result.get(BALL), result.get(STRIKE));
        }
    }

    private static void init() {
        // 게임 상태 초기화
        gameState = true;

        // 컴푸터 리스트 초기화
        // 컴퓨터 숫자 생성
        computer = RandomNumberUtils.pickNumberInRange(START_RANGE, LAST_RANGE);

        // 사용자 리스트 초기화
        user = new ArrayList<>(COUNT);

        // 결과 초기화
        result = new HashMap<>();
        result.put(STRIKE, 0);
        result.put(BALL, 0);
        result.put(NOTHING, 0);
    }

    private static void reset() {
        // 사용자 리스트 초기화
        user.clear();

        // 결과 초기화
        result.clear();
        result.put(STRIKE, 0);
        result.put(BALL, 0);
        result.put(NOTHING, 0);
    }

    private static String getUserInput() {
        PrintMessage.print(INPUT_MSG);
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

    private static void baseballCount(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < computer.size(); i++) {
            int computerValue = computer.get(i);
            int userValue = user.get(i);
            addMapResult(user, computerValue, userValue);
        }
    }

    private static void addMapResult(List<Integer> user, int computerValue, int userValue) {
        if (computerValue == userValue) {
            result.put(STRIKE, result.get(STRIKE) + 1);
        } else if (user.contains(computerValue)) {
            result.put(BALL, result.get(BALL) + 1);
        } else {
            result.put(NOTHING, result.get(NOTHING) + 1);
        }
    }

    private static boolean success() {
        if (result.get(STRIKE) == COUNT) {
            PrintMessage.println(END_MSG);
            PrintMessage.print(REGAME_MSG);
            if (!Console.readLine().equals("1")) {
                gameState = false;
            }
            return true;
        }
        return false;
    }
}
