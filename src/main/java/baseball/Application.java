package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {

    static int strike;
    static int ball;
    static int state;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public static void startGame() {

        state = 1;

        String answer = makeAnswer();
        while (state == 1) {

            System.out.print("숫자를 입력해주세요 : ");
            init_ball_strike(); // 볼, 스트라이크 초기화

            String user_input = input(); // 인풋 받기

            compareAnswerAndUserInput(answer, user_input); // 인풋과 답 비교
            printBallAndStrike(); // 스트라이크, 볼 출력
            answer = restart(strike, answer);
        }
    }

    public static String makeAnswer() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String answer = "";
        for (int i = 0; i < 3; i++) {
            answer += computer.get(i);
        }

        return answer;
    }

    public static void init_ball_strike() {
        strike = 0;
        ball = 0;
    }

    public static void printBallAndStrike() {

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void compareAnswerAndUserInput(String answer, String user_input) {

        char[] answerChar = answer.toCharArray();
        char[] userInputChar = user_input.toCharArray();

        if (answer.equals(user_input)) {
            strike = 3;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == j && answerChar[i] == userInputChar[j]) {
                    strike += 1;
                    break;
                }

                if (answerChar[i] == userInputChar[j]) {
                    ball += 1;
                    break;
                }
            }
        }
    }

    public static String input() {

        String input = Console.readLine();

        try {
            // 숫자를 입력받지 않았을 때
            int input_num = Integer.parseInt(input);

            // 입력 받은 숫자가 3자리가 아닐때
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            // 중복 처리
            char[] inputChar = input.toCharArray();

            if (inputChar[0] == inputChar[1] || inputChar[1] == inputChar[2] || inputChar[0] == inputChar[2]) {
                throw new IllegalArgumentException();
            }

            return input;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String restart(int strike, String answer) {

        if (strike == 3) {

            System.out.println("개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartInput = Console.readLine();

            if (restartInput.equals("1")) {
                return makeAnswer();
            } else if (restartInput.equals("2")) {
                state = 0;
                return answer;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            return answer;
        }
    }
}
