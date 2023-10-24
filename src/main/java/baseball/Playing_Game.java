package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Playing_Game {

    static void playingGame(List<Integer> computer, int[] index) {
        StringBuilder sb;
        List<Integer> user_guess;
        String user_guess_input;
        Count count;
        int strike;
        int ball;

        while (true) {

            sb = new StringBuilder();
            user_guess = new ArrayList<>();
            count = new Count(0, 0);

            System.out.printf("숫자를 입력해주세요 : ");
            user_guess_input = readLine();

            checkUserInput(user_guess, user_guess_input);

            validateAnswer(user_guess, index, count);

            strike = count.getStrike();
            ball = count.getBall();

            if (generateOutput(sb, strike, ball)) {
                break;
            }
        }
    }

    private static boolean generateOutput(StringBuilder sb, int strike, int ball) {
        if (strike == 3) {
            sb.append(strike).append("스트라이크\n");
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println(sb);
            return true;
        } else if (strike > 0 && ball > 0) {
            sb.append(ball).append("볼 ").append(strike).append("스트라이크");
        } else if (strike > 0) {
            sb.append(strike).append("스트라이크");
        } else if (ball > 0) {
            sb.append(ball).append("볼");
        } else if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);
        return false;
    }

    private static void validateAnswer(List<Integer> user_guess, int[] index, Count count) {

        for (int i = 0; i < user_guess.size(); i++) {

            int now_user_num = user_guess.get(i);
            int now_user_index = i + 1;
            int now_com_num = user_guess.get(i);
            int now_com_index = index[now_com_num];

            int strike = count.getStrike();
            int ball = count.getBall();

            if (now_com_index == now_user_index) {
                count.setStrike(++strike);
            } else if (now_com_index != 0) {
                count.setBall(++ball);
            }
        }
    }

    private static void checkUserInput(List<Integer> user_guess, String user_guess_input) {
        if (user_guess_input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : user_guess_input.toCharArray()) {
            if (user_guess.contains(c)) {
                throw new IllegalArgumentException();
            }
            user_guess.add(Integer.parseInt(String.valueOf(c)));
        }
    }
}
