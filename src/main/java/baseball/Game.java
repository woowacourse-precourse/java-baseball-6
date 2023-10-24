package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private static Alert alert = new Alert();
    private Judge judge = new Judge();
    private Computer computer = new Computer();
    private User user = new User();
    ArrayList<Integer> computerInputArray = new ArrayList<>();
    ArrayList<Integer> userInputArray = new ArrayList<>();

    public void start() {
        computerInputArray = computer.getRandomNumber();

        while (true) {
            alert.userInputStartMessage();
            userInputArray = user.getNumber();

            if (judge.judge(userInputArray, computerInputArray).equals("Strike")) {
                alert.gameFinishMessage();
                break;
            }
        }
    }

    public static boolean reStart() {
        alert.reStartMessage();
        String re = Console.readLine();
        if (re.equals("1")) {
            return true;
        } else if (re.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 숫자 입력");
        }
    }
}
