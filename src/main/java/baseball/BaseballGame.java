package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Computer computer;
    private final Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void run() {
        System.out.println(START_MESSAGE);

        startGame();
    }

    public void startGame() {
        initiallizeGame();
        playGame();

        if (restartGame()) {
            startGame();
        }
    }

    public void initiallizeGame() {
        computer.createRandomPicks();
        player.makePicks();
    }

    public void playGame() {
        while (true) {
            computer.call(player.getPicks());
            if (computer.gameFinished(player.getPicks())) {
                System.out.println(END_MESSAGE);
                break;
            }
            player.makePicks();
        }
    }

    public boolean restartGame() {
        System.out.println(ASK_REGAME_MESSAGE);
        String input = Console.readLine();
        return input.equals("1");
    }
}
