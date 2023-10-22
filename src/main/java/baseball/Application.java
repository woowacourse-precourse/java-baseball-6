package baseball;

import static baseball.Enum.GAME_START;
import static baseball.Enum.INPUT_NUMBER;
import static baseball.Enum.NEW_GAME_OR_END;
import static baseball.Enum.VALID;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 랜덤으로 서로 다른 수 3개 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(GAME_START);
        while (true) {
            System.out.print(INPUT_NUMBER);
            String input = readLine();
            // 유효성 확인
            CheckValidation checkValidation = new CheckValidation(input);
            Enum result = checkValidation.checkNumberValidation();
            if (result.equals(VALID)) {
                Hint hint = new Hint(computer, input);
                // 힌트 제공 또는 정답 확인
                boolean ifCorrect = hint.checkNumber();
                if (ifCorrect) {
                    int answer = -1;
                    while (answer == -1) { // 유효한 값(1,2)이 나올 때까지 반복
                        System.out.println(NEW_GAME_OR_END);
                        input = readLine();
                        answer = checkValidation.checkAnswerValidation(input); // 1 or 2 or -1
                        if (answer == 2) { // 게임 종료
                            return;
                        }
                    }
                }
            } else { // 유효하지 않은 이유 출력
                System.out.println(result);
            }
        }
    }
}
