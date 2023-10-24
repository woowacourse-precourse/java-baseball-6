package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameManager {
    private final int computerNumberCount;

    public BaseballGameManager(int computerNumberCount) {
        this.computerNumberCount = computerNumberCount;
    }

    public void startGame() {
        BaseBallConsole.print("숫자 야구 게임을 시작합니다.\n");

        boolean isExistNextGame = true;
        while (isExistNextGame) {
            int computerNumber = Util.getNonOverlappingNumber(computerNumberCount);
            BaseballGame baseballGame = new BaseballGame(computerNumber, computerNumberCount);
            isExistNextGame = startOneGame(baseballGame);
        }
    }

    private boolean startOneGame(BaseballGame baseballGame) {
        boolean playGame = true;
        while (playGame) {
            String inputString = BaseBallConsole.readLine("숫자를 입력해주세요 : ");

            if (!Util.validateInputNumber(inputString, computerNumberCount)) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            int inputNumber = Integer.parseInt(inputString);

            BaseballGameResult baseballGameResult = baseballGame.play(inputNumber);

            BaseBallConsole.print(baseballGameResult + "\n");
            playGame = !baseballGameResult.isWin(computerNumberCount);
        }
        BaseBallConsole.print(computerNumberCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        BaseBallConsole.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String nextGameInputString = Console.readLine();

        return hasNextGame(nextGameInputString);
    }

    private boolean hasNextGame(String nextGameInputString) {
        if (nextGameInputString.equals("1")) {
            return true;
        }
        if (nextGameInputString.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("올바른 입력이 아닙니다.");
    }
}
