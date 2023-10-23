package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private List<Integer> computer;
    private List<Integer> user;
    private int strike = 0;
    private int ball = 0;

    public void init() {
        this.computer = generateComputerNumberList();
        this.strike = 0;
        this.ball = 0;
    }

    public List<Integer> generateComputerNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int pickupNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(pickupNumber)) {
                numberList.add(pickupNumber);
            }
        }
        return numberList;
    }

    public void playGame() {
        while (!isGameEnd()) {
            System.out.print("숫자를 입력해주세요 : ");
            this.user = getInputNumberList();
            this.strike = checkStrike();
            this.ball = checkBall();
            printResult();
        }
        printEndGameMessage();
    }

    private void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isGameEnd() {
        return this.strike == 3;
    }

    private void printResult() {
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    private int checkStrike() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (this.computer.get(i) == this.user.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int checkBall() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int comNumber = this.computer.get(i);
            for (int j = 0; j < 3; j++) {
                int inputNumber = this.user.get(j);
                if (i != j && comNumber == inputNumber) {
                    count++;
                }
            }
        }
        return count;
    }

    private List<Integer> getInputNumberList() {
        String inputNumber = Console.readLine();
        List<Integer> numberList = new ArrayList<>();
        int validatedNumber = validateNumber(inputNumber);

        int count = 100;
        for (int i = 0; i < 3; i++) {
            int tmp = validatedNumber / count;
            numberList.add(tmp);
            validatedNumber %= count;
            count /= 10;
        }
        return numberList;
    }

    private Integer validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 999 || number < 100) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
