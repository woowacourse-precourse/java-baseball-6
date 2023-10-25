package baseball;

import camp.nextstep.edu.missionutils.Console;
import gameUser.Computer;
import gameUser.User;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game {
    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            getUserInput();
            if (!askGameProgress()) {
                break;
            }
        }
    }

    private boolean getUserInput() {
        while (true) {
            User user = new User();
            int[] result = compareNum(user.getUserNum());

            if (result[0] == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            printGameResult(result);
        }
    }

    public int[] compareNum(List<Integer> user) {
        int strike = 0, ball = 0;
        List<Integer> computerNum = computer.getComputerNum();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(computerNum.get(i), user.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new int[]{strike, ball};
    }

    private void printGameResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        } else if (result[0] > 0 && result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] == 0 && result[1] > 0) {
            System.out.println(result[1] + "볼");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        }
    }

    private boolean askGameProgress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = Integer.parseInt(Console.readLine());

        if (num == 1) {
            computer = new Computer();
        } else if (num == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임 재시작은 1, 종료는 2 입니다.");
        }

        return true;
    }
}