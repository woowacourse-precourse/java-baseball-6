package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    static String userNumber;
    static ArrayList<Integer> computerNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        playBaseBallGame();
    }

    private static void playBaseBallGame() {
        displayStartGame();

        computerNumber = makeRandomComputerNumber();

        while (true) {
            diplayUserInput();
            try {
                userNumber = inputUserNumber();
                String hint = inferHint(computerNumber, userNumber);
                System.out.println(hint);

                if (isAnswer(hint)) {
                    displayCorrectAnswerMessage();
                    if (isWantToQuitGame()) {
                        break;
                    }
                    computerNumber = makeRandomComputerNumber();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                return;
//                System.exit(1); -> 프로그램 종료 시 System.exit()를 호출하지 않는다.
            }
        }
    }

    private static void diplayUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void displayStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    private static boolean isWantToQuitGame() {
        int exitCommand = Integer.parseInt(Console.readLine());
        return exitCommand == 2;
    }

    private static void displayCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static String inputUserNumber() {
        // 사용자에게 3자리 숫자 입력받기
        String userNumber = Console.readLine();


        // 1. 3자리가 아닌경우
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요.");
        }

        // 2. 중복된 수가 있을 경우
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < userNumber.length(); i++) {
            int number = userNumber.charAt(i) - 48;
            set.add(number);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요");
        }

        // 3. 1 ~ 9 사이의 숫자만 입력
        for (int i = 0; i < userNumber.length(); i++) {
            String currentUserNumber = String.valueOf(userNumber.charAt(i) - 48);
            if (!currentUserNumber.matches("^[1-9$]")) {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요");
            }
        }

        // 3. 숫자를 입력하지 않은 경우
        return userNumber;
    }

    private static ArrayList<Integer> makeRandomComputerNumber() {
        ArrayList<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println("computerNumber = " + computerNumber);
        return computerNumber;
    }

    private static String inferHint(List<Integer> computerNumber, String userNumber) {
        int strike = countingStrike(computerNumber, userNumber);
        int ball = countingBall(computerNumber, userNumber);
        return getResult(strike, ball);
    }

    private static String getResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return "낫싱";
        }
        String strikeResult = getGameResult("스트라이크", strike);
        String ballResult = getGameResult("볼", ball);
        return ballResult + strikeResult;
    }

    private static String getGameResult(String type, int count) {
        if (count <= 0) return "";

        return switch (type) {
            case "스트라이크" -> String.format("%d 스트라이크", count);
            case "볼" -> String.format("%d 볼 ", count);
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }


    private static int countingStrike(List<Integer> computerNumber, String userNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int currentUserNumber =  userNumber.charAt(i) - 48;
            int currentComputerNumber = computerNumber.get(i);
            if (currentUserNumber == currentComputerNumber) result++;
        }
        return result;
    }

    private static int countingBall(List<Integer> computerNumber, String userNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int currentUserNumber = userNumber.charAt(i) - 48;
            int currentComputerNumber = computerNumber.get(i);
            if (currentUserNumber != currentComputerNumber && computerNumber.contains(currentUserNumber)) result++;
        }
        return result;
    }

    private static boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private static boolean isAnswer(String hint) {
        return hint.equals("3 스트라이크");
    }
}