package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballFunction implements BaseballGame {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> compare_number_result = new ArrayList<>();

    BaseballFunction() {
        make_computer_number();
    }

    @Override
    public void make_computer_number() {
        if (!computer.isEmpty()) {
            computer.clear();
        }

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    @Override
    public void compare_number(int input_value) {
        compare_number_result.clear();
        for (int i = computer.size() - 1; i >= 0; i--) {
            int count = 2;
            for (int j = 1; input_value / j != 0; j *= 10, count--) {
                int compare_res = Integer.compare(computer.get(i), input_value / j % 10);

                if (compare_res == 0 && i == count) {
                    compare_number_result.add(2);
                } else if (compare_res == 0) {
                    compare_number_result.add(1);
                }
            }
        }
    }

    @Override
    public boolean game_exe(int game_exe_number) {
        if (game_exe_number == 1) {
            make_computer_number();
            return false;
        } else if (game_exe_number == 2) {
            return true;
        }

        throw new IllegalArgumentException("error");
    }

    public boolean print_result() {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (var i : compare_number_result) {
            if (i == 1) {
                ballCnt++;
            } else if (i == 2) {
                strikeCnt++;
            }
        }

        if (ballCnt != 0 && strikeCnt != 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        } else if (ballCnt != 0) {
            System.out.println(ballCnt + "볼");
        } else if (strikeCnt != 0) {
            System.out.println(strikeCnt + "스트라이크");
            if (strikeCnt == 3) {
                return true;
            }
        } else {
            System.out.println("낫싱");
        }

        return false;
    }
}
