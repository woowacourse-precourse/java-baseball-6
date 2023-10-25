package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        ControlGame game = new ControlGame();
        game.startGame();
    }
}

class ControlGame {
    String gameOver;
    Player user;
    Computer cpu;
    VerifyNumber referee;

    ControlGame() {
        gameOver = "1";
        cpu = new Computer();
        user = new Player();
        referee = new VerifyNumber();
    }

    void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            cpu.makeRandomNumber();
            List<Integer> cpuNum = cpu.getComputerNumber();

            do {
                try {
                    user.makeUserInput();
                } catch (IllegalArgumentException e) {
                    throw e;
                }

                List<Integer> userNum = user.getPlayerNumber();
                referee.countBallnStrike(cpuNum, userNum);
                referee.printBallnStrike();
                referee.checkStrikeCount();
            } while (referee.strikeCount != 3);

            if (referee.strikeCount == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameOver = Console.readLine();
            }
        } while (gameOver.equals("1"));

        exitGame();
    }

    void exitGame() {
        return;
    }
}

class Player {
    List<Integer> playerNum;
    String userInput;

    Player() {
        playerNum = new ArrayList<>();
    }

    void makeUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        userInput = Console.readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        playerNum = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            char characterDigit = userInput.charAt(i);
            int numericValue = Character.getNumericValue(characterDigit);

            if (numericValue <= 0 || numericValue > 9) {
                throw new IllegalArgumentException();
            }
            if (playerNum.contains(numericValue)) {
                throw new IllegalArgumentException();
            }

            playerNum.add(numericValue);
        }
    }

    List<Integer> getPlayerNumber() {
        return playerNum;
    }
}

class Computer {
    List<Integer> computerNum;

    Computer() {
        computerNum = new ArrayList<>();
    }

    void makeRandomNumber() {
        computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    List<Integer> getComputerNumber() {
        return computerNum;
    }
}

class VerifyNumber {
    int ballCount;
    int strikeCount;

    void countBallnStrike(List<Integer> cpu, List<Integer> user) {
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < cpu.size(); i++) {
            if (cpu.get(i) == user.get(i))
                strikeCount++;
        }

        for (int i = 0; i < cpu.size(); i++) {
            for (int j = 0; j < cpu.size(); j++) {
                if (i == j)
                    continue;
                if (cpu.get(i) == user.get(j))
                    ballCount++;
            }
        }
    }

    void printBallnStrike() {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    void checkStrikeCount() {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}