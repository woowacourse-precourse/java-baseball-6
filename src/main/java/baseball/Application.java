package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static java.lang.Integer.*;

public class Application {

    public static boolean is3Strike = false;

    public static void main(String[] args) {

        MessageGenerator messageGenerator = new MessageGenerator();
        Validation validation = new Validation();

        messageGenerator.startGame();
        int computerNumber = generateComputerNumber();
        System.out.println("computerNumber = " + computerNumber);

        while (true) {
            // 게임에서 3스트라이크를 했을 때 수행
            if (is3Strike) {
                messageGenerator.selectOption();
                String optionString = readLine();

                int optionNumber = validation.getOptionNumber(optionString);
                if (optionNumber == 1) {
                    computerNumber = generateComputerNumber();
                    is3Strike = false;
                    System.out.println("computerNumber = " + computerNumber);
                } else {
                    // getOptionNumber로 이미 검증을 거친 상태이기 때문에 넘어올 수 있는 수는 1과 2 둘 중 하나이다.
                    break;
                }
            }
            // 게임에서 아직 3스트라이크를 달성하지 못한 경우
            // userInput이 0인 경우 프로그램을 종료하도록 수정해야 한다.
            int userNumber = getUserInput();
            printHint(computerNumber,userNumber);
        }

    }

    public static int generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return parseInt(sb.toString());
    }

    private static int getUserInput() {
        Validation validation = new Validation();
        int validateNumber = 0;

        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = readLine();

        try {
            validateNumber = validation.isValidateNumber(userInputString);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return validateNumber;
    }


    /**
     * 스트라이크의 개수와 볼의 개수가 같으면 스트라이크의 개수를 출력하고, 볼은 0으로 처리해야 한다.
     * 3스트라이크가 나오면 게임이 종료된다.
     */
    private static void printHint(int computerNumber, int userNumber) {

        if (computerNumber - userNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            is3Strike = true;
            return;
        }

        int strike = countStrike(computerNumber, userNumber);
        // 컴퓨터와 유저의 숫자 중 같은 숫자가 몇 개인지 알아낸 뒤
        // 스트라이크의 개수를 빼면 볼의 개수를 구할 수 있다.
        int ball = countSameNumber(computerNumber, userNumber) - strike;

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);

    }

    /**
     * 스트라이크 개수를 반환한다.
     */
    private static int countStrike(int computerNumber, int userNumber) {
        String computerValue = String.valueOf(computerNumber);
        String userValue = String.valueOf(userNumber);
        int count = 0;

        for (int i = 0; i < computerValue.length(); i++) {
            if (computerValue.charAt(i) == userValue.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 컴퓨터의 수와 유저의 수 중 같은 숫자의 개수를 반환한다..
     */
    private static int countSameNumber(int computerNumber, int userNumber) {
        String[] computerValue = String.valueOf(computerNumber).split("");
        String[] userValue = String.valueOf(userNumber).split("");

        HashSet<String> computerSet = new HashSet<>();
        int count = 0;

        for (String character : computerValue) {
            computerSet.add(character);
        }

        for (String character : userValue) {
            if (computerSet.contains(character)) {
                count++;
            }
        }
        return count;
    }

}
