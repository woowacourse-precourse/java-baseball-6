package baseball.game;

import baseball.Exception.NumberDuplicateException;
import baseball.Exception.QueryMustPossibleIntegerException;
import baseball.Exception.SizeNotMatchException;
import baseball.game.vo.BallCount;
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
        this.status = 0;
        this.gameView = gameView;
        this.numberGengerator = numberGengerator;
    }

    public void initGame() {
        this.answer = numberGengerator.numberGenerate();
    }

    public void run() {
        gameView.startBoot();
        initGame();

        while (isPlay()) {
            gameView.inputMessage();
            List<Integer> query = playerQuery();
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
        String inputStatus = Console.readLine();
        validateRestart(inputStatus);
    }

    private void validateRestart(String inputStatus) {
        Validation.checkRestartString(inputStatus);
        this.status = inputStatus.charAt(0) - '0';
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
            if (!isNothing(answer, query.get(i))) {
                ballCount.putBall();
            }
        }
        return ballCount;
    }

    private boolean isStrike(Integer answerElement, Integer queryElement) {
        return answerElement == queryElement;
    }

    private boolean isNothing(List<Integer> answer, Integer queryElement) {
        return !answer.contains(queryElement);
    }

    private List<Integer> playerQuery() {
        String query = Console.readLine();
        if (query.length() != 3) {
            throw new SizeNotMatchException();
        }
        if (!Validation.allPossibleDigit(query)) {
            throw new QueryMustPossibleIntegerException();
        }
        return queryToList(query);
    }

    public List<Integer> queryToList(String query) {
        List<Integer> generateNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int queryElement = query.charAt(i) - '0';
            findDuplicatedNumber(generateNumber, queryElement);
        }
        return generateNumber;
    }

    private void findDuplicatedNumber(List<Integer> generateNumber, int queryElement) {
        if (generateNumber.contains(queryElement)) {
            throw new NumberDuplicateException();
        }
        generateNumber.add(queryElement);
    }

    private boolean isPlay() {
        return this.status != 2;
    }
}
