package baseball;


import java.util.List;

public class Judge {
    public boolean count(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i).equals(user.get(j))) {
                    if (i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }
        result(ball, strike);
        return strike == 3;
    }


    private void result(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.print(ball + "볼");
        } else if (strike == 3) {
            System.out.print("3스트라이크");
            System.out.println("3개의 숫자를 다 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if (ball == 0) {
            System.out.print(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
