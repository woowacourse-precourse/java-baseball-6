package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerBall = new ArrayList<>();

    public Player(String inputValue) throws IllegalArgumentException {
        isNumNotNull(inputValue);
        isNumContainsOnlyDigits(inputValue);
        // 입력받은 플레이어 숫자에 숫자만 있고 null도 아니라면 int로 파싱
        int inputValueToInt = Integer.parseInt(inputValue);
        initPlayerBall(inputValueToInt);
    }

    public void initPlayerBall(int inputValue) throws IllegalArgumentException {
        isNumThreeDigits(inputValue);
        divideNumIntoEachDigit(inputValue);
    }

    private static void isNumThreeDigits(int inputValue) {
        if ((inputValue / 100) < 1 || (inputValue / 100) > 9) {
            throw new IllegalArgumentException();
        }
    }

    private void divideNumIntoEachDigit(int inputValue) {
        while (inputValue != 0) {
            int value = inputValue % 10;
            isNumDuplicate(value);
            isNumContainsZero(value);
            this.playerBall.add(0, value);
            inputValue /= 10;
        }
    }

    public void isNumDuplicate(int value) {
        if (this.playerBall.contains(value)) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumContainsZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumNotNull(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumContainsOnlyDigits(String inputValue) {
        if (!inputValue.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getPlayerBall() {
        return this.playerBall;
    }
}
