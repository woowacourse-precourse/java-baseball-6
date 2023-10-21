package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isStringAllDigits(String input) {
        if (input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO: 리팩터링
        boolean continueGame = true;
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = new ArrayList<>();
            String userInput;
            userInput = Console.readLine();
            if (userInput.length() != 3 || !isStringAllDigits(userInput)) {
                throw new IllegalArgumentException(userInput);
            }

            for (char c : userInput.toCharArray()) {
                user.add(Character.getNumericValue(c));
            }
            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == user.get(i)) {
                    strikeCount++;
                } else if (computer.contains(user.get(i))) {
                    ballCount++;
                }
            }
            if (strikeCount == 3) {
                System.out.println(strikeCount + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = Console.readLine();
                if (!restart.equals("1") && !restart.equals("2")) {
                    throw new IllegalArgumentException();
                }
                if (restart.equals("1")) {
                    computer = new ArrayList<>();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                } else {
                    continueGame = false;
                }
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            } else {
                if (ballCount == 0) {
                    System.out.println(strikeCount + "스트라이크");
                } else if (strikeCount == 0) {
                    System.out.println(ballCount + "볼");
                } else {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
            }
        } while (continueGame);
        System.out.println("게임 종료");
    }
}
