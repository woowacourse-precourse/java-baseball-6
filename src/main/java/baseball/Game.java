package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Game {
    private Player player = new Player();
    private Player computer = new Player();

    private Hint hint = new Hint();

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void getGuessNums() {
        System.out.println("숫자를 입력해주세요 : ");
        String guessNumsStr = Console.readLine();
        ArrayList guessNums = new ArrayList<>();
        for (int i = 0; i < guessNumsStr.length(); i++) {
            guessNums.add(guessNumsStr.charAt(i));
        }

        player.setGuessNums(guessNums);
    }
}
