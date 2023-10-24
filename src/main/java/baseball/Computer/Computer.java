package baseball.Computer;

// 숫자야구 게임에서 랜덤 숫자를 가지고 있는 computer class
// 랜덤 숫자 생성, 결과 계산, 결과 출력

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computer;

    private final int INPUTSIZE = 3;
    private final int STRIKECOUNT = 1;
    private final int BALLCOUNT = 2;

    public Computer() {
        createNumber();
    }

    // 랜덤한 3자리 숫자를 생성하는 method
    private void createNumber() {

        computer = new ArrayList<>();

        while (computer.size() < INPUTSIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    // Player의 숫자와 자신의 숫자를 계산하는 method
    // Player의 각 자리의 숫자 'num'과 'index'를 매개변수로 결과를 계산
    public int checkBallStrike(int num, int index) {

        int comIndex = 0;
        for (Integer computerNum : this.computer) {

            if (num == computerNum) {

                return checkIndex(index, comIndex);
            }

            comIndex++;
        }
        return 0;
    }

    // index가 동일한지 계산하는 method
    // Player의 'index' Computer의 'index'를 매개변수로 Strike인지 계산
    public int checkIndex(int index, int comIndex) {

        if (index == comIndex) {
            return STRIKECOUNT;
        }

        return BALLCOUNT;
    }

    // 계산된 결과를 출력하는 method
    // Player의 계산된 strike와 ball을 매개변수로 결과를 출력
    public void printBallStrike(int strike, int ball) {

        if (strike == 0 && ball == 0) {

            System.out.println("낫싱");
            return;
        } else if (strike == 0) {

            System.out.println(ball + "볼");
            return;
        } else if (ball == 0) {

            System.out.println(strike + "스트라이크");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
