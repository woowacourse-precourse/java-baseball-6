package baseball;

import static baseball.Constant.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public Game() {
    }

    public void play() {
        boolean is3Strike = false;
        Computer computer = new Computer();
        do {
            System.out.print(INPUT_MESSAGE);
            String inputString = Console.readLine().replace(" ", ""); // 공백 실수 허용
            Player player = new Player(inputString);
            is3Strike = computer.checkResult(player.getDuplicatePlayerList());
        } while (!is3Strike);
    }


}