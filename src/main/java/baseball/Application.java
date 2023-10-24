package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Application {

    public static String pickNumber() {
        ArrayList<Integer> computer = new ArrayList<>();
        int result = 0;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                result = result * 10 + randomNumber;
            }
        }
        return Integer.toString(result);
    }

    public static String validateUserInput() {
        String userInput = Console.readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    public static boolean executeBaseballGame(String user, String cpu) {
        if (user.equals(cpu)) {
            System.out.println("3 스트라이크");
            return true;
        }
        System.out.println("일단 3스트라이크는 아님");
        return false;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String cpuNumber = pickNumber();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    String userInput = validateUserInput();
                    if (executeBaseballGame(userInput, cpuNumber)) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String isContinue = Console.readLine();
            if (isContinue.equals("2")) {
                return;
            }
        }
    }
}
