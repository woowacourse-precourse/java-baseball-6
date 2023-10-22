package baseball;

public class Game {
    private final GameNumberMaker gameNumberMaker;
    private final AnswerInput answerInput;
    private final GameScore gameScore;
    private final Hint hint;

    public Game() {
        this.gameNumberMaker = new GameNumberMaker();
        this.answerInput = new AnswerInput();
        this.gameScore = new GameScore();
        this.hint = new Hint();
    }

    public void startGame() {
        // 게임 번호 생성
        System.out.println(Contants.START_MESSAGE);
        gameNumberMaker.generateAndSetGameNumber();
        System.out.println(gameNumberMaker.getGameNumber());
    }

    public void playGame() {
        while (true) {
            answerInput.inputNumber();
            gameScore.checkStrike(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
            gameScore.checkBall(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
            System.out.println(provideHint(gameScore.getStrikeCount(), gameScore.getBallCount()));

            if (gameScore.getStrikeCount() == 3) {
                return;
            }
        }

        // 채점 객체
        // 힌트 생성 객체
        // 3 스트라이크 시 게임 종료
    }

    public String provideHint(int strikeScore, int ballScore) {

        if (strikeScore == 0 && ballScore == 0) {
            hint.setHit(Contants.NOTHING);
            return hint.getHit();
        }

        if (strikeScore == 0) {
            hint.setHit(ballScore + Contants.BALL);
            return hint.getHit();
        }

        if (ballScore == 0) {
            hint.setHit(strikeScore + Contants.STRIKE);
            return hint.getHit();
        }

        hint.setHit(ballScore + Contants.BALL + " " + strikeScore + Contants.STRIKE);

        return hint.getHit();
    }
}
