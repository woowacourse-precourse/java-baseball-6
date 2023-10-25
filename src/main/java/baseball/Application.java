package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int INPUT_SIZE = 3;
    public static void main(String[] args) {
        baseballGame();
    }

    private static void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = getRandomIntegers();
            playOneRound(computer);

            if (!askPlayAgain()) break;
        }
    }

    private static void playOneRound(List<Integer> computer) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            inputValueExceptionHandler(user);
            ArrayList<Integer> userInputList = convertStringToIntList(user);

            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < INPUT_SIZE; i++) {
                if (userInputList.get(i) == computer.get(i)) {
                    strikeCount++;
                } else if (computer.contains(userInputList.get(i))) {
                    ballCount++;
                }
            }

            if (printResults(strikeCount, ballCount)) break;
        }
    }

    private static boolean askPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playAgain = Integer.parseInt(Console.readLine());
        if (playAgain == 1) {
            return true;
        }
        return false;
    }

    private static List<Integer> getRandomIntegers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void inputValueExceptionHandler(String user) {
        checkInputSize(user);
        checkIsInteger(user);
        checkDuplicate(user);
    }

    private static void checkInputSize(String user) {
        if (user.length() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkIsInteger(String user) {
        if (!isInteger(user)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void checkDuplicate(String user) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < user.length(); i++) {
            char ch = user.charAt(i);

            if (charSet.contains(ch)) {
                throw new IllegalArgumentException();
            }
            charSet.add(ch);
        }
    }

    private static ArrayList<Integer> convertStringToIntList(String user) {
        ArrayList<Integer> userInputList = user.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toCollection(ArrayList::new));
        return userInputList;
    }

    private static boolean printResults(int strikeCount, int ballCount) {
        if (correctAnswer(strikeCount)) return true;
        return wrongAnswer(strikeCount, ballCount);
    }

    private static boolean correctAnswer(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static boolean wrongAnswer(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        return false;
    }
}
