package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameManager;
import baseball.domain.Player;
import baseball.utils.ExceptionMessage;
import baseball.view.InputInformationView;
import baseball.view.OutputInformationView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private final Computer computer;
    private final Player player;
    private final GameManager gameManager;
    private final OutputInformationView outputInformationView;
    private final InputInformationView inputInformationView;

    public GameService() {
        this.computer = new Computer();
        this.player = new Player();
        this.gameManager = new GameManager();
        this.outputInformationView = new OutputInformationView();
        this.inputInformationView = new InputInformationView();
    }

    // 숫자 야구 게임을 실행하는 메서드.
    public void start() {
        String output = "";
        outputInformationView.startGuide();
        computer.randomNumber();

        while (!output.equals("3스트라이크")) {
            player.inputNumber();
            gameManager.check(computer, player);
            output = gameManager.result();
            outputInformationView.resultGuide(output);
        }

        outputInformationView.checkAnswerGuide();
        outputInformationView.gameOverGuide();
        inputInformationView.reStartGuide();
        restart();
    }

    // 게임의 재시작 여부를 확인하고 재시작/종료하는 메서드.
    private void restart() {
        String reState = Console.readLine();

        if (!reState.equals("1") && !reState.equals("2")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID.getCode());
        }

        if (reState.equals("1")) {
            start();
        }

        if (reState.equals("2")) {
            outputInformationView.gameEndGuide();
        }
    }
}