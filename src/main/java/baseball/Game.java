package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private boolean replay;
    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final Computer computer;

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

        User.resetCounts();
        Number inputValues = User.getInputNums();

        for(int i=0;i < inputValues.getSize();i++) {
            calcCounts(i, inputValues.getNum(i));
        }

        User.printResult();
        checkWin();
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

    private void checkWin() {
        if(!(User.isWinner())) {
            return;
        }

        replay = User.isReplay();

        if(replay) {
            computer.generateNumbers();
        }
    }

}