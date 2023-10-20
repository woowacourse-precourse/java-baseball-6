package baseball;

import java.util.List;

public class GameManager {
    // TODO: 객체 직접 생성 제거하도록 리팩터링 해야함
    private Validator validator = new Validator();
    private BaseballCreator baseballCreator = new BaseballCreator(new RandomNumberGenerator());
    private Judgement judgment = new Judgement();
    private Input input = new ConsoleInput();

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
            List<Integer> playerBalls = baseballCreator.createPlayerBalls(input.readLine());
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
        String restartCommand = input.readLine();
        validator.validateRestartCommandInput(restartCommand);
        if (restartCommand.equals("2")) {
            return true;
        }
        return false;
    }
}
