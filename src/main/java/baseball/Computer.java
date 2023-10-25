package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {   // create random number
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public boolean check(ArrayList<Integer> input) {
        boolean correct = false;
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(input.get(i))) {
                strike++;
            } else {
                if (input.contains(answer.get(i))) {
                    ball++;
                }
            }
        }

        hint(ball, strike);

        if (strike == 3) {
            correct = true;
        }

        return correct;
    }

    public void hint(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike != 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println();
            }
        }
    }
}
