package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameStart();
    }

    static void gameStart() {
        final List<Integer> COMPUTERNUMBER = randomNumber();

        int userNumber = 0;
        String gameHint = hint(userNumber, COMPUTERNUMBER);
        try {
            while (gameHint != "3스트라이크") {
                userNumber = getUserInput();
                validateNumber(userNumber);
                gameHint = hint(userNumber, COMPUTERNUMBER);
                System.out.println(gameHint);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

        if (gameHint == "3스트라이크") {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int number = Integer.parseInt(Console.readLine());
            restartGameOrExit(number);
        }
    }

    static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        int userNumber = Integer.parseInt(Console.readLine());
        return userNumber;
    }

    static void validateNumber(int userNumber) {
        if (userNumber < 100 || userNumber > 999) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }

        String numberString = String.valueOf(userNumber);

        Set<Character> digits = new HashSet<>();

        for (char digit : numberString.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            if (!digits.add(digit)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
            }
            if (digit == '0') {
                throw new IllegalArgumentException("1-9 범위의 숫자가 아닙니다.");
            }
        }
    }

    static String hint(int userNumber, List<Integer> COMPUTERNUMBER) {
        // 사용자의 숫자
        String userNumberString = String.valueOf(userNumber);

        int sameNumber = 0;

        // 동일한 숫자가 들어있는 list
        List<Integer> sameNumberString = new ArrayList<>();

        // 사용자 숫자를 하나씩 검사 - 컴퓨터 숫자랑 동일한게 있는지
        for (char digit : userNumberString.toCharArray()) {
            for (int i : COMPUTERNUMBER) {
                char charI = (char) ('0' + i);
                if (digit == charI) {
                    sameNumber += 1;
                    // 동일한 숫자가 있는 경우에 list 에 추가
                    sameNumberString.add(i);
                }
            }
        }

        if (sameNumber == 0) {
            String result = "낫싱";
            return result;
        } else if (sameNumber == 1) {
            int computerIndex = COMPUTERNUMBER.indexOf(sameNumberString.get(0));
            int userNumberIndex = userNumberString.indexOf(sameNumberString.get(0));
            if (computerIndex == userNumberIndex) {
                String result = "1스트라이크";
                return result;
            } else {
                String result = "1볼";
                return result;
            }
        } else if (sameNumber == 2) {
            int sameCount = 0;
            for (int i = 0; i < 2; i++) {
                int computerIndex = COMPUTERNUMBER.indexOf(sameNumberString.get(i));
                int userNumberIndex = userNumberString.indexOf(String.valueOf(sameNumberString.get(i)));
                if (computerIndex == userNumberIndex) {
                    sameCount += 1;
                }
            }
            if (sameCount == 0) {
                String result = "2볼";
                return result;
            } else if (sameCount == 1) {
                String result = "1볼 1스트라이크";
                return result;
            } else {
                String result = "2스트라이크";
                return result;
            }
        } else {
            int sameCount = 0;
            for (int i = 0; i < 3; i++) {
                int computerIndex = COMPUTERNUMBER.indexOf(sameNumberString.get(i));
                int userNumberIndex = userNumberString.indexOf(String.valueOf(sameNumberString.get(i)));
                if (computerIndex == userNumberIndex) {
                    sameCount += 1;
                }
            }

            if (sameCount == 0) {
                String result = "3볼";
                return result;
            } else if (sameCount == 1) {
                String result = "2볼 1스트라이크";
                return result;
            } else if (sameCount == 2) {
                String result = "1볼 2스트라이크";
                return result;
            } else {
                String result = "3스트라이크";
                return result;
            }
        }
    }

    static void restartGameOrExit(int number) {
        if (number == 1) {
            gameStart();
        }
    }
}
