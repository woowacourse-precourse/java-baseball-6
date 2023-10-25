package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.CompareAnswerWithPlayerNumber;
import baseball.view.InputView;
import baseball.view.RegameView;
import baseball.view.ResultView;

public class GameController {
    private Computer computer = new Computer();
    private Player player = new Player();
    private final InputView inputView = new InputView();
    private final CompareAnswerWithPlayerNumber compareAnswerWithPlayerNumber = new CompareAnswerWithPlayerNumber();
    private final ResultView resultView = new ResultView();
    private final RegameView regameView = new RegameView();
    private boolean regame = true;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setComputerAnswer();  //게임 정답 세팅
        while (regame) {
            player.setPlayerAnswer(inputView.inputPlayerNumbers());//플레이어의 정답 작성
            compareAnswerWithPlayerNumber.compareStrikeBall(player.getPlayerAnswer(),
                    computer.getComputerAnswer());//플레이어 정답, 게임정답 비교
            resultView.outputCompareResult(compareAnswerWithPlayerNumber); //n볼 n스트라이크 출력
            if (compareAnswerWithPlayerNumber.getStrike() == 3) {
                regame = regameView.inputRegame();
                computer.setComputerAnswer();  //게임 정답 세팅
            }
        }
    }
}
