package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean ongoing = true;
        while (ongoing) {
            baseBallGame();
            if(gameExit())
                ongoing = false;
        }
    }

    public static boolean gameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int code = 0;
        while (code != 1 && code != 2) {
            code = Integer.parseInt(Console.readLine());
        }
        return code == 2;
    }

    public static void baseBallGame() {
        ArrayList<Integer> systemNumber = generateRandomNumber();
        while (!guess(systemNumber)) ;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean guess(ArrayList<Integer> systemNumber) {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 인자를 입력했습니다.");
        }

        int countOfBall = 0;
        int countOfStrike = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int number = input.charAt(i) - '0';
            if (systemNumber.get(i) == number)
                countOfStrike++;
            else if (systemNumber.contains(number))
                countOfBall++;
        }


        String output;
        if (countOfBall != 0) {
            output = countOfBall + "볼";
            if (countOfStrike != 0) {
                output = output + " " + countOfStrike + "스트라이크";
            }
        } else if (countOfStrike != 0) {
            output = countOfStrike + "스트라이크";
        } else {
            output = "낫싱";
        }
        System.out.println(output);

        return countOfStrike == 3;
    }

    public static ArrayList<Integer> generateRandomNumber() {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < NUMBER_LENGTH) {
            int randomInteger = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(randomInteger))
                randomNumber.add(randomInteger);
        }
        return randomNumber;
    }
}
