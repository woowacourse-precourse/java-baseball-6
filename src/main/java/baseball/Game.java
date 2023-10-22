package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.HashSet;

import static baseball.Constant.InputType.ANSWER;
import static baseball.Constant.InputType.RESTART_OR_END;

public class Game {

    private String answer;
    private HashMap<Character, Integer> answerMap;
    void start() {
        while (true) {
            init();
            run();
            String userInput = InputUtil.getUserInput(RESTART_OR_END);
            if (userInput.equals(Constant.END)) {
                break;
            }
        }
    }

    private void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initAnswer();
    }

    private void initAnswer() {
        answerMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);
            if (!visited.contains(randomInt)) {
                visited.add(randomInt);
                sb.append(randomInt);
                answerMap.put(sb.charAt(sb.length() - 1), sb.length()-1);
            }
        }
        answer = sb.toString();
    }

    private void run() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = InputUtil.getUserInput(ANSWER);
            printResult(userInput);
            if (isEnd(userInput)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void printResult(String userInput) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == userInput.charAt(i)) {
                strike += 1;
            } else if (answerMap.containsKey(userInput.charAt(i))) {
                ball += 1;
            }
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.print(ball+"볼 ");
            }
            if (strike != 0) {
                System.out.print(strike+"스트라이크");
            }
            System.out.println();
        }

    }

    private boolean isEnd(String userInput) {
        return answer.equals(userInput);
    }


}
