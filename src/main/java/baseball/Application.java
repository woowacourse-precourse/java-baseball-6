package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Digit digit = new Digit();
            Correct correct = new Correct();
            GamePlay gamePlay = new GamePlay();

            digit.setBall(0);
            digit.setStrike(0);
            digit.setReStart(1);
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (digit.getReStart() != 2) {
                digit.generateComputerNumber();

                digit.setStrike(0);
                while (digit.getStrike() != 3) {

                    digit.setBall(0);
                    digit.setStrike(0);
                    digit.setBallPlusStrike(0);
                    gamePlay.inputUserString();
                    //System.out.println("컴퓨터 : " + digit.getComputerNumber());

                    if (!correct.isDigit(gamePlay.getUserString())) {
                        throw new IllegalArgumentException();
                    }
                    if (!correct.isThree(gamePlay.getUserString())) {
                        throw new IllegalArgumentException();
                    }
                    List<Integer> userNumber = new ArrayList<>();
                    String[] dump = gamePlay.getUserString().split("");
                    while (userNumber.size() < 3) {
                        userNumber.add(Integer.parseInt(dump[userNumber.size()]));
                    }
                    if (!correct.isDuplicate(userNumber)) {
                        throw new IllegalArgumentException();
                    }
                    digit.inputUserNumber(userNumber);


                    digit.isBall();
                    digit.isStrike();
                    digit.setBallPlusStrike(digit.getStrike()+digit.getBall());
                    System.out.println(digit.outputResult());
                    if (digit.getStrike() == 3) {

                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String userInput = Console.readLine();
                        digit.setReStart(Integer.parseInt(userInput));
                        if (userInput.equals("1")) {
                            digit.setReStart(1);
                        }
                        else if (userInput.equals("2")) {
                            digit.setReStart(2);
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                    }

                }
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}