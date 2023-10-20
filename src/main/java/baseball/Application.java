package baseball;


import baseball.controller.Restart;
import baseball.controller.UserNumber;
import baseball.service.GuessNum;
import baseball.service.RandomNum;


import java.util.List;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        RandomNum randomNum = new RandomNum();
        UserNumber userNumber = new UserNumber();
        Restart restart = new Restart();
        GuessNum guessNum = new GuessNum();

        boolean startNum = true;

        while (startNum) {
            List<Integer> generatedNumbers = randomNum.generateNum();
            System.out.println(generatedNumbers);

            String result = "";

            while (!result.equals("3스트라이크")) {
                result = guessNum.Confirm(generatedNumbers, userNumber.userInputNumbers());
                System.out.println(result);
            }
            startNum = restart.Restart();

        }

    }
}



