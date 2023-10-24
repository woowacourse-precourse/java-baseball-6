package baseball.controller;

import baseball.model.GameStatus;
import baseball.model.PlayerInputManager;
import baseball.model.CompareNumber;
import baseball.model.MakeRandomNumber;
import baseball.view.InputView;
import baseball.view.OutView;

import java.util.ArrayList;

public class BaseballController {

    private boolean restart = false;

    private boolean GameSet = false;
    private CompareNumber CompareNumber;
    private final MakeRandomNumber MakeNumber;
    private ArrayList<String> computerNumber;

    public BaseballController() {
        MakeNumber = new MakeRandomNumber();
        computerNumber = MakeNumber.MakeRandomNumber();
    }

    public void PlayGame() {
        // 사용자 입력 받기
        String playerNumber = new PlayerInputManager(InputView.InputNumberMessage(), GameStatus.PLAYING).getPlayerInput();

        // 입력받은 숫자 비교
        CompareNumber = new CompareNumber(playerNumber, computerNumber);

        // 비교 결과 출력
        OutView.printBallCount(CompareNumber.getStrike(), CompareNumber.getBall());

        // 3 스트라이크인지 확인
        GameSet = CompareNumber.IsThreeStrike(CompareNumber.getStrike());

        RestartGame(GameSet);
    }

    public void RestartGame(boolean GameSet) {
        if(GameSet){
            String answer = new PlayerInputManager(InputView.RestartAskMessage(), GameStatus.RESTART).getPlayerInput();
            if(answer.equals("1")) {
                restart = true;
                computerNumber = MakeNumber.MakeRandomNumber();
            } else {
                restart = false;
            }
        } else {
            restart = true;
        }
    }

    public boolean IsRestart() {
        return restart;
    }
}
