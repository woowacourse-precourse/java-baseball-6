package baseball;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    final Validation validation = new Validation();

    public void run() {
        boolean error = false;

        System.out.println("숫자 야구 게임을 시작합니다");
        List<Integer> computerNums = createRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요. : ");
            String userNum = camp.nextstep.edu.missionutils.Console.readLine();

            if (!validation.runException(userNum, "gaming")) {
                error = true;
                break;
            }

            int[] strikeBallNums = judgeStrikeOrBall(computerNums, userNum);

            int strike = strikeBallNums[0];
            int ball = strikeBallNums[1];
            showResult(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        if (!error && checkRestart()) {
            run();
        }
    }

    public List<Integer> createRandomNumber() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
            if (!computerNums.contains(num)) {
                computerNums.add(num);
            }
        }
        return computerNums;
    }

    public int[] judgeStrikeOrBall(List<Integer> computerNums, String userNums) {
        int[] strikeBallNums = new int[2];
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < 3; i++) {
            int computerNum = computerNums.get(i);
            int userNum = Integer.parseInt(userNums.substring(i,i+1));

            if (computerNum == userNum) {
                strikeCnt++;
            }
            else if (computerNums.contains(userNum)) {
                ballCnt++;
            }
        }
        strikeBallNums[0] = strikeCnt;
        strikeBallNums[1] = ballCnt;

        return strikeBallNums;
    }

    public void showResult(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
        else if (strike > 0 && ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        }
        else if (strike == 0 && ball > 0) {
            System.out.println(String.format("%d볼", ball));
        }
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean checkRestart() {
        boolean flag = false;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userAnswer = camp.nextstep.edu.missionutils.Console.readLine();

        if (validation.runException(userAnswer, "game over") && userAnswer.equals("1")) {
            flag = true;
        }

        return flag;
    }
}
