package baseball;

import static baseball.Enum.END_PROGRAM;
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
                    int ifContinue = -1;
                    while (ifContinue == -1) {
                        System.out.println(NEW_GAME_OR_END);
                        input = readLine();
                        ifContinue = checkValidation.checkAnswerValidation(input);
                        if (ifContinue == 2) {
                            System.out.println(END_PROGRAM);
                            return;
                        }
                    }
                }
            } else {
                System.out.println(result);
            }
        }
    }
}
