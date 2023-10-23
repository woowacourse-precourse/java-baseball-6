package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int[] index;

        //게임이 끝난 후 사용자가 계속 게임을 할 지에 대한 변수
        int continue_game;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = new ArrayList<>();
            index = new int[10];
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                    index[randomNumber] = computer.size();
                }
            }

            playing_game(computer, index);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continue_game = Integer.parseInt(readLine());

            if (continue_game == 1) {
                continue;
            }
            if (continue_game == 2) {
                break;
            }
        }
    }

    private static void playing_game(List<Integer> computer, int[] index) {
        StringBuilder sb;
        List<Integer> user_guess;
        String user_guess_input;
        int[] count;//count[0] = strike, count[1] = ball
        int strike;
        int ball;

        while (true) {

            sb = new StringBuilder();
            user_guess = new ArrayList<>();
            count = new int[2];

            System.out.printf("숫자를 입력해주세요 : ");
            user_guess_input = readLine();

            check_user_input(user_guess, user_guess_input);

            compare_input(user_guess, index, count);

            strike = count[0];
            ball = count[1];

            if (strike == 3) {
                sb.append(strike).append("스트라이크\n");
                sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println(sb);
                break;
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
        }
    }

    private static void compare_input(List<Integer> user_guess, int[] index, int[] count) {

        for (int i = 0; i < user_guess.size(); i++) {

            int now_user_num = user_guess.get(i);
            int now_user_index = i + 1;
            int now_com_num = user_guess.get(i);
            int now_com_index = index[now_com_num];

            if (now_com_index == now_user_index) {
                count[0]++;
            } else if (now_com_index != 0) {
                count[1]++;
            }
        }
    }

    private static void check_user_input(List<Integer> user_guess, String user_guess_input) {
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
