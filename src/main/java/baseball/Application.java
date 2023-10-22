package baseball;

import baseball.core.code.Message;
import baseball.core.print.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 1. 시작 메시지 출력
        MessagePrinter.print(Message.START);

        // 2. 숫자 3자리 추출
        List<Integer> computerNumbers = getComputerNumbers();

        // 3. 사용자 숫지 입력 기능 및 유효성 체크
        String input = Console.readLine();
        validInput(input);

    }

    /**
     * 사용자 입력 값 유효성 체크
     * @param input
     */
    private static void validInput(String input) {
        // 입력 값 유효성 체크
        if (input.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력 해야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리로 입력 해야 합니다.");
        }

        long distinctRemoveStringCount = Arrays.asList(input.split("")).stream().distinct().count();
        if (distinctRemoveStringCount != input.length()) {
            throw new IllegalArgumentException("숫자는 중복 될 수 없습니다.");
        }
    }

    /**
     * 게임용 숫자 3자리 추출
     * @return List<Integer> 컴퓨터 숫자 리스트
     */
    private static List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
