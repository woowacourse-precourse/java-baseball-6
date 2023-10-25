package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager<A> {
    private boolean isProgressing = true;
    private final Game<A> game;

    public GameManager(Game<A> game) {
        this.game = game;
    }

    public void play() {
        while(this.isProgressing) {
            game.init();
            game.play();
            if(!isContinued()) {
                stop();
            }
        }
    }

    public void start() {
        isProgressing = true;
    }

    public void stop() {
        isProgressing = false;
    }

    private boolean isContinued() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        this.isProgressing = Integer.parseInt(userInput) == 1;
        return this.isProgressing;
    }
}
