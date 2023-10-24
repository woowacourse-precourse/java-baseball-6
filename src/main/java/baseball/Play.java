package baseball;
import camp.nextstep.edu.missionutils.Console;

import static baseball.GeneratingNumbers.nums;

public class Play {
    GeneratingNumbers getNums = new GeneratingNumbers();
    Result result = new Result();

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int flag = 1;
        getNums.getComputerNums();

        while (flag >= 1) {
            if (flag == 2) {  // 다시하기 분기
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int ans = Integer.parseInt(Console.readLine());
                if (ans == 1) { // 재시작
                    getNums.getComputerNums();
                    flag = ans;
                } else if (ans == 2) {  // 게임 종료
                    flag = 0;
                    System.out.println("게임이 종료되었습니다.");
                } else
                    throw new IllegalArgumentException();
            } else if (flag == 1) {
                getNums.getMyNums();
                flag = result.getGameResultJudgment(nums.getComputer(), nums.getMine());
            }
        }
    }
}
