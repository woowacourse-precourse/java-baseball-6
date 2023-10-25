package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumberList = selectComputerNumbers();
            playGameWithUser(computerNumberList);
            if (selectUserExit()) {
                break;
            }
        }
    }

    private static List<Integer> selectComputerNumbers() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    private static void playGameWithUser(List<Integer> computerNumberList) {
        while (true) {
            List<Integer> userNumberList = inputUserNumbers();
            Result result = getResultForUserNumbers(computerNumberList, userNumberList);
            result.toStringResult();

            if (result.correctAllNumbers()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> inputUserNumbers() {
        List<Integer> userNumberList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력 개수(3개) 부족 또는 초과");
        }

        userNumberList = changeStringToList(userInput);
        return userNumberList;
    }

    private static List<Integer> changeStringToList(String userInput) {
        List<Integer> userNumberList = new ArrayList<>();
        boolean selectedNum[] = new boolean[10];
        Arrays.fill(selectedNum, false);

        for (int i = 0; i < userInput.length(); i++) {
            int number = userInput.charAt(i) - '0';

            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("조건 범위(1-9) 밖의 입력");
            }

            if (selectedNum[number]) {
                throw new IllegalArgumentException("중복된 숫자 존재");
            }

            userNumberList.add(number);
            selectedNum[number] = true;
        }
        return userNumberList;
    }

    private static Result getResultForUserNumbers(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strike = 0;
        int ball = 0;

        for (int k = 0; k < userNumberList.size(); k++) {
            int computerNumber = computerNumberList.get(k);
            int userNumber = userNumberList.get(k);

            if (computerNumber == userNumber) {
                strike++;
            }

            if (computerNumber != userNumber && computerNumberList.contains(userNumber)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private static boolean selectUserExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("2")) {
            return true;
        }

        if (userInput.equals("1")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력 형식 (1 또는 2만 가능)");
    }
}
