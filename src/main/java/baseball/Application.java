package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> uniqueRandomNumber =
                    UniqueRandomNumberGenerator.randomNumberList(1, 9, 3);
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                List<Integer> answer = ProcessUserInput.userAnswer(inputNumber);
                if (RandomNumberMatch.isNumberMatched(uniqueRandomNumber,answer )) {
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (!isGameRestart(choice)) {
                Console.close();
                break;
            }
        }
    }

    private static boolean isGameRestart(String choice) {
        return choice.equals("1");
    }
}