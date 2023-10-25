package baseball.game;

import baseball.game.dto.BallCount;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final NumberGengerator numberGengerator;
    private final GameView gameView;
    private List<Integer> answer;
    private int status;

    public Game(NumberGengerator numberGengerator, GameView gameView) {
        this.status = 1;
        this.gameView = gameView;
        this.numberGengerator = numberGengerator;
    }

    public void initGame() {
        this.answer = numberGengerator.numberGenerate();
        this.status = 0;
    }

    public void run() {
        gameView.startBoot();

        while (isPlay()) {
            gameView.inputMessage();
            List<Integer> query = inputPlayerQuery();
            BallCount ballCount = determineQuery(answer, query);
            hitterResult(ballCount);
        }
    }

    private void hitterResult(BallCount ballCount) {
        int strike = ballCount.getStrike();
        int ball = ballCount.getBall();

        if (strike == 3) {
            gameSet();
        } else if (strike > 0 && ball > 0) {
            gameView.strikeBallView(strike, ball);
        } else if (strike > 0) {
            gameView.strikeView(strike);
        } else if (ball > 0) {
            gameView.ballView(ball);
        } else if (ball == 0 && strike == 0) {
            gameView.nothing();
        }
    }

    private void gameSet() {
        gameView.gameSetView();
        String inputStatusString = Console.readLine();
        int inputState = stateStringToInt(inputStatusString);
        this.status = inputState;
    }

    private int stateStringToInt(String inputStatusString) {
        Validation.checkRestartString(inputStatusString);
        return inputStatusString.charAt(0) - '0';
    }

    private BallCount determineQuery(List<Integer> answer, List<Integer> query) {
        BallCount ballCount = new BallCount();
        for (int i = 0; i < 3; i++) {
            if (isNothing(answer, query.get(i))) {
                continue;
            }
            if (isStrike(answer.get(i), query.get(i))) {
                ballCount.putStrike();
                continue;
            }
            ballCount.putBall();
        }
        return ballCount;
    }

    private boolean isStrike(Integer answerElement, Integer queryElement) {
        return answerElement == queryElement;
    }

    private boolean isNothing(List<Integer> answer, Integer queryElement) {
        return !answer.contains(queryElement);
    }

    private List<Integer> inputPlayerQuery() {
        String query = Console.readLine();
        Validation.querySizeCheck(query);
        Validation.allPossibleDigit(query);
        return queryToList(query);
    }

    public List<Integer> queryToList(String query) {
        List<Integer> queryList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int queryElement = query.charAt(i) - '0';
            findDuplicatedNumber(queryList, queryElement);
        }
        return queryList;
    }

    private void findDuplicatedNumber(List<Integer> generateNumber, int queryElement) {
        Validation.duplicateCheck(generateNumber, queryElement);
        generateNumber.add(queryElement);
    }

    private boolean isPlay() {
        if (this.status == 1) {
            initGame();
        }
        return this.status != 2;
    }
}
