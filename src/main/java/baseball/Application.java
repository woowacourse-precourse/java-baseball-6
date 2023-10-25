package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = generateNumbers();
            boolean gameOver = false;

            while (!gameOver) {
                List<Integer> user = getUserNumbers();
                String result = getResult(computer, user);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int choice = Integer.parseInt(Console.readLine());
                    if (choice != 1) {
                        break;
                    }
                    else {
                        gameOver = true;
                        break;
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

    private static List<Integer> getUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> user = new ArrayList<>();

        try {
            if (user.size() != 3) {
                throw new IllegalArgumentException("세 자리수가 아님");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return user;
    }

    private static String getResult(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            } else if (computer.contains(user.get(i))) {
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

        return result.toString();
    }
}