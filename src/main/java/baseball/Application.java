package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        NumberChecker numberChecker = new NumberChecker();
        ErrorChecker errorChecker = new ErrorChecker();

        List<Integer> computer = randomNumberGenerator.generateRandomNumber();
        boolean keepGoing = true;

        while (keepGoing){
            System.out.println("숫자를 입력해주세요 : ");
            int user = Integer.parseInt(Console.readLine());
            errorChecker.checkError(user);
            String checkResult = numberChecker.checkNumber(user, computer);
            if(checkResult.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int retry = Integer.parseInt(Console.readLine());
                errorChecker.checkError(retry);

                if (retry == 1)
                    computer = randomNumberGenerator.generateRandomNumber();
                else if (retry == 2)
                    keepGoing = false;

            }
        }

    }
}
