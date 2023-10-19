package baseball;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int[] nums = new int[3];
        int[] ans = new int[3];
        boolean[] is_chosen = new boolean[10];
        boolean is_continue = true;

        while (is_continue)
        {
            int strike_cnt = 0;
            int ball_cnt = 0;
            Arrays.fill(is_chosen, false);
            for (int i = 0; i < 3; ) {
                int tmp_num = pickNumberInRange(1, 9);
                if (!is_chosen[tmp_num])
                    nums[i++] = tmp_num;
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            //System.out.printf("답: %d %d %d\n", nums[0], nums[1], nums[2]);

            while (strike_cnt < 3)
            {
                strike_cnt = ball_cnt = 0;
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    int ans_full = Integer.parseInt(readLine());
                    System.out.println(ans_full);
                    if (ans_full < 100 || ans_full > 999)
                        throw new IllegalArgumentException();

                    Arrays.fill(is_chosen, false);
                    for (int i = 2; i >= 0; --i) {
                        int tmp_num = ans_full % 10;
                        if (tmp_num == 0 || is_chosen[tmp_num])
                            throw new IllegalArgumentException();
                        ans[i] = tmp_num;
                        is_chosen[tmp_num] = true;
                        ans_full /= 10;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("IllegalArgumentException occurred");
                    return;
                }

                for (int i = 0; i < 3; ++i) {
                    if (nums[i] == ans[i])
                        strike_cnt++;
                    else if (nums[i] == ans[(i + 1) % 3] || nums[i] == ans[(i + 2) % 3])
                        ball_cnt++;
                }

                if (ball_cnt > 0)
                    System.out.printf("%d볼 ", ball_cnt);
                if (strike_cnt > 0)
                    System.out.printf("%d스트라이크", strike_cnt);
                if (ball_cnt == 0 && strike_cnt == 0)
                    System.out.print("낫싱");
                System.out.println();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            try {
                int continue_opt = Integer.parseInt(readLine());
                if (continue_opt == 2)
                    is_continue = false;
                else if (continue_opt != 1)
                    throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("error: IllegalArgumentException occurred");
                return;
            }
        }
    }
}
