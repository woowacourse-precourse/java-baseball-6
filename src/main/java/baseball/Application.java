package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumber = generateRandomNumber();
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.print("숫자를 입력해주세요 : ");
                String playerNumber = Console.readLine();
                if (!isValidNumber(playerNumber)) {
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                }
                String result = checkNumber(computerNumber, playerNumber);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    isCorrect = true;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            String choice = Console.readLine();
            if (choice.equals("2")) {
                keepPlaying = false;
            }
        }
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean isValidNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        for (char c : number.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String checkNumber(List<Integer> computerNumber, String playerNumber) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            int playerDigit = Character.getNumericValue(playerNumber.charAt(i));
            if (computerNumber.get(i) == playerDigit) {
                strikes++;
            } else if (computerNumber.contains(playerDigit)) {
                balls++;
            }
        }
        if (strikes == 3) {
            return "3스트라이크";
        } else if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}