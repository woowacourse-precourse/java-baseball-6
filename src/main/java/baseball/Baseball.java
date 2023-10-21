package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {
    public ArrayList<Integer> computerNumber;
    public ArrayList<Integer> userNumber;
    int ball;
    int strike;
    Baseball() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void resetComputerNumber() {
        computerNumber = new ArrayList<Integer>();
        while(computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber))
                computerNumber.add(randomNumber);
        }
    }

    public void resetUserNumber(String inputNumber) throws InputNumberException {
        userNumber = new ArrayList<Integer>();
        String[] inputNumberArray = inputNumber.split("");
        for(String s : inputNumberArray) {
            int addNumber = Integer.valueOf(s).intValue();
            // 입력 예외 처리
            if(userNumber.contains(addNumber) || userNumber.size() + 1 > 3) {
                throw new InputNumberException();
            }
            userNumber.add(addNumber);
        }
    }

    public void checkStrike() {
        for(int i = 0; i < computerNumber.size(); i++) {
            if(computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else {
                checkBall(userNumber.get(i));
            }
        }
        printResult();
    }

    void checkBall(int i) {
        if(computerNumber.contains(i)) {
            ball++;
        }
    }

    void printResult() {
        if(strike == 0 || ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0) System.out.println(strike + "스트라이크 ");
        if (ball > 0) System.out.println(ball + "볼 ");
        if (strike > 3) System.out.println("3개의 숫자를 모두 맞추셨습니다!");
    }
}
