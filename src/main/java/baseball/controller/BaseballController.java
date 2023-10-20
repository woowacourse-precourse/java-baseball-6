package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.util.NumGenerator;
import baseball.model.BaseballService;
import baseball.model.Player;
import baseball.model.Computer;

public class BaseballController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumGenerator numGenerator = new NumGenerator();
    BaseballService baseballService = new BaseballService();

    public void game(){
        Computer computer = new Computer(numGenerator.computerNumGenerator());
        outputView.printGameStartMessage();
        boolean flag = false;
        while(!flag) {
            outputView.printInputMessage();
            Player player = new Player(numGenerator.playerNumGenerator());
            int strikeCount = baseballService.manageStrike(computer,player);
            int ballCount = baseballService.manageBall(computer, player);
            flag = player.getFlag();
            outputView.printRoundResultMessage(strikeCount, ballCount);
        }
        outputView.printGameEndMessage();
        outputView.printGameRestartMessage();
        String regameOrEnd = inputView.readRegameOrEnd();
        if(regameOrEnd.equals("1")){
            game();
        }
    }
}
