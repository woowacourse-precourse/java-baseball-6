package baseball.user;

import baseball.status.SystemStatus;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Player {

    List<Integer> baseballNumbers;
    SystemStatus systemStatus = SystemStatus.NEW_GAME;

    public void inputBaseballNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBaseballNumber = Console.readLine();
        validateInputNumber(inputBaseballNumber);
        baseballNumbers = Arrays.stream(inputBaseballNumber.split(""))
                .map(Integer::valueOf)
                .toList();
    }

    private void validateInputNumber(String inputBaseballNumber) {
        if (inputBaseballNumber == null || inputBaseballNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : inputBaseballNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    public void chooseNewGameOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        systemStatus = SystemStatus.of(Console.readLine());
    }


    public boolean isNewGame() {
        return SystemStatus.NEW_GAME == systemStatus;
    }
}
