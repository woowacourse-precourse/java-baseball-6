package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Computer {

    public final int DIGIT = 3;
    List<Integer> computer;

    Computer() {
        setRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void setRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean getResult(int playerNum) {

        int strike = 0;
        int ball = 0;
        for (int i = computer.size() - 1; i >= 0; i--) {

            //strike - 같은 자리 같은 숫자
            if (computer.get(i) == playerNum % 10)
                strike++;
            //ball - 다른 자리 같은 숫자
            if (computer.get(i) != playerNum % 10 && computer.contains(playerNum % 10))
                ball++;
            playerNum /= 10;
        }

        printResult(strike, ball);
        return strike == DIGIT;
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println(" ");
    }

    public boolean reset() {
        setRandomNumber();
        return true;
    }
}