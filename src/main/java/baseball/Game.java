package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private static boolean isOver = false;
    private static List<Integer> RandomNumber;

    public static void playGame() {
        while (!isOver) {

            setRandomNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = input();

                int ballCount = Counter.ballCounter(RandomNumber, userInput);
                int strikeCount = Counter.strikeCounter(RandomNumber, userInput);

                printResult(ballCount, strikeCount);

                if (strikeCount == 3) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            setIsOver();
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }

        return computerNum;
    }

    private static void setRandomNumber() {
        RandomNumber = generateRandomNumber();
    }

    private static void printResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
        else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

    }
    public static void setIsOver() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String option = Console.readLine();

            if (option.isEmpty()) {
                throw new IllegalArgumentException("잘못된 OPTION을 입력했습니다.");
            }

            option = option.replace("\n", "");

            if (option.equals("2")) {
                isOver = true;
            }
            else if (option.equals("1")) {}
            else {
                throw new IllegalArgumentException("잘못된 OPTION을 입력했습니다.");
            }
        }catch (Exception e) {
            throw new IllegalArgumentException("잘못된 OPTION을 입력했습니다.");
        }

    }

    public static String input(){
        try {
            String userInput = Console.readLine();

            if (userInput == null) {
                throw new IllegalArgumentException("입력 값은 3자리 숫자입니다.");
            }

            userInput = userInput.replace("\n", "");

            if (!userInput.matches("\\d{3}")) {
                throw new IllegalArgumentException("입력 값은 3자리 숫자입니다.");
            }

            return userInput;
        }catch (Exception e) {
            throw new IllegalArgumentException("입력 값은 3자리 숫자입니다.");
        }

    }

}