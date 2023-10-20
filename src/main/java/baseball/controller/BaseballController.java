package baseball.controller;

import baseball.service.BallStrikeCheckService;
import baseball.view.InputView;
import baseball.service.ComNumberGenerateService;
import baseball.service.UserNumberGenerateService;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class BaseballController {

    private final ComNumberGenerateService comNumberGenerateService = new ComNumberGenerateService();
    private final UserNumberGenerateService userNumberGenerateService = new UserNumberGenerateService();
    private final BallStrikeCheckService ballStrikeCheckService = new BallStrikeCheckService();
    private int BALL;
    private int STRIKE;


    public void run() {
        do {
            start();

        } while (!isEnd());
    }

    private void start() {
        List<Integer> comNumber = comNumberGenerateService.generateComNumber();
        System.out.println(comNumber);
        do {
            String input = InputView.requestUserNumber();
            int[] userNumber = userNumberGenerateService.generateUserNumber(input);
            Map<String, Integer> resultGame = ballStrikeCheckService.resultBallStrike(userNumber, comNumber);
            BALL = resultGame.get("BALL");
            STRIKE = resultGame.get("STRIKE");
            resultGame();

        } while (STRIKE != 3);


    }

    private void resultGame() {
        if (BALL != 0 && STRIKE == 0) {
            OutputView.onlyBall(BALL);
        }
        if (BALL == 0 && STRIKE != 0) {
            OutputView.onlyStrike(STRIKE);
        }
        if (BALL != 0 && STRIKE != 0) {
            OutputView.ballAndStrike(BALL, STRIKE);
        }
        if (BALL == 0 && STRIKE == 0) {
            OutputView.nothing();
        }
    }

    private boolean isEnd() {
        OutputView.endGame();
        String result = InputView.requestRestartGame();
        if (result.equals("1")) return false;
        if (result.equals("2")) return true;
        throw new IllegalArgumentException();
    }

}
