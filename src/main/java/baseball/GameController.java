package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {

    private final NumberGenerator numberGenerator;
    private final UserFunc userFunc;
    private final NumberCheck numberCheck;

    public GameController() {
        this.numberGenerator = new NumberGenerator();
        this.userFunc = new UserFunc();
        this.numberCheck = new NumberCheck();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = numberGenerator.generate();

            while (true) {
                String guess = userFunc.getInput();

                if (userFunc.isValid(guess)) {
                    String result = numberCheck.check(computerNumbers, guess);
                    System.out.println(result);

                    if ("3스트라이크".equals(result)) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid input!");
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                break;
            }
        }
    }
}