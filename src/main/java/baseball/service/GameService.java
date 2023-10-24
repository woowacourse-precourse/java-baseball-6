package baseball.service;

import baseball.Game;
import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;
    Game game;

    public void playGame() {

    }

    public void setGame(int min, int max, int size) {
        this.size = size;
        game = new Game(RandomUtils.getRandomNumbers(min, max, size));
    }

    private int[] getUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
        return getParseInt(input, size);
    }

    private int[] getParseInt(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];
        for (int i = 0; i < input.length(); i++) {
            if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
