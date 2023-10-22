package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.dto.CountResultDto;
import baseball.service.CountService;
import baseball.view.ErrorMessage;
import baseball.view.GameCommand;
import baseball.view.GameValue;
import baseball.view.InputView;
import baseball.view.GameMessage;
import baseball.view.OutputView;

public class BaseBallController {

    public void startGame() {
        System.out.println(GameMessage.START_GAME.getMessage());
        Computer computer = new Computer();
        runGame(computer);
    }

    public boolean restartGame() {
        System.out.println(GameMessage.ASK_RETRY.getMessage());
        String command = InputView.inputRetryCommand();
        if (command.equals(GameCommand.RESTART.getString())) {
            return true;
        }
        if (command.equals(GameCommand.END.getString())) {
            System.out.println(GameMessage.END_GAME.getMessage());
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.RESTART_COMMAND.getMessage());
    }

    private void runGame(Computer computer) {
        boolean gameStatus = true;
        while (gameStatus) {
            System.out.print(GameMessage.INPUT_NUMBER.getMessage());
            String input = InputView.inputPlayerNumber();
            Player player = new Player(input);
            CountResultDto countResultDto = CountService.calculateCount(computer.getNumbers(),
                    player.getNumbers());
            System.out.println(OutputView.printResult(countResultDto));
            gameStatus = isWinGame(countResultDto.getStrikeCount());
        }
    }

    private boolean isWinGame(int strikeCount) {
        if (strikeCount == GameValue.THREE_STRIKE.getValue()) {
            System.out.println(GameMessage.SUCCESS.getMessage());
            return false;
        }
        return true;
    }
}
