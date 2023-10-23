package baseball;

import java.util.ArrayList;
import java.util.List;

public class Assessment {

    // 결과 판정
    public static void assessment(ArrayList<Integer> c, ArrayList<Integer> u) {

        int ball = 0 ;
        int strike = 0 ;

        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).equals(u.get(i))) {
                // 같은 자리에 같은 숫자일 때 스트라이크
                strike++;
            } else if (u.contains(c.get(i))) {
                // 다른 자리에 같은 숫자일 때 볼
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            StartOrQuitGame.startOrQuitGame();
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }
            System.out.println();
            ArrayList<Integer> newUserinput = UserInput.userInput();
            Assessment.assessment(c, newUserinput);
        }



    }
}
