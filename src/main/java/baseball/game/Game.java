package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final String RESTART_KEYWORD = "1";
    private static final String EXIT_KEYWORD = "2";

    private Computer computer;
    private Player player;
    private InputHandler inputHandler;

    public Game(Computer computer, Player player, InputHandler inputHandler) {
        this.computer = computer;
        this.player = player;
        this.inputHandler = inputHandler;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        init();
        loop();
    }

    private void init() {
        computer.generateRandomNumbers();
        player.setNumbers(inputHandler.getPlayInput());
    }

    private void loop() {
        while (true) {
            if (handleGameOver()) {
                return;
            }
            player.setNumbers(inputHandler.getPlayInput());
        }
    }

    private boolean handleGameOver() {
        Umpire umpire = new Umpire(computer.getNumbers(), player.getNumbers());
        if (umpire.isGameSet()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if (!restartOrExitGame()) {
                return true;
            }
        }
        return false;
    }

    private boolean restartOrExitGame() {
        System.out.println("게임을 새로 시작하려면 " + RESTART_KEYWORD + ", 종료하려면 " + EXIT_KEYWORD + "를 입력하세요.");
        String playerChoice = Console.readLine();

        if (RESTART_KEYWORD.equals(playerChoice)) {
            computer.generateRandomNumbers();
            return true;
        }
        if (EXIT_KEYWORD.equals(playerChoice)) {
            return false;
        }

        throw new IllegalArgumentException(RESTART_KEYWORD + " 또는 " + EXIT_KEYWORD + " 중 하나만 선택하세요.");
    }
}
