package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String ASK_REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Computer computer;
    private final Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void run() {
        initGame();
        playGame();
        System.out.println(GAME_END_MESSAGE);

        if (startRegame()) {
            run();
        }
    }

    private void initGame() {
        computer.createRandomBalls();
        player.makeBalls();
    }

    private void playGame() {
        while (true) {
            computer.makeJudge(player.getBalls());
            if (computer.gameFinished(player.getBalls())) {
                break;
            }

            player.makeBalls();
        }
    }

    public boolean startRegame() {
        System.out.println(ASK_REGAME_MESSAGE);
        String input = Console.readLine();
        return input.equals("1");
    }
}
