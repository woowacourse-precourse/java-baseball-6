package view;

import evaluator.BallStrikeEvaluator;
import java.util.List;
import number.ComputerNumber;
import number.ComputerNumberGenerator;
import number.PlayerNumber;

public class BaseballGame {

    private static final int GOAL_NUMBER = 3;

    private static final String RESTART_CODE = "1";

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    private void run() {
        boolean isRestart = true;

        while(isRestart) {
            isRestart = game();
        }
    }

    private boolean game() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        BallStrikeEvaluator ballStrikeEvaluator = new BallStrikeEvaluator();
        Integer ballCount;
        Integer strikeCount = 0;

        ComputerNumber computerNumber = computerNumberGenerator.createComputerNumber();

        while(strikeCount < GOAL_NUMBER) {
            List<Integer> userInputNumber = ConsoleIO.insert();
            PlayerNumber playerNumber = new PlayerNumber(userInputNumber);
            ballStrikeEvaluator.evaluate(computerNumber, playerNumber);
            ballCount = ballStrikeEvaluator.getBallCount();
            strikeCount = ballStrikeEvaluator.getStrikeCount();
            ConsoleIO.resultPrint(ballCount, strikeCount);
            ballStrikeEvaluator.clearCount();
        }

        String restartCode = ConsoleIO.restartRequest();

        if(restartCode.equals(RESTART_CODE)) {
            return true;
        }

        return false;
    }
}
