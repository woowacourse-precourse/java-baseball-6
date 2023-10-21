package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameRunner {
    private Computer computer;

    public BaseBallGameRunner() {
        this.computer = new Computer();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String inputString = getPlayerInput();
        List<Integer> guessNumber = new ArrayList<>();

        validateInputAndAddToList(inputString, guessNumber);
    }

    private String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private void validateInputAndAddToList(String inputString, List<Integer> guessNumber) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            if (c >= '1' && c <= '9') {
                guessNumber.add(c - '0');
                continue;
            }
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
