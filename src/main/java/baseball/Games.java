package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Games {
    int pick_num_min, pick_num_max, pick_num_len;

    Games(int pick_num_min, int pick_num_max, int pick_num_len) {
        this.pick_num_min = pick_num_min;
        this.pick_num_max = pick_num_max;
        this.pick_num_len = pick_num_len;
    }
    public void baseball_game() {
        Modules modules = new Modules();

        List<Integer> random_list = modules.makeRandomList(pick_num_min, pick_num_max, pick_num_len);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String expected_num_str = Console.readLine();
            modules.isTypeInt(expected_num_str);

            String[] expected_num_split = expected_num_str.split("");
            List<String> set_lst_expected_num = modules.dropDuplicateFromArray2List(expected_num_split);
            if (set_lst_expected_num.size() != 3) {
                throw new IllegalArgumentException();
            }

            int[] cnt_lst = {0, 0}; // ball, strike
            for (var i=0; i<3; i++) {
                if (Integer.parseInt(expected_num_split[i]) == random_list.get(i)) { // strike
                    cnt_lst[1] += 1;
                } else if (random_list.contains(Integer.parseInt(expected_num_split[i]))) { // ball
                    cnt_lst[0] += 1;
                }
            }
            String result_str = "";
            if (cnt_lst[0] != 0) {
                result_str += cnt_lst[0] + "볼 ";
            }
            if (cnt_lst[1] != 0) {
                result_str += cnt_lst[1] + "스트라이크";
            } else if (cnt_lst[0] == 0) {
                result_str = "낫싱";
            }
            System.out.println(result_str.trim());

            if (cnt_lst[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
