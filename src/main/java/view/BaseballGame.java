package view;

import evaluator.BallStrikeEvaluator;
import java.util.List;
import number.ComputerNumber;
import number.ComputerNumberGenerator;
import number.PlayerNumber;

public class BaseballGame {

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    public void run() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        ComputerNumber computerNumber = computerNumberGenerator.createComputerNumber();
        List<Integer> userInputNumber = ConsoleIO.insert();
        PlayerNumber playerNumber = new PlayerNumber(userInputNumber);
        BallStrikeEvaluator ballStrikeEvaluator = new BallStrikeEvaluator();
        ballStrikeEvaluator.evaluate(computerNumber, playerNumber);
        ConsoleIO.resultPrint(ballStrikeEvaluator.getBallCount(), ballStrikeEvaluator.getStrikeCount());
    }
}
