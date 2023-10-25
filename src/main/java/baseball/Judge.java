package baseball;

import java.util.ArrayList;

public class Judge {
    int strike;
    int ball;
    public int[] outcome(Computer computer, User user) {
        ArrayList<Integer> computerNumber = computer.getNumber();
        ArrayList<Integer> userNumber = user.getNumber();
        strike=0;
        ball=0;

        int arr[] = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
            else if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        arr[0]=strike;
        arr[1]=ball;
        return arr;
    }

    public int printJudge(int[] arr) {
        if (strike == 0 && ball == 0)
            System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if (strike == 0)
            System.out.println(ball + "볼");
        else if (ball == 0)
            System.out.println(strike + "스트라이크");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");
        return 0;
    }

}
