package baseball;

import java.util.List;

public class JudgeBallStrike {
    public static int judge(List<Integer> computer, String num) {
        int[] nums = {Integer.parseInt(num) / 100, Integer.parseInt(num) % 100 / 10, Integer.parseInt(num) % 100 % 10};
        int result = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i) == nums[j]) {
                    result += 10;
                    if (i == j) {
                        result += 1;
                        result -= 10;
                    }
                }
            }
        }
        return result;
    }
}
