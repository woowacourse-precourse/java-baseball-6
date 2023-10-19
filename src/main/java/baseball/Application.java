package baseball;


import baseball.controller.Restart;
import baseball.controller.UserNumber;
import baseball.service.RandomNum;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GuessNum.getHint;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        RandomNum randomNumGenerator = new RandomNum();
        UserNumber userNumber = new UserNumber();
        RandomNum randomNum = new RandomNum();
        Restart restart = new Restart();

        boolean startNum = true;

        while (startNum) {
            List<Integer> randomNumber = randomNumGenerator.generateNum();
            List<Integer> userInputNumbers = userNumber.userInputNumbers();
            System.out.println(randomNumber);
            System.out.println(userInputNumbers);

            while (true) {
                if (userNumber.equals(randomNum)) {
                    System.out.println("3스트라이크");
                    startNum = restart.Restart();
                    break;
                }
                else{
                    System.out.println(getHint(randomNumber, userInputNumbers));

                }
            }
        }

    }
}



