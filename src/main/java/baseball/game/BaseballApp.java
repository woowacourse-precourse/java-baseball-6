package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseballApp {

    public Computer computer;
    public User user;

    public BaseballApp() {
        this.user = new User();
        this.computer = new Computer(user);
    }

    public void run() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public void startGame() {

        boolean power = true;

        while (power) {

            String input = user.getInput();

            if (user.checkInput(input)) {
                Map<String, Integer> compareMap = computer.compare(transToList(input));
                boolean result = computer.showResult(compareMap);

                if (result) {
                    power = gameOver();
                }
            }
        }
    }

    public List<Integer> transToList(String input) {

        List<Integer> numList = new ArrayList<>();

        int wholeNum = Integer.parseInt(input);

        for (int i = 100; i > 0; i /= 10) {
            int nowNum = wholeNum / i;
            numList.add(nowNum);
            wholeNum -= nowNum * i;
        }
        return numList;
    }

    public boolean gameOver() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameOverCode = user.getInput();

        if (gameOverCode.equals("1")) {
            computer.genNumbers();
        } else if (gameOverCode.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1이나 2만 입력해주세요");
        }

        return true;
    }

}
