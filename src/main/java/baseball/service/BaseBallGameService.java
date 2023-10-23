package baseball.service;

import baseball.model.BaseBallNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGameService {
    BaseBallNumber userNum, computerNum;

    //game start
    public void gameStart() {
        printStartStatement();
        playGame();
    }


    void playGame() {
        computerNum = initComputerNum();
        userNum = initUserNum();
        System.out.println("computer num: " + computerNum.toString());
        System.out.println("user num: " + userNum.toString());
    }

    private BaseBallNumber initComputerNum() {
        int first = Randoms.pickNumberInRange(1, 9);
        int second = Randoms.pickNumberInRange(1, 9);
        int third = Randoms.pickNumberInRange(1, 9);

        return new BaseBallNumber(first, second, third);
    }

    private BaseBallNumber initUserNum() {
        String userInput = Console.readLine();
        try {
            int userInputNum = Integer.parseInt(userInput);

            if (userInputNum > 999 || userInputNum < 100) {
                throw new IllegalArgumentException();
            }

            int first = userInputNum / 100;
            int second = userInputNum / 10 % 10;
            int third = userInputNum % 10;
            return new BaseBallNumber(userInputNum / 100, userInputNum / 10 % 10, userInputNum % 10);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void printStartStatement() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    //init num
    //user input num
    //compare
    //restart
    //exit

}
