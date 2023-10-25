package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import baseball.Modules;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            baseball_game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input_num = Console.readLine();
            if (Objects.equals(input_num, "2")) {
                break;
            } else if (Objects.equals(input_num, "1")) {

            } else throw new IllegalArgumentException();
        }
    }

    public static void baseball_game() {
        Modules modules = new Modules();

        List<Integer> random_list = new ArrayList<>();

        while (random_list.size() < 3) {
            int random_num = Randoms.pickNumberInRange(1, 9);
            if (!random_list.contains(random_num)) {
                random_list.add(random_num);
            }
        }

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
