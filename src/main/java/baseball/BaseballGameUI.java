package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseballGameUI {
    Boolean button = true;

    public void setButton(Boolean button) {
        this.button = button;
    }

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputPlayerNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int ballCount, int strikeCount) {
        countHasOnlyStrike(ballCount, strikeCount);
        countHasThreeStrike(strikeCount);
        countHasOnlyBall(ballCount, strikeCount);
        countHasBoth(ballCount, strikeCount);
        countHasNothing(ballCount, strikeCount);
    }

    private static void countHasNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    private static void countHasBoth(int ballCount, int strikeCount) {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    private void countHasThreeStrike(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restartGame();
        }
    }

    private static void countHasOnlyStrike(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    private static void countHasOnlyBall(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
    }

    public void isOneOrTwo(int inputValueToInt) {
        if (inputValueToInt != 2 && inputValueToInt != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void restartGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = readLine();
        int inputValueToInt = Integer.parseInt(inputValue);
        isOneOrTwo(inputValueToInt);

        if (inputValueToInt == 2) {
            setButton(false);
        }
        if (inputValueToInt == 1) {
            startGame();
        }
    }

    public void startGame() throws IllegalArgumentException {
        Computer computer = new Computer();
        // System.out.println(computer.getComputerBall());

        while (button) {
            inputPlayerNum();
            String inputValue = readLine();
            Player player = new Player(inputValue);
            CalculateResult calculateResult = new CalculateResult(computer.getComputerBall(), player.getPlayerBall());
            printResult(calculateResult.getBallCount(), calculateResult.getStrikeCount());
        }

    }

}
