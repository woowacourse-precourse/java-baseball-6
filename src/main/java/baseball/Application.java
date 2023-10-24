package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Computer computer = new Computer();
        User user = new User();
        Hint hint = new Hint();

        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            List<Integer> randomNumbers = computer.selectNumber();

            hint.reset();

            while (true) {

                List<Integer> userNumbers = user.userInput();

                hint.compareNumber(randomNumbers, userNumbers);

                if (hint.isThreeStrike()) {

                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int input = Integer.parseInt(Console.readLine());

                    if (input == 1) {

                        break;

                    } else if (input == 2) {

                        return;

                    }
                }
            }
        }
    }
}
