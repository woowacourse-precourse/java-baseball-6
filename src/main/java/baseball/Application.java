package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exitgame = false;
        while (!exitgame) {
            List<Integer> computer = generateNumbers();
            boolean gameOver = false;

            while (!gameOver) {
                String user = getUserNumbers();
                String result = getResult(computer, user);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int choice = Integer.parseInt(Console.readLine());
                    if (choice == 1) { // 0 1
                        computer = generateNumbers();
                    }
                    else if(choice == 2) {
                        gameOver = true;
                        exitgame = true;
                        break;
                    }
                    else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
            }

        }
    }

    private static List<Integer> generateNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static String getUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            if (input.contains("0")) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
            }

            if (input.length() != 3) {
                throw new IllegalArgumentException("세 자리수가 아닙니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return input;
    }

    private static String getResult(List<Integer> computer, String user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < user.length(); i++) {
            int number = Character.getNumericValue(user.charAt(i));

            if (computer.get(i) == number) {
                strikeCount++;
            } else if (computer.contains(number)) {
                ballCount++;
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        String result = "";
        if (ballCount > 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }

        return result;
    }
}