package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private boolean replay;
    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public Game() {
        this.computer = new Computer();
        this.replay = true;
    }

    public void activate() {
        System.out.println(INTRO_MESSAGE);
        computer.generateNumbers();

        do {
            play();
        } while(replay);

        Console.close();
    }

    private void play() {
        Number inputValues = User.getInputNums();
        for(int i=0;i < inputValues.getSize();i++) {
            calcCounts(i, inputValues.getNum(i));
        }
        User.printResult();
    }

    private void calcCounts(int index, int value) {

        if(computer.hasValueAtSameIndex(index, value)) {
            User.addStrikeCount();
            return;
        }

        if(computer.hasValue(value)) {
            User.addBallCount();
        }

    }
}
