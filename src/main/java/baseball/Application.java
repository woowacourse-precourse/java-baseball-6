package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.gameStart();

    }
}

class Game {
    void gameStart() {
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.println(randomNumber);
            }
        }
        while (true) {
            UserTurn(computer);
        }
    }

    void UserTurn(List computer) {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        int userNumber = Integer.parseInt(Console.readLine());

        if (userNumber >= 1000 || userNumber <= 0) {
            // 에외처리
        }

        user.add(userNumber / 100);
        user.add((userNumber % 100) / 10);
        user.add((userNumber % 100) % 10);

        CheckCount checkcount = new CheckCount();
        int strikeResult = checkcount.Strike(computer, user);
        int ballResult = checkcount.Ball(computer, user);

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
            gameStart();
        }
    }

}

class CheckCount {
    int strikeCount = 0;
    int ballCount = 0;

    int Strike(List computer, List user) {
        if (computer.get(0) == user.get(0)) {
            strikeCount++;
        }
        if (computer.get(1) == user.get(1)) {
            strikeCount++;
        }
        if (computer.get(2) == user.get(2)) {
            strikeCount++;
        }
        return strikeCount;
    }

    int Ball(List computer, List user) {
        if (computer.contains(user.get(0)) && !(computer.get(0) == user.get(0))) {
            ballCount++;
        }
        if (computer.contains(user.get(1)) && !(computer.get(1) == user.get(1))) {
            ballCount++;
        }
        if (computer.contains(user.get(2)) && !(computer.get(2) == user.get(2))) {
            ballCount++;
        }
        return ballCount;
    }
}




