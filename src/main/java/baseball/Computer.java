package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> randomNum;

    public Computer() {
        randomNum = new ArrayList<>();
        while (randomNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
        }
    }

    public int calculate(int[] input) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;

        for(int i = 0 ; i < randomNum.size(); i++) {
            int temp = 0;
            for(int j = 0; j < randomNum.size(); j++) {
                if (input[i] == randomNum.get(j)) {
                    if (i == j) {
                        strike++;
                        temp++;
                    }
                    else {
                        ball++;
                        temp++;
                    }
                }
            }
            if(temp == 0) {
                nothing++;
            }
        }

        int result = validate(strike, ball, nothing);

        if(result == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int validate(int strike, int ball, int nothing) {
        if(nothing == 3) {
            System.out.println("낫싱");
        }
        else if(strike > 0 || ball > 0) {

            if(strike == 3) {
                return 1;
            }

            else if(strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            }

            else if(ball > 0 && strike == 0) {
                System.out.println(ball + "볼");
            }

            else {
                System.out.println(ball + "볼" + strike + "스트라이크");
            }
        }
        else {
            System.out.println("예외");
        }
        return 0;
    }

}
