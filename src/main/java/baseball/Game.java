package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {

    public static ArrayList<Integer> computerNumber = new ArrayList<>();
    public static ArrayList<Integer> userNumber = new ArrayList<>();
    public static int strikeCount = 0;
    public static int ballCount = 0;

    public void gameStart() {

        Computer computer = new Computer();
        User user = new User();

        computerNumber = computer.setComputerNumber(computerNumber);

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            initializationGameSetting();

            System.out.print("숫자를 입력해주세요 : ");
            userNumber = user.getUserNumber(userNumber);

            checkScore();

            String userSelection = showResult();
            if (userSelection.equals("2")) {
                break;
            } else if (userSelection.equals("1")) {
                computerNumber = computer.setComputerNumber(computerNumber);
            }
        }

    }

    public void initializationGameSetting() {
        strikeCount = 0;
        ballCount = 0;
        userNumber = new ArrayList<>();
    }

    public void checkScore() {
        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = 0; j < userNumber.size(); j++) {
                if (computerNumber.get(i).equals(userNumber.get(j)) && i == j) {
                    strikeCount++;
                } else if (computerNumber.get(i).equals(userNumber.get(j)) && i != j) {
                    ballCount++;
                }
            }
        }
    }

    public String showResult() {
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userSelect = Console.readLine();
            if (!userSelect.matches("^[1-2]$")) {
                throw new IllegalArgumentException("1과 2의 숫자 중 하나를 입력하셔야합니다.");
            }
            if (userSelect.equals("2")) {
                System.out.println(" *** 게임을 종료합니다 !! *** ");
                return userSelect;
            }
            return userSelect;
        } else if (strikeCount > 0 && strikeCount < 3 && ballCount > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
        } else if (strikeCount > 0 && strikeCount < 3 && ballCount == 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.printf("%d볼\n", ballCount);
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        return "0";
    }
}
