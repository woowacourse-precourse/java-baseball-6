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
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            // 유효성 확인
            CheckValidation checkValidation = new CheckValidation(input);
            String result = checkValidation.checkNumberValidation();
            if (result.equals("유효")) {
                Hint hint = new Hint(computer, input);
                boolean ifCorrect = hint.checkNumber();
                if (ifCorrect) {
                    int ifContinue = -1;
                    while (ifContinue == -1) {
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        input = readLine();
                        ifContinue = checkValidation.checkAnswerValidation(input);
                        if (ifContinue == 2) {
                            System.out.println("프로그램이 완전히 종료되었습니다. 게임을 하고 싶으면 다시실행 해주세요.");
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
