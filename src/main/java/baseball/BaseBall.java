package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBall {
    public void run() {
        Notification.notifyGameStart();
        ComputerNumber computerNumber = new ComputerNumber();

        while (true) {
            String inputNumber = Console.readLine();
            PlayerNumber playerNumber = new PlayerNumber(inputNumber);
            int[] strikeBallArray = Inning.getStrikeBallCount(computerNumber, playerNumber);

            if (isSuccess(strikeBallArray)) {
                Notification.notifySuccessResult();
                break;
            }
            Notification.notifyFailResult(strikeBallArray);
        }
    }

    private boolean isSuccess(int[] strikeBallArray) {
        if (strikeBallArray[0] == 3) {
            return true;
        }
        return false;
    }
}
