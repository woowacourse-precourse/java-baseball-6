package baseball.Computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computer;

    public Computer() {
        createNumber();
    }

    private void createNumber() {

        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(computer.toString());
    }

    public int checkBallStrike(int num, int index) {

        int comIndex = 0;
        for(Integer computerNum : this.computer) {

            if(num == computerNum) {

                return checkIndex(index, comIndex);
            }

            comIndex++;
        }
        return 0;
    }

    public int checkIndex(int index, int comIndex) {

        if(index == comIndex) return 1;

        return 2;
    }

    public void printBallStrike(int strike, int ball) {

        if(strike == 0 && ball == 0) {

            System.out.println("낫싱");
            return;
        } else if(strike == 0) {

            System.out.println(ball + "볼");
            return;
        } else if(ball == 0) {

            System.out.println(strike + "스트라이크");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
