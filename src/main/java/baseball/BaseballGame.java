package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    int inputNumber;
    int randomNumber;
    int ball;
    int strike;
    boolean isContinue;
    boolean isGameEnd;

    public BaseballGame() {
        this.inputNumber = 0;
        this.randomNumber = 0;
        this.ball = 0;
        this.strike = 0;
        this.isContinue = true;
        this.isGameEnd = false;
    }

    public void startGame() {
        this.initMessage();

        while(this.isContinue && !this.isGameEnd) {
            this.makeRamdomNumbers();

            while (!this.isGameEnd) {
                this.printInputMessage();
                this.checkStrike();
                this.checkBall();
                this.printOutputMessage();
            }
            this.continueOrNot();
        }
    }

    private void initMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumString = Console.readLine();

        if(inputNumString.length() != 3){
            throw new IllegalArgumentException();
        }

        try {
            this.inputNumber = Integer.parseInt(inputNumString);
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException();
        }
    }

    private void printOutputMessage() {
        if(this.ball != 0) {
            System.out.print(this.ball + "볼 ");
        }
        if (this.strike != 0) {
            System.out.print(this.strike + "스트라이크");
        }
        if (this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        if(this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            this.isGameEnd = true;
        }
    }

    private void continueOrNot() {
        String input = Console.readLine();

        if(input.length() != 1){
            throw new IllegalArgumentException();
        }

        try {
            int restartOrEnd = Integer.parseInt(input);

            if(restartOrEnd == 1) {
                this.isContinue = true;
                this.isGameEnd = false;
            } else if (restartOrEnd == 2) {
                this.isContinue = false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException();
        }
    }

    private void makeRamdomNumbers() {
        this.randomNumber = 0;
        int[] arrNum = {0, 0, 0};
        int digit = 100;

        for (int i = 0; i < 3; i++) {
            int randomNum = makeOneRamdomNumber(arrNum, i);

            this.randomNumber += (randomNum * digit);
            digit /= 10;
        }
    }

    private int makeOneRamdomNumber(int[] arrNum, int arrIndex) {
        int randomNum = 0;

        while(true) {
            randomNum = Randoms.pickNumberInRange(1, 9);
            boolean stop = checkRandomNumberSameOrNot(arrNum, randomNum);

            if(stop){
                arrNum[arrIndex] = randomNum;
                break;
            }
        }

        return randomNum;
    }

    private boolean checkRandomNumberSameOrNot(int[] arrNum, int randomNum) {
        for (int j = 0; j < 3; j++) {
            if (arrNum[j] == randomNum) {
                return false;
            }
        }

        return true;
    }

    private void checkStrike() {
        this.strike = 0;
        int tempInputNum = this.inputNumber;
        int tempRandomNum = this.randomNumber;

        for(int i = 0; i < 3; i++) {
            if(tempInputNum % 10 == tempRandomNum % 10) {
                this.strike++;
            }

            tempInputNum /= 10;
            tempRandomNum /= 10;
        }
    }

    private void checkBall() {
        this.ball = 0;
        String tempInputNum = Integer.toString(this.inputNumber);

        for(int i = 0; i < 3; i++) {
            char currentDigit = tempInputNum.charAt(i);

            if(checkOneBallNumber(currentDigit, i)) {
                this.ball++;
            }
        }
    }
    private boolean checkOneBallNumber(char inputOneNumber, int currentInputNumberIndex) {
        String tempRandomNum = Integer.toString(this.randomNumber);

        for(int j = 0; j < 3; j++) {
            if(currentInputNumberIndex == j){
                continue;
            } else if(tempRandomNum.charAt(j) == inputOneNumber) {
                return true;
            }
        }

        return false;
    }
}
