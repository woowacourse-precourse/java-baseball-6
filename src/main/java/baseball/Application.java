package baseball;

import baseball.core.code.Message;
import baseball.core.print.MessagePrinter;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 1. 시작 메시지 출력
        MessagePrinter.print(Message.START);

        // 2. 숫자 3자리 추출
        List<Integer> computerNumbers = getComputerNumbers();
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
