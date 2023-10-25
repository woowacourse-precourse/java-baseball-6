package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static List<Integer> numOfComputer;
    private static List<Integer> userInput;
    private static boolean isThreeStrike;
    private static int ball;
    private static int strike;

    private BaseballGame(){

    }

    private static void setNumOfComputer() {
        numOfComputer = new ArrayList<>();
        while (numOfComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numOfComputer.contains(randomNumber)) {
                numOfComputer.add(randomNumber);
            }
        }
    }

    public static void startGame() {
        BaseballOutput.printStart();
        setNumOfComputer();
        try {
            do {
                initGameMembers();
                BaseballInput.setUserInput();
                userInput = BaseballInput.getUserInput();
                countBallandStrike();
                printBallandStrike();

            } while (!isThreeStrike);

        } catch (IllegalArgumentException e){
            throw e;
        }

    }

    public static void countBallandStrike(){

        for (int userIndex = 0; userIndex  < 3; ++userIndex) {
            int tmpUser = userInput.get(userIndex);
            for (int comIndex = 0; comIndex < 3; comIndex++) {
                int tmpCom = numOfComputer.get(comIndex);
                if (tmpUser == tmpCom && userIndex == comIndex) {
                    strike +=1;
                    continue;
                }
                if (tmpUser == tmpCom) {
                    ball +=1;
                }
            }
        }

    }

    public static void printBallandStrike() {

        if (ball == 0 && strike == 0) {
            BaseballOutput.printNothing();
            return;
        }

        if (ball == 0 && strike != 0) {
            BaseballOutput.printStrike(strike);
            if (strike == 3) {
                BaseballOutput.printGameEnd();
                isThreeStrike = true;
                return;
            }
            return;
        }

        if (ball != 0 && strike == 0) {
            BaseballOutput.printBall(ball);
            return;
        }

        BaseballOutput.printBallAndStrike(ball,strike);

    }

    public static void initGameMembers() {
        isThreeStrike = false;
        ball = 0;
        strike = 0;
        return;
    }

    public static void run() {
        try {
            do {
                startGame();
                BaseballOutput.printRestart();
                BaseballInput.setRestartNum();
            } while (BaseballInput.getRestartNum() == 1);


        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            Console.close();
        }

    }

}
