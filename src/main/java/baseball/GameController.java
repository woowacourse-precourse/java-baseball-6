package baseball;

import java.util.List;

public class GameController {

    private Computer computer;
    private User user;

    public GameController() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void run() {
        while (user.getGameStatus()) {
            computer.generateRandomNumbers();
            gameStart();
        }
    }

    public void gameStart() {
        while (true) {
            user.getNumbersFromUser();
            if (compareNumbers(user.getNumbers(), computer.getRandomNumbers())) {
                user.restartGame();
                break;
            }
        }

    }

    public boolean compareNumbers(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballNum = 0;
        int strikeNum = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                strikeNum++;
                continue;
            }
            if (computerNumbers.contains(userNumbers.get(i))) {
                ballNum++;
            }
        }
        printResult(ballNum, strikeNum);
        if (strikeNum == 3) {
            return true;
        }
        return false;
    }

    public void printResult(int ballNum, int strikeNum) {
        if (ballNum != 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum != 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
}
