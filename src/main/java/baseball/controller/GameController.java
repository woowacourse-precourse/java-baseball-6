package baseball.controller;

import baseball.model.GameRound;
import baseball.model.GeneratorNumber;
import baseball.model.Restart;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private static final int RESTART = 1;

    private static final String THREE_STRIKE = "3스트라이크";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public void playGame() {
        OutputView.gameStart();

        while (true) {
            // 1회 게임 시작
            gameRound();
            // 재시작/종료 선택
            if (askRestart() != RESTART) {
                break;
            }
        }
    }

    private static int askRestart() {
        OutputView.restartDecision();
        String userInput = InputView.getUserInput();
        Restart restart = Restart.restartFactory(userInput);
        return restart.getDecision();
    }

    public void gameRound() {
        // 랜덤 숫자 생성
        List<Integer> computerNumber = GeneratorNumber.generateComputerNumber();
        while (true) {
            OutputView.scanNumber();
            List<Integer> userNumber = getUserInput();

            GameRound gameRound = GameRound.gameProcessFactory(computerNumber, userNumber);
            String result = gameRound.choose();
            System.out.println(result);

            if (result.equals(THREE_STRIKE)) {
                System.out.println(GAME_OVER);
                break; // 3스트라이크시 내부 루프(라운드) 종료
            }
        }
    }

    private static List<Integer> getUserInput() {
        String userInput = InputView.getUserInput();
        // 사용자 숫자 생성
        return GeneratorNumber.generateUserNumber(userInput);
    }
}
