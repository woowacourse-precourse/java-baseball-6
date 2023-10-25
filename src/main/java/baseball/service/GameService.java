package baseball.service;

import baseball.Game;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;

    Parser parser = new Parser();


    public void setGame(int min, int max, int size) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(min, max, size));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            System.out.println(game.getBallCount() + game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
    }


    private int[] getUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }


}
