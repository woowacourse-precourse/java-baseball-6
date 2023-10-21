package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            baseball_game();
            Scanner sc = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input_num = Integer.parseInt(sc.next());
            if (input_num != 1) {
                break;
            }
        }
    }

    public static void baseball_game() {
        ArrayList<Integer> random_list = new ArrayList<>();

        while (random_list.size() < 3) {
            int random_num = Randoms.pickNumberInRange(1, 9);
            if (!random_list.contains(random_num)) {
                random_list.add(random_num);
            }
        }
//        System.out.println(random_list);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String exp_num_str = sc.next();

            String[] exp_num_split = exp_num_str.split("");
            List<String> exp_num_lst = Arrays.asList(exp_num_split);
            try{
                Set<String> set_exp_num = new HashSet<>(exp_num_lst);
                List<String> set_lst_exp_num = new ArrayList<>(set_exp_num);
                if (set_lst_exp_num.size() != 3) {
                    throw new IllegalArgumentException();
                }
                int exp_num = Integer.parseInt(exp_num_str);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getClass().getName());
                System.out.println(e.getMessage());
                System.exit(0);
            }

            int[] cnt_lst = {0, 0}; // ball, strike
            for (var i=0; i<3; i++) {
                if (Integer.parseInt(exp_num_lst.get(i)) == random_list.get(i)) { // strike
                    cnt_lst[1] += 1;
                } else if (random_list.contains(Integer.parseInt(exp_num_lst.get(i)))) { // ball
                    cnt_lst[0] += 1;
                }
            }
            if (cnt_lst[0] != 0) {
                System.out.print(cnt_lst[0]);
                System.out.print("볼");
            }
            if (cnt_lst[1] != 0) {
                System.out.print(cnt_lst[1]);
                System.out.print("스트라이크");
            } else if (cnt_lst[0] == 0) {
                System.out.print("낫싱");
            }
            System.out.print("\n");

            if (cnt_lst[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
