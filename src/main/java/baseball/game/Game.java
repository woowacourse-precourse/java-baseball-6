package baseball.game;

import baseball.util.NumberParser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private final BaseBall baseBall;

    public Game(int length) {
        this.baseBall = new BaseBall(length);
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다");
        baseBall.start();
        doGame();
    }

    public void doGame() {
        while (!baseBall.isOver()) {
            List<Integer> guessedNumbers = requestInput();
            baseBall.guess(guessedNumbers);
        }

        if (requestRestart()) {
            start();
        }
    }

    private List<Integer> requestInput() {
        System.out.println("숫자를 입력해주세요 : ");
        final String line = Console.readLine();
        return NumberParser.parseIntegerList(line);
    }

    public boolean requestRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String line = Console.readLine();
        if (line.equals("1")) {
            return true;
        } else if (line.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

}
