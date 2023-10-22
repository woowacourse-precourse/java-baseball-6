package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerNumber {
    private List<Integer> playerNumber;

    public PlayerNumber() {
        // 플레이어로부터 입력받은 값을 플레이어넘버로 설정한다.
        this.playerNumber = getInputNumber();
    }

    // Counter 클래스에서 사용하므로 public으로 설정한다.
    public List<Integer> getPlayerNumber() {
        return this.playerNumber;
    }

    private List<Integer> getInputNumber() {
        playerNumber = new ArrayList<>();
        String inputNumber = Console.readLine();

        // 자릿수가 3인지 확인
        validateSize(inputNumber);

        // 문자열에서 숫자로 정상 변경이 되는지 확인
        validateFormat(playerNumber, inputNumber);

        //  중복 제거 후 자릿수가 3인지 확인
        validateDuplication(playerNumber);

        return playerNumber;
    }

    private void validateSize(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private void validateFormat(List<Integer> playerNumber, String inputNumber) {
        try {
            IntStream.range(0, 3).mapToObj(i -> Integer.parseInt(String.valueOf(inputNumber.charAt(i))))
                    .forEach(playerNumber::add);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private void validateDuplication(List<Integer> playerNumber) {
        if (playerNumber.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 개의 서로 다른 숫자를 입력하세요.");
        }
    }
}
