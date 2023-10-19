package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println(Instruction.START);
        String answer = createRandomAnswer();

        while (true) {
            System.out.println(Instruction.INPUT);
            String playerInput = Console.readLine();
            validateInput(playerInput);

            Result result = getResult(answer, playerInput);
            result.print();

            if (result.isAnswer()) {
                System.out.println(Instruction.CORRECT);
                System.out.println(Instruction.END);
                playerInput = Console.readLine();
                if (playerInput.equals("1")) {
                    answer = createRandomAnswer();
                } else if (playerInput.equals("2")){
                    break;
                } else {
                    throw new IllegalArgumentException("게임을 종료합니다.");
                }
            }
        }
    }

    private static String createRandomAnswer() {
        List<Integer> answers = new ArrayList<>();
        while (answers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randomNumber)) {
                answers.add(randomNumber);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : answers) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static void validateInput(String input) {
        // 세자리 수가 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }

        // 0을 포함하는 경우
        if (input.contains("0")) {
            throw new IllegalArgumentException("0을 포함하지 않는 숫자를 입력해주세요.");
        }

        // 서로 다른 세자리수가 아닌 경우
        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해주세요.");
        }

        // 숫자 입력이 아닌 경우
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static Result getResult(String answer, String playerInput) {
        Result result = new Result(0, 0);
        for (int idx = 0; idx < 3; idx++) {
            char c = playerInput.charAt(idx);
            if (answer.charAt(idx) == c) {
                result.strike++;
            } else if (answer.indexOf(c) >= 0) {
                result.ball++;
            }
        }
        return result;
    }

    private static class Result {
        int ball;
        int strike;

        public Result(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }

        public void print() {
            if (isNothing()) {
                System.out.println(Instruction.NOTHING);
            } else {
                if (ball > 0) {
                    System.out.printf("%d%s ", ball, Instruction.BALL);
                }
                if (strike > 0) {
                    System.out.printf("%d%s", strike, Instruction.STRIKE);
                }
                System.out.println();
            }
        }

        public boolean isAnswer() {
            return strike == 3;
        }

        private boolean isNothing() {
            return ball == 0 && strike == 0;
        }
    }

    private enum Instruction {
        START("숫자 야구 게임을 시작합니다."),
        CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        INPUT("1 ~ 9로 이루어진 세자리 숫자를 입력해주세요 : "),
        BALL("볼"),
        STRIKE("스트라이크"),
        NOTHING("낫싱"),
        ;

        private final String message;

        Instruction(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
