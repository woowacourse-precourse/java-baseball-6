package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Games {
    int pick_num_min, pick_num_max, pick_num_len;

    Games(int pick_num_len, int pick_num_min, int pick_num_max) {
        this.pick_num_len = pick_num_len;
        this.pick_num_min = pick_num_min;
        this.pick_num_max = pick_num_max;
    }
    public void baseball_game() {
        Modules modules = new Modules();

        List<Integer> random_list = modules.makeRandomList(pick_num_len, pick_num_min, pick_num_max);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String expected_num_str = Console.readLine();
            modules.isTypeInt(expected_num_str);

            String[] expected_num_split = expected_num_str.split("");
            List<String> set_lst_expected_num = modules.dropDuplicateFromArray2List(expected_num_split);
            if (set_lst_expected_num.size() != 3) {
                throw new IllegalArgumentException();
            }
            if (set_lst_expected_num.contains("0")) {
                throw new IllegalArgumentException();
            }

            Results results = new Results(random_list, expected_num_split);
            String result_str = results.resultBallStrike();
            System.out.println(result_str);

            if (results.cnt_lst[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
