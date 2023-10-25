package baseball.domain;

public class GameEngine {
    private BaseBall answerBall;

    public void start() {
        GameGuideOutput.startGame();
        initAnswer();
        next();
    }

    private void initAnswer() {
        int answer = AnswerGenerator.randomAnswer();
        answerBall = BaseBall.getInstance(answer);
    }

    private void next() {
        GameGuideOutput.inputBaseBall();
        int baseBallNumber = GameInput.baseBallNumber();
        BaseBall userBaseBall = BaseBall.getInstance(baseBallNumber);
        BaseBallResult result = userBaseBall.compareWithAnswer(answerBall);
        printResult(result);
        if (!result.isPerfectStrike()) {
            next();
            return;
        }
        afterGameEnd();
    }

    private void printResult(BaseBallResult result) {
        GameResultOutput.print(result);
    }

    private void afterGameEnd() {
        GameGuideOutput.gameEnd();
        int afterGame = GameInput.afterGame();
        if (afterGame == 1) {
            initAnswer();
            next();
        }
    }
}