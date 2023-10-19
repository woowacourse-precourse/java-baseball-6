package baseball;


import baseball.service.RandomNum;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GuessNum.getHint;


public class Application {
    public static void main(String[] args) {
        System.out.println("start baseball game");
        RandomNum randomNumGenerator = new RandomNum();

        while (true) {
            List<Integer> generatedNumbers = randomNumGenerator.generateNum(); // 새로운 숫자 생성


            while (true) {
                List<Integer> userInputNumbers = new ArrayList<>();
                System.out.print("Input your number: ");
                String number = Console.readLine();

                for (char c : number.toCharArray()) {
                    userInputNumbers.add(Character.getNumericValue(c));
                }

                if (userInputNumbers.equals(generatedNumbers)) {
                    System.out.println("Your right");
                    System.out.println("You want more game? if you want, input 1 , or not, 2");
                    break;
                } else {
                    System.out.println(getHint(generatedNumbers, userInputNumbers));
                    userInputNumbers.clear();
                }
            }
            String stopNum = Console.readLine();
            if (stopNum.equals("1")) {
                continue;
            } else if (stopNum.equals("2")) {
                break;
            }
        }
    }
}
