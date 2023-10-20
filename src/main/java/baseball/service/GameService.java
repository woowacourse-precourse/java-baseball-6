package baseball.service;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public boolean GameProcess(List<Integer> computer) {
        int strike = 0;
        while(strike != 3) {
            outputView.InputNumber(); // 숫자 입력 메시지 출력
            strike = GameResult(computer);
        }

        outputView.EndGame(); // 게임 종료 메시지 출력
        return inputView.FinishGame();
    }

    private int GameResult(List<Integer> computer) {
        int idx=0, strike=0, ball=0;

        for(int i : inputView.PlayerNumberInput()) {
            if(computer.contains(i)) {
                if(computer.indexOf(i) == idx) {
                    strike++;
                }
                else {
                    ball++;
                }
            }
            idx++;
        }

        outputView.GameResult(ball, strike);

        return strike;
    }
}
