package baseball.service;

import baseball.Game;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;

    Parser parser = new Parser();


    public void playGame() {

    }

    public void setGame(int min, int max, int size) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(min, max, size));
    }

    private int[] getUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return parser.parseUserInput(input, size);
    }


}
