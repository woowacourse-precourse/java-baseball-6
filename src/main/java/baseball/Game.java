package baseball;

public class Game {
    private final GameNumberMaker gameNumberMaker;
    private final AnswerInput answerInput;

    public Game() {
        this.gameNumberMaker = new GameNumberMaker();
        this.answerInput = new AnswerInput();
    }

    public void startGame() {
        // 게임 번호 생성
        System.out.println(Contants.START_MESSAGE);
        gameNumberMaker.generateAndSetGameNumber();
        System.out.println(gameNumberMaker.getGameNumber());
    }

    public void playGame() {
        // while
        // 정답 입력 객체
        answerInput.inputNumber();
        System.out.println(answerInput.getAnswerNumber());
        GameScore gameScore = new GameScore();
        gameScore.checkStrike(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
        gameScore.checkBall(gameNumberMaker.getGameNumber(), answerInput.getAnswerNumber());
        System.out.println(gameScore.getStrikeCount());
        System.out.println(gameScore.getBallCount());
        // 채점 객체
        // 힌트 생성 객체
        // 3 스트라이크 시 게임 종료
    }
}
