package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    List<Integer> make_rand_nums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    List<Integer> get_ans_input() throws IllegalArgumentException{
        List<Integer> user = new ArrayList<>();

        int ans = Integer.parseInt(readLine());
        if (ans < 100 || ans > 999) {
            throw new IllegalArgumentException();
        }
        while (user.size() < 3) {
            int num = ans % 10;
            ans /= 10;
            if (num == 0 || user.contains(num)) {
                throw new IllegalArgumentException();
            }
            user.add(0, num);
        }

        return user;
    }

    int get_close_input() throws IllegalArgumentException{
        int continue_opt;
        continue_opt = Integer.parseInt(readLine());
        if (continue_opt != 1 && continue_opt != 2) {
            throw new IllegalArgumentException();
        }

        return continue_opt;
    }

    void print_score(int ball_cnt, int strike_cnt) {
        if (ball_cnt > 0)
            System.out.printf("%d볼 ", ball_cnt);
        if (strike_cnt > 0)
            System.out.printf("%d스트라이크", strike_cnt);
        if (ball_cnt == 0 && strike_cnt == 0)
            System.out.print("낫싱");
        System.out.println();
    }

    int play_round(List<Integer> computer_nums) {
        int strike_cnt = 0;
        int ball_cnt = 0;
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> user_nums = get_ans_input();

        for (int i = 0; i < 3; ++i) {
            Integer computer_num = computer_nums.get(i);
            if (Objects.equals(computer_num, user_nums.get(i)))
                strike_cnt++;
            else if (user_nums.contains(computer_num))
                ball_cnt++;
        }
        print_score(ball_cnt, strike_cnt);

        return strike_cnt;
    }

    void play_game() {
        List<Integer> computer_nums = make_rand_nums();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //System.out.printf("답: %d %d %d\n",computer_nums.get(0), computer_nums.get(1), computer_nums.get(2));

        int strike_cnt;
        do {
            strike_cnt = play_round(computer_nums);
        } while (strike_cnt < 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    boolean is_continue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return get_close_input() == 1;
    }
}