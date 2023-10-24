package baseball.menu;

import baseball.PlayGame;

import java.io.IOException;

public enum Resume {
    CONTINUE("1") {
        @Override
        public void execute() {
            playGame.play();
        }
    },
    END("2") {
        @Override
        public void execute() {
            System.out.println("게임 종료");
        }
    };

    private String description;
    private static PlayGame playGame = new PlayGame();

    Resume(String description) {
        this.description = description;
    }

    public abstract void execute();
}
