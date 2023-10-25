package baseball.util;

import baseball.model.Game;

public class NumberComparison {
    public Game compareNumber(String computer, String userInput) {
        Game game = new Game();

        if (computer.equals(userInput)) {
            game.setStrikeCount(userInput.length());
            return game;
        }

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == computer.charAt(i)) {
                   game.addstrikeCount();
            } else if (computer.indexOf(userInput.charAt(i)) != -1) {
                 game.addBallCount();
            }
        }

        return game;
    }
}
