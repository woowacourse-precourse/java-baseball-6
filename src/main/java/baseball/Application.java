package baseball;

import static baseball.Enum.GAME_START;
import static baseball.Enum.INPUT_NUMBER;
import static baseball.Enum.NEW_GAME_OR_END;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;


public class Application {
    // 랜덤으로 서로 다른 수 3개 생성
    public static List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        // 랜덤으로 숫자 생성
        List<Integer> computer = getComputer();
        CheckValidation checkValidation = new CheckValidation();
        Hint hint = new Hint();
        String input;
        int answer = 1;

        System.out.println(GAME_START.getMsg());
        while (answer != 2) {
            System.out.println(INPUT_NUMBER.getMsg());
            input = readLine();
            // 입력값 유효성 확인
            checkValidation.checkNumberValidation(input);
            // 힌트 제공 또는 정답 확인
            int ifCorrect = hint.checkNumber(computer, input);
            // 정답 맞춘 후 게임 지속 또는 종료 선택
            if (ifCorrect == 1) {
                System.out.println(NEW_GAME_OR_END.getMsg());
                input = readLine();
                // 입력값 유효성 확인, answer = 1 or 2
                answer = checkValidation.checkAnswerValidation(input);
                // 새로운 게임 시작, 새로운 랜덥 숫자 3개 생성
                if (answer == 1) {
                    computer = getComputer();
                }
            }
        }
    }
}
