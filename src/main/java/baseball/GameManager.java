package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {

    private Validator validator = new Validator();
    private BaseballCreator baseballCreator = new BaseballCreator();
    private Judgement judgment = new Judgement();

    // 기능: 게임을 최초로 시작한다
    public void initialGameStart() {
        Output.printInitialGameStartMessage();
        while (true) {
            progressGame();
            if (isNoMoreGame()) break;
        }
    }

    // 기능: 게임 순서에 맞게 게임을 진행한다
    private void progressGame() {
        List<Integer> computerBalls = baseballCreator.createComputerBalls();
        while (true) {
            Output.printNumberInputMessage();
            List<Integer> playerBalls = baseballCreator.createPlayerBalls();
            String hint = judgment.getHint(computerBalls, playerBalls);
            Output.printHint(hint);
            if (isGameEnd(hint)) break;
        }
    }

    // 기능: 힌트가 3스트라이크면 게임 종료
    private boolean isGameEnd(String hint) {
        if (hint.equals("3스트라이크")) {
            Output.printGameEndMessage();
            return true;
        }
        return false;
    }

    // 기능: 게임 종료 후, 게임 재시작 여부
    private boolean isNoMoreGame() {
        Output.printRestartGameMessage();
        String restartCommand = Console.readLine();
        validator.validateRestartCommandInput(restartCommand);
        if (restartCommand.equals("2")) {
            return true;
        }
        return false;
    }
}
