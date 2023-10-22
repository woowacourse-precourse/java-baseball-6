package baseball.application;

import baseball.domain.CheckMachine;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;


public class BaseballGame {

    InputView inputView = new InputView();
    Player player = new Player(inputView);
    CheckMachine checkMachine = new CheckMachine();
    ResultView resultView = new ResultView();
    Referee referee = new Referee(resultView);


    private List<Integer> generatedAnswer;
    public BaseballGame(List<Integer> generatedAnswer) {
        this.generatedAnswer = generatedAnswer;
    }
    public void play() {
        // 사용자에게 답변 받기
        String[] input = inputView.inputNumber();

        // 입력받은 숫자를 리스트에 저장
        List<Integer> pickNumbers = player.storeNumber(input);

        // 정답과 사용자 답변 비교
        String result = checkMachine.checkAnswer(generatedAnswer, pickNumbers);

        // 결과 표현
        resultView.showResult(result);

        // 정답 맞는지 확인
        boolean correct = referee.isOut(result);
        if(correct) {
            player.isGameEnd();
        }


    }
}
