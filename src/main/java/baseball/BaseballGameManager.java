package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameManager {
    private final int computerNumberCount;

    public BaseballGameManager(int computerNumberCount) {
        this.computerNumberCount = computerNumberCount;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

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
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            if (!Util.validateInputNumber(inputString, computerNumberCount)) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            int inputNumber = Integer.parseInt(inputString);
            
            BaseballGameResult baseballGameResult = baseballGame.play(inputNumber);

            System.out.println(baseballGameResult);
            playGame = !baseballGameResult.isWin(computerNumberCount);
        }
        System.out.println(computerNumberCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String nextGameInputString = Console.readLine();

        return hasNextGame(nextGameInputString);
    }

    private boolean hasNextGame(String nextGameInputString) {
        if (nextGameInputString.equals("1")) {
            return true;
        } else if (nextGameInputString.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1, 2이 아닌 다른 입력입니다.");
        }
    }
}
