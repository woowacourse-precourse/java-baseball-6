package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            NumberBaseBallGame game = new NumberBaseBallGame();
            game.ComputerNumber();
            //game.displayComputerNumbers(); // 코드를 원활하게 작성하기 위해서 컴퓨터가 생각하는 수를 보기 위한 코드
            while (true) {
                String input = GameConsole.UserInput();

                if (input.length() != 3) {
                    throw new IllegalArgumentException("3자리수를 입력하세요");
                }

                List<Integer> digits = new ArrayList<>();
                for (char a : input.toCharArray()) {
                    if (!Character.isDigit(a)) {
                        throw new NumberFormatException("숫자를 입력하세요");
                    }
                    int digitValue = Character.getNumericValue(a);
                    digits.add(digitValue);
                }

                String result = game.guessNumber(digits);
                GameConsole.displayMessage(result);

                if (result.equals("3스트라이크")) {
                    GameConsole.displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            int end = GameConsole.RestartOrExitChoice();

            if (end == 1) {
                GameConsole.displayMessage("게임을 다시 시작합니다.");
            } else if (end == 2) {
                GameConsole.displayMessage("게임을 종료합니다.");
                return;
            } else if (!(end == 1 || end == 2)) {
                throw new IllegalArgumentException("1,2제외한 숫자로 종료");
            }
        }
    }
}
