package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.CompareAnswerWithPlayerNumber;
import baseball.view.InputView;
import baseball.view.ResultView;

public class GameController {
    private Computer computer = new Computer();
    private Player player = new Player();
    private InputView inputView = new InputView();
    private CompareAnswerWithPlayerNumber compareAnswerWithPlayerNumber = new CompareAnswerWithPlayerNumber();
    private ResultView resultView = new ResultView();

    public void startGame() {
        computer.setComputerAnswer();  //게임 정답 세팅
        player.setPlayerAnswer(inputView.inputPlayerNumbers());//플레이어의 정답 작성
        compareAnswerWithPlayerNumber.compareStrikeBall(player.getPlayerAnswer(),
                computer.getComputerAnswer());//플레이어 정답, 게임정답 비교
        resultView.outputCompareResult(compareAnswerWithPlayerNumber);//게임 결과 확인

    }


}
