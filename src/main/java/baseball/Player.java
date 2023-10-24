package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private List<Integer> playerInput = new ArrayList<>(3);

    public List<Integer> getPlayerInput() {
        return playerInput;
    }

    public void readPlayerInput() {
        String input = readLine();
        playerInput.clear();

        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                playerInput.add(Character.getNumericValue(ch));
            }
        }
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();

        if (input.length() > 1) {
            throw new IllegalArgumentException();
        }

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
            if (Character.getNumericValue(ch) == 1) {
                return true;
            }
            if (Character.getNumericValue(ch) == 2) {
                return false;
            }
            throw new IllegalArgumentException();
        }
        return false;
    }

}
