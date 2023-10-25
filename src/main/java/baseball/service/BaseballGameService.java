package baseball.service;

import static baseball.utils.BaseballGameUserInputUtils.isInputContainsUniqueValue;
import static baseball.utils.BaseballGameUserInputUtils.isValidInputLength;
import static baseball.utils.BaseballGameUserInputUtils.isValidInputValue;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    public static final int ANSWER_LENGTH = 3;

    public void playBaseballGame() {
        // 1. 게임 시작 => 게임 시작 시 사용자에게 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 게임을 위한 값 세팅 => 상대방 역할을 수행할 컴퓨터의 랜덤한 서로 다른 3가지 수 생성
        List<Integer> computerAnswers = createComputerValue();

        // 3. 입력 => 사용자로부터 서로 다른 3자리 수 입력받음
        String input = readUserAnswerInput();
    }

    private List<Integer> createComputerValue() {
        List<Integer> computerAnswers = new ArrayList<>();
        while (computerAnswers.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswers.contains(randomNumber)) {
                computerAnswers.add(randomNumber);
            }
        }
        return computerAnswers;
    }

    private String readUserAnswerInput() {
        System.out.print("숫자를 입력해 주세요 : ");

        String input = Console.readLine();

        if (!isValidInputLength(input)) {
            throw new IllegalArgumentException("3자리의 숫자만 입력해 주세요.");
        }
        if (!isValidInputValue(input)) {
            throw new IllegalArgumentException("1-9 사이의 숫자만 입력해 주세요.");
        }
        if (!isInputContainsUniqueValue(input)) {
            throw new IllegalArgumentException("숫자가 중복되지 않게 입력해 주세요.");
        }

        return input;
    }
}
