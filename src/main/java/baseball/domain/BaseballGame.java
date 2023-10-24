package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.ErrorMessage.WRONG_RESPONSE_AFTER_FINISH;
import static baseball.constants.GameMessage.*;
import static baseball.constants.GameOption.ANSWER_NUMBER_LENGTH;
import static baseball.constants.SystemOption.EXIT_SYSTEM_VALUE;
import static baseball.constants.SystemOption.RESTART_SYSTEM_VALUE;

public class BaseballGame {
    private Answer answer;
    private Rule rule;

    public BaseballGame() {
        rule = new Rule();
        answer = new Answer();
    }

    public void run() {
        System.out.println(START_MESSAGE);
        start();
    }

    private void start() {
        // 사용자가 맞춰야 하는 정답 생성
        answer.pickNumbers();

        int[] score;
        do {
            String userInput = getUserInput();

            // 사용자가 입력한 문자열 형태의 숫자가 유효한지, 유효성 검증
            int[] inputNumbers = rule.validateUserInput(userInput);

            // 사용자가 입력한 수와 정답과 비교하여 점수 계산
            score = answer.calculateScore(inputNumbers);

            // 점수 출력
            printScore(score);
        } while (!canFinish(score));

        // 재시작 여부 확인
        if (checkRestart()) {
            start();
        }
    }

    private static String getUserInput() {
        System.out.print(GET_USER_INPUT);
        return Console.readLine();
    }

    private boolean canFinish(int[] score) {
        int countOfStrikes = score[0];

        // 스트라이크 개수와 맞춰야 하는 숫자의 개수와 일치하는 경우 정답이므로 종료
        if (countOfStrikes == ANSWER_NUMBER_LENGTH.getLength()) {
            System.out.println(FINISH_MESSAGE);
            return true;
        }

        return false;
    }

    private void printScore(int[] score) {
        StringBuilder result = new StringBuilder();
        int countOfStrikes = score[0], countOfBalls = score[1];

        // 볼 개수 입력
        if (countOfBalls > 0) {
            result.append(countOfBalls).append(BALL).append(" ");
        }

        // 스트라이크 개수 입력
        if (countOfStrikes > 0) {
            result.append(countOfStrikes).append(STRIKE).append(" ");
        }

        // 낫싱인 경우 입력
        if (countOfBalls == 0 && countOfStrikes == 0) {
            result.append(NOTHING);
        }

        System.out.println(result);
    }

    private boolean checkRestart() {
        String userInput = Console.readLine();
        
        if (userInput.equals(RESTART_SYSTEM_VALUE.getValue())) {
            return true;
        }

        if (userInput.equals(EXIT_SYSTEM_VALUE.getValue())) {
            return false;
        }

        throw new IllegalStateException(WRONG_RESPONSE_AFTER_FINISH.toString());

    }
}
