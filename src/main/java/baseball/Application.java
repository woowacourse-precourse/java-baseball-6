package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        boolean playAgain;

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 게임이 실행되는 동안 생성된 첫 컴퓨터넘버는 고정된다.
            List<Integer> computerNumber = getComputerNumber();
            match(computerNumber);
            playAgain = isPlayAgain();
        } while (playAgain);

        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    private static void match(List<Integer> computerNumber) {
        boolean rematch = true;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = getUserNumber();

            rematch = isRematch(computerNumber, userNumber, rematch);
        } while (rematch);
    }

    private static boolean isRematch(List<Integer> computerNumber, List<Integer> userNumber, boolean rematch) {
        int strikes = countStrikes(computerNumber, userNumber);
        int balls = countBalls(computerNumber, userNumber);

        printResult(strikes, balls);

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            rematch = false;
        }

        return rematch;
    }

    private static void printResult(int strikes, int balls) {
        StringBuilder result = new StringBuilder();

        printBalls(balls, result);

        printStrikes(strikes, result);

        printNothing(result);

        System.out.println(result.toString());
    }

    private static void printNothing(StringBuilder result) {
        if (result.isEmpty()) {
            result.append("낫싱");
        }
    }

    private static void printStrikes(int strikes, StringBuilder result) {
        if (strikes > 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(strikes).append("스트라이크");
        }
    }

    private static void printBalls(int balls, StringBuilder result) {
        if (balls > 0) {
            result.append(balls).append("볼");
        }
    }

    private static boolean isPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice;
        // 1, 2 이외 다른 숫자를 입력하거나 숫자를 입력하지 않을 경우 IllegalArgumentException 발생
        try {
            choice = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
        }

        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
        }
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        randomNumberGenerator(computerNumber);

        return computerNumber;
    }

    private static void randomNumberGenerator(List<Integer> computerNumber) {
        // 1 부터 9 까지 서로 다른 임의의 수 3개 생성
        while (computerNumber.size() < 3) {
            int ramdomNumber;
            // 1 ~ 9 사이의 난수를 생성한다.
            // 생성된 난수가 중복이면 다시 난수를 생성한다.
            do {
                ramdomNumber = Randoms.pickNumberInRange(1, 9);
            } while (computerNumber.contains(ramdomNumber));

            computerNumber.add(ramdomNumber);
        }
    }

    private static List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();

        String inputNumber = Console.readLine();

        // 자릿수가 3인지 확인
        sizeValidator(inputNumber);

        // 숫자로 정상 변경이 되는지 확인
        formatValidator(userNumber, inputNumber);

        //  중복 제거 후 자릿수가 3인지 확인
        duplicationValidator(userNumber);

        return userNumber;
    }

    private static void sizeValidator(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private static void formatValidator(List<Integer> userNumber, String inputNumber) {
        try {
            for (int i = 0; i < 3; i++) {
                userNumber.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private static void duplicationValidator(List<Integer> userNumber) {
        if (userNumber.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3개의 서로 다른 숫자를 입력하세요.");
        }
    }

    private static int countStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            // 같은 자리에 있는 컴퓨터넘버와 유저넘버기 서로 같은 경우
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int countBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            // 같은 자리에 있는 컴퓨터넘버와 유저넘버기 서로 같지 않고, 컴퓨터넘버에 유저넘버가 포함되는 경우
            if (!computerNumber.get(i).equals(userNumber.get(i)) && computerNumber.contains(userNumber.get(i))) {
                balls++;
            }
        }
        return balls;
    }

}
