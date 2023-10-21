package baseball;

import java.util.List;

public class BaseballGame {

    private static final String CORRECT_ANSWER = "03";

    private Computer computer = new Computer();
    private User user = new User();
    private AnswerChecker answerChecker = new AnswerChecker();

    private List<Integer> computerAnswer;
    private List<Integer> myAnswer;
    private String gameResult;
    private boolean playing = true;

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerAnswer = computer.makeAnswer();
        while(playing) {
            System.out.print("숫자를 입력해주세요 : ");
            myAnswer = user.guessAnswer();
            gameResult = answerChecker.checkAnswer(computerAnswer, myAnswer);
            answerChecker.printResult(gameResult);
            ifSuccess(gameResult, user, computer);
        }
    }

    public void ifSuccess(String gameResult, User user, Computer computer){
        if(gameResult==CORRECT_ANSWER) {
            playing = user.restartOrQuit();
            makeNewAnswerIfRestart(playing, computer);
        }
    }

    private void makeNewAnswerIfRestart(boolean playing, Computer computer) {
        if(playing==true)
            computerAnswer = computer.makeAnswer();
    }
}