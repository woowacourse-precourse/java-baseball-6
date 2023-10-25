package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // 플레이어가 입력한 숫자를 담을 리스트 선언
    private List<Integer> playerBall = new ArrayList<>();

    // 예외 처리가 안되면 플레이어 숫자 생성
    public Player(String inputValue) throws IllegalArgumentException {
        isNumNotNull(inputValue);
        isNumContainsOnlyDigits(inputValue);
        // 입력받은 플레이어 숫자에 숫자만 있고 null도 아니라면 int로 파싱
        int inputValueToInt = Integer.parseInt(inputValue);
        initPlayerBall(inputValueToInt);
    }

    // 플레이어 숫자를 초기화
    public void initPlayerBall(int inputValue) throws IllegalArgumentException {
        isNumThreeDigits(inputValue);
        divideNumIntoEachDigit(inputValue);
    }

    // 3자리 수를 입력했는지 판별
    private static void isNumThreeDigits(int inputValue) {
        if ((inputValue / 100) < 1 || (inputValue / 100) > 9) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 숫자를 각 자리수마다 나눠서 리스트에 저장
    private void divideNumIntoEachDigit(int inputValue) {
        while (inputValue != 0) {
            int value = inputValue % 10;
            isNumDuplicate(value);
            isNumContainsZero(value);
            this.playerBall.add(0, value);
            inputValue /= 10;
        }
    }

    // 숫자가 중복되는지 확인
    public void isNumDuplicate(int value) {
        if (this.playerBall.contains(value)) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자가 0을 포함하고 있는지 확인
    public void isNumContainsZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException();
        }
    }

    // 아무것도 입력되지 않았는지 확인
    public void isNumNotNull(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값에 숫자만 있는지 확인
    public void isNumContainsOnlyDigits(String inputValue) {
        if (!inputValue.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getPlayerBall() {
        return this.playerBall;
    }
}
