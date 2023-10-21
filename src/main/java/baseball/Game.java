package baseball;

import java.util.List;

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
        List<Integer> gameNumber = gameNumberMaker.generateAndSetGameNumber();
        System.out.println(gameNumber);
    }

    public void playGame() {
        // while
        // 정답 입력 객체
        List<Integer> answerNumber = answerInput.inputNumber();
        System.out.println(answerNumber);
        // 채점 객체
        // 힌트 생성 객체
        // 3 스트라이크 시 게임 종료
    }
}
