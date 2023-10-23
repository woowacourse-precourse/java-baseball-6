package baseball;

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

        System.out.println("숫자 야구 게임을 시작합니다.");
        String input;
        int answer = 1;
        while (answer != 2) {
            System.out.println("숫자를 입력해주세요 : ");
            input = readLine();
            // 유효성 확인
            CheckValidation checkValidation = new CheckValidation(input);
            checkValidation.checkNumberValidation();
            Hint hint = new Hint(computer, input);
            // 힌트 제공 또는 정답 확인
            int ifCorrect = hint.checkNumber();
            if (ifCorrect == 1) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = readLine();
                answer = checkValidation.checkAnswerValidation(input); // 1 or 2 or -1
                if (answer == 1) { // 게임 종료
                    computer = new ArrayList<>();
                    while (computer.size() < 3) {
                        int randomNumber = pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                }
            }
        }
    }
}
