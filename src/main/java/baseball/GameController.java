package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    Computer computer;
    Player player;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
        endGame();
    }

    public void playGame() {
        computer = new Computer();
        int strikes = 0;
        int balls = 0;

        while (strikes != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            player = new Player(Console.readLine());

            strikes = countStrikes(computer.getRandomNumber(), player.getInputNumber());
            balls = countBalls(computer.getRandomNumber(), player.getInputNumber());
            printStrikesAndBalls(strikes, balls);
        }
    }

    public void endGame() {
        boolean restartGame = true;

        while (restartGame) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            if (restart.equals("1")) {
                playGame();
            } else if (restart.equals("2")) {
                restartGame = false;
            } else {
                throw new IllegalArgumentException("재시작 숫자를 잘못 입력하셨습니다.");
            }
        }
    }

    public int countStrikes(String computerNumber, String playerNumber) {
        int strikes = 0;

        for (int i = 0; i < computerNumber.length(); i++) {
            char computerNumberDigit = computerNumber.charAt(i);
            char playerNumberDigit = playerNumber.charAt(i);

            if (computerNumberDigit == playerNumberDigit) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(String computerNumber, String playerNumber) {
        int balls = 0;

        for (int i = 0; i < computerNumber.length(); i++) {
            char computerNumberDigit = computerNumber.charAt(i);
            char playerNumberDigit = playerNumber.charAt(i);

            if (computerNumberDigit != playerNumberDigit && computerNumber.contains(
                    String.valueOf(playerNumberDigit))) {
                balls++;
            }
        }

        return balls;
    }

    public void printStrikesAndBalls(int strikes, int balls) {
        if (strikes < 1 && balls < 1) {
            System.out.println("낫싱");
        }

        if (strikes >= 1 && balls < 1) {
            System.out.println(strikes + "스트라이크");
        }

        if (strikes < 1 && balls >= 1) {
            System.out.println(balls + "볼");
        }

        if (strikes >= 1 && balls >= 1) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }
}
