package baseball.service;

import baseball.model.Game;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameService {

    public Game inputNumberToList(Game game, String input) {
        List<Integer> list = new ArrayList<>();
        int number = Integer.parseInt(input);

        for (int i=0; i<3; i++) {
            list.add(0, number % 10);
            number = number / 10;
            game.setNumber(list);
        }
        return game;
    }

    public Boolean isCorrect(Game game) {
        if (game.getStrike() == 3) {
            return true;
        }
        return false;
    }

    public void countStrike(Game game) {
        int count = 0;

        for (int i=0; i<3; i++) {
            if (game.getComputer().get(i) == game.getNumber().get(i)) {
                count ++;
            }
        }
        game.setStrike(count);
    }

    public void countBall(Game game) {
        int count = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == j) {
                    continue;
                }
                if (game.getComputer().get(i) == game.getNumber().get(j)) {
                    count++;
                }
            }
        }
        game.setBall(count);
    }

}
