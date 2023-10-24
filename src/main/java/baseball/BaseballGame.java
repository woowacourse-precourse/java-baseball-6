package baseball;

import java.util.ArrayList;

public class BaseballGame {
    private int strikeCount = 0;
    private int ballCount = 0;

    public boolean restartGame = true;

    public void setStrikeCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        ArrayList<Integer> computerList = computerNumber.getNumbers();
        ArrayList<Integer> userList = userNumber.getNumbers();

        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerList.get(i) == userList.get(i))
                strikeCount++;
        }
    }

    public void setBallCount(BaseballNumber computerNumber, BaseballNumber userNumber) {
        ArrayList<Integer> computerList = computerNumber.getNumbers();
        ArrayList<Integer> userList = userNumber.getNumbers();
        int digitComputerNumber;

        ballCount = 0;
        digitComputerNumber = computerList.get(0);
        for (int i = 0; i < 3; i++) {
            if (digitComputerNumber == userList.get(i)) {
                ballCount++;
                break;
            }
        }
        digitComputerNumber = computerList.get(1);
        for (int i = 0; i < 3; i++) {
            if (digitComputerNumber == userList.get(i)) {
                ballCount++;
                break;
            }
        }
        digitComputerNumber = computerList.get(2);
        for (int i = 0; i < 3; i++) {
            if (digitComputerNumber == userList.get(i)) {
                ballCount++;
                break;
            }
        }

        ballCount -= strikeCount;
    }

    public void printHint() {
        if (strikeCount == 0 && ballCount == 0)
            System.out.println("낫싱");
        if (strikeCount == 0 && ballCount > 0)
            System.out.println(ballCount + "볼");
        if (strikeCount > 0 && ballCount <= 0)
            System.out.println(strikeCount + "스트라이크");
        if (strikeCount > 0 && ballCount > 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public void startGame() {
        BaseballNumber ComputerNumber = new BaseballNumber();
        BaseballNumber UserNumber = new BaseballNumber();
        UserInput user = new UserInput();

        System.out.println("숫자 야구 게임을 시작합니다.");
        ComputerNumber.setComputerNumbers();

        while (true) {
            UserNumber.setUserNumbers(user.getUserNumber());
            setStrikeCount(ComputerNumber, UserNumber);
            setBallCount(ComputerNumber, UserNumber);
            printHint();

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        if (!user.isRestart())
            restartGame = false;
    }
}