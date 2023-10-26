package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    enum GameStatus {
        RE_GAME("1"), END_GAME("2"), WIN_GAME("3스트라이크");
        private final String value;

        GameStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            Player player = new Player();
            Computer computer = new Computer();
            startGame();
            inGame(player, computer);
        } while (!endGame());
    }

    private static boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(GameStatus.END_GAME.getValue())) {
            return true;
        }

        if (input.equals(GameStatus.RE_GAME.getValue())) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2의 값을 입력하세요");
    }

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void inGame(Player player, Computer computer) {
        while (true) {
            String guess = getGuessNumber();
            player.writeGuessNumber(Note.writeDown(guess));
            String gameResult = computer.judgeGameResult(player.getGuessNumber());
            System.out.println(gameResult);
            if (gameOver(gameResult)) {
                break;
            }
        }
    }

    private static boolean gameOver(String gameResult) {
        if (gameResult.equals(GameStatus.WIN_GAME.getValue())) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static String getGuessNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

}
