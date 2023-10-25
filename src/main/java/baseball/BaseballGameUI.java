package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseballGameUI {
    private Boolean button = true;

    // 게임을 종료할 수 있는 버튼 메서드
    public void setButton(Boolean button) {
        this.button = button;
    }

    // 게임이 시작됐음을 알리는 메서드
    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 플레이어가 입력할 위치를 안내하는 메서드
    public void inputPlayerNumMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    // 판별한 볼카운트를 출력하는 메서드
    public void printResult(int ballCount, int strikeCount) {
        countHasOnlyStrike(ballCount, strikeCount);
        countHasThreeStrike(strikeCount);
        countHasOnlyBall(ballCount, strikeCount);
        countHasBoth(ballCount, strikeCount);
        countHasNothing(ballCount, strikeCount);
    }

    // 볼카운트를 판별하는 메서드 5개
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

    // 값이 1 또는 2가 아니라면 예외 발생
    public void isOneOrTwo(int inputValueToInt) {
        if (inputValueToInt != 2 && inputValueToInt != 1) {
            throw new IllegalArgumentException();
        }
    }

    // 게임을 재시작하는 메서드
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

    // 게임을 시작하는 메서드
    public void startGame() throws IllegalArgumentException {
        Computer computer = new Computer();

        while (button) {
            inputPlayerNumMessage();
            String inputValue = readLine();
            Player player = new Player(inputValue);
            CalculateResult calculateResult = new CalculateResult(computer.getComputerBall(), player.getPlayerBall());
            printResult(calculateResult.getBallCount(), calculateResult.getStrikeCount());
        }

    }

}
