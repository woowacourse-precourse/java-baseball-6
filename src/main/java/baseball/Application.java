package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        NumberChecker numberChecker = new NumberChecker();
        InputValidator inputValidator = new InputValidator();

        List<Integer> computer = randomNumberGenerator.generateRandomNumber();
        boolean keepGoing = true;

        while (keepGoing){
            System.out.println("숫자를 입력해주세요 : ");
            System.out.println(computer.get(0) + " " + computer.get(1) + " " + computer.get(2));
            List<Integer> user = inputValidator.validateUserAnswer(Console.readLine());
            System.out.println(user.get(0) + " " + user.get(1) + " " + user.get(2));
            StringBuilder checkResult = numberChecker.checkNumber(user, computer);
            System.out.println(checkResult);
            if(checkResult.toString().equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = inputValidator.validateRestartInput(Console.readLine());

                if (restart == 1)
                    computer = randomNumberGenerator.generateRandomNumber();
                else if (restart == 2)
                    keepGoing = false;

            }
        }

    }
}
