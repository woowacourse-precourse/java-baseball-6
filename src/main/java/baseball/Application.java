package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.start();

    }
}

class Game {
    boolean gameContinue = true;

    void start() {
        gameContinue = true;
        List computer = createComputerNumber();

        while (gameContinue) {
            System.out.print("숫자를 입력해주세요 : ");
            int userNumber = Integer.parseInt(Console.readLine());
            List user = checkUserInput(userNumber);
            printRusult(computer, user);
        }
    }

    List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    List<Integer> checkUserInput(int userNumber) {
        List<Integer> user = new ArrayList<>();

        if (userNumber >= 1000 || userNumber <= 0) {
            throw new IllegalArgumentException();
        }

        user.add(userNumber / 100);
        user.add((userNumber % 100) / 10);
        user.add((userNumber % 100) % 10);

        return user;

    }

    void printRusult(List<Integer> computer, List<Integer> user) {
        Counter counter = new Counter();
        int strikeResult = counter.countStrike(computer, user);
        int ballResult = counter.countBall(computer, user);

        if (strikeResult == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restartGame();
        } else if (strikeResult > 0 && ballResult == 0) {
            System.out.println(String.format("%d스트라이크", strikeResult));
        } else if (ballResult > 0 && strikeResult == 0) {
            System.out.println(String.format("%d볼", ballResult));
        } else if (ballResult > 0 && strikeResult > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ballResult, strikeResult));
        } else {
            System.out.println("낫싱");
        }
    }


    void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkRestartNum = Console.readLine();
        if (checkRestartNum.equals("1")) {
            start();
        } else {
            gameContinue = false;
        }
    }

}

class Counter {
    int countStrike(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    int countBall(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}




