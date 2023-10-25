package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.StringTokenizer;

public class PlayGame {

    public boolean compareNum(List<Integer> computer, List<Integer> user) {
        int strike = cntStrike(computer, user);
        int ball = cntBall(computer, user);

        if (printRes(strike, ball)) {
            // 1 or 2 입력을 받고 옵션에 따른 기능
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            StringTokenizer st = new StringTokenizer(Console.readLine());
            String input = st.nextToken();
            if ("2".equals(input)) {
                return false; // 게임 종료
            }
        }
        return true; // 게임 지속
    }

    public int cntStrike(List<Integer> computer, List<Integer> user) {
        int cnt1 = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                cnt1++;
            }
        }
        return cnt1;
    }

    public int cntBall(List<Integer> computer, List<Integer> user) {
        int cnt2 = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (!computer.get(i).equals(user.get(i)) && computer.contains(user.get(i))) {
                cnt2++;
            }
        }
        return cnt2;
    }

    public boolean printRes(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
}
