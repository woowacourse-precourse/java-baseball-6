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
            BaseballGame baseballGame = new BaseballGame(computerNumber);
            isExistNextGame = startOneGame(baseballGame);
        }
    }

    private boolean startOneGame(BaseballGame baseballGame) {
        boolean playGame = true;
        while (playGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = Console.readLine();

            int inputNumber = validateInputNumber(inputString, computerNumberCount);
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

    private int validateInputNumber(String inputString, int numberCount) {
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e1) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

        int maxNumber = 0;
        int minNumber = (int) Math.pow(10, numberCount - 1);
        for (int i = 0; i < numberCount; i++) {
            maxNumber += 9 * Math.pow(10, i);
        }
        if (inputNumber > maxNumber || inputNumber < minNumber) {
            throw new IllegalArgumentException(numberCount + "자리의 숫자가 아닙니다.");
        }

        int[] splitNumberArray = Util.splitAndGetIntArray(inputNumber);
        for (int number : splitNumberArray) {
            if (number == 0) {
                throw new IllegalArgumentException("1~9 숫자만 입력해주세요.");
            }
        }

        boolean[] duplicateVerificationArray = new boolean[10];
        for (int number : splitNumberArray) {
            if (duplicateVerificationArray[number]) {
                throw new IllegalArgumentException("서로 다른 " + numberCount + "자리의 숫자가 아닙니다.");
            }
            duplicateVerificationArray[number] = true;
        }

        return inputNumber;
    }
}
