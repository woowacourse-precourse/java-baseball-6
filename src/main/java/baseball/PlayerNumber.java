package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerNumber extends Number {

    public PlayerNumber() {
        // 플레이어로부터 입력받은 값을 플레이어넘버로 설정한다.
        this.number = getInputNumber();
    }

    private List<Integer> getInputNumber() {
        number = new ArrayList<>();
        int inputNumber = Parser.parseNumber();

        // 숫자의 각 자릿수를 배열에 삽입
        insertNumberToList(number, inputNumber);

        // 중복 제거 후 자릿수가 3인지 확인
        validateDuplicationAndSize(number);

        return number;
    }

    private void insertNumberToList(List<Integer> playerNumber, int inputNumber) {
        while (inputNumber > 0) {
            playerNumber.add(inputNumber % 10);
            inputNumber /= 10;
        }
        Collections.reverse(playerNumber);
    }

    private void validateDuplicationAndSize(List<Integer> playerNumber) {
        if (playerNumber.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3개의 서로 다른 숫자를 입력하세요.");
        }
    }
}
