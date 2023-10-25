package baseball;

import baseball.domain.Computer;
import baseball.domain.GameController;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import baseball.domain.User;
import static baseball.domain.GameController.NUMBER_LENGTH;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        GameController gameController = new GameController();
        int exit = 1;
        while (exit == 1) { // 외부 while문 시작
            gameController.printGameStartNotice();
            // 1부터 9까지 서로 다른 세 자리의 수 생성 (컴퓨터)
            ArrayList<Integer> computerNumArray = computer.generateComputerNum(NUMBER_LENGTH);

            int strike, ball;
            strike = gameController.setValueZero();

            while (strike < NUMBER_LENGTH) { // 내부 while문 시작
                ArrayList<Integer> userNumArray = user.inputUserGuess(NUMBER_LENGTH);

                // 같은 수가 같은 자리에 있으면 스트라이크++, 값 0으로 바꾸기. 같은 수가 다른 자리에 있으면 볼++, 스트링 추가. 둘 다 0이면 낫싱.
                strike = gameController.setValueZero();
                ball = gameController.setValueZero();

                strike = gameController.checkForStrike(userNumArray, computerNumArray, strike);
                ball = gameController.checkForBall(userNumArray, computerNumArray, ball);

                String output = "";
                output = gameController.addBallToOutput(output, ball);
                output = gameController.addStrikeToOutput(output, strike, ball);
                output = gameController.addNothingToOutput(output, strike, ball);

                gameController.printOutput(output);
            } // 내부 while문 끝
            // 3개의 숫자를 모두 맞히면 종료, 다시 시작하거나 완전히 종료
            gameController.printGameSuccess();
            gameController.printNewGameNotice();
            exit = gameController.inputIsNewGame();
        } // 외부 while문 끝
    }
}
