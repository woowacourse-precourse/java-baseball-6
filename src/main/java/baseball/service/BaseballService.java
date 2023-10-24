package baseball.service;

import baseball.dto.StrikeBallCount;
import baseball.util.ComputerBallGenerator;
import baseball.util.InputCalculator;
import baseball.util.RestartCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballService {

    public static void gameStart() {

        InputView.getStartMessage();

        do {

            gamePlay();

            // 게임 재시작 여부 파악해주기
        } while (gameEnd());

    }


    private static void gamePlay() {

        // 게임을 시작할 때 컴퓨터가 생각하는 임의의 세자리 수 만들어주기
        int[] computerBall = ComputerBallGenerator.generateComputerBall();

        StrikeBallCount strikeBallCount;

        do {
            // 유저가 선택한 번호 받아오기
            List<Integer> userInput = InputView.userInputNumber();

            // 유저와 컴퓨터의 세자리 수를 비교하기
            strikeBallCount = InputCalculator.compareComputerBallAndUserInput(computerBall, userInput);

            // 결과를 출력하고, 게임을 계속할지 판단
        } while (!OutputView.generateResultMessage(strikeBallCount));


    }

    private static boolean gameEnd() {

        // 재시작 여부 파악
        if (RestartCalculator.isRestart()) {

            return true;

        }

        return false;
    }

}
