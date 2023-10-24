package baseball;

import static baseball.GameComponent.*;

import camp.nextstep.edu.missionutils.Console;
public class MainGame {

    private final Computer computer;
    private final Validation validation;

    public MainGame(Computer computer, Validation validation) {
        this.computer = computer;
        this.validation = validation;
    }

    public void startGame() {
        while (true) {
            startRound();

            if(!restart()){
                return;
            }
        }
    }

    private void startRound() {
        System.out.println(START_MESSAGE);
        randNum = computer.makeRandNum();
        while (true) {
            System.out.println(INPUT_MESSAGE);
            userNum = Console.readLine();
            validation.isValidInput();
            String result = computer.compareNumbs();
            System.out.println(result);
            if(strikeCnt == 3){
                System.out.println(COMPLETE_MESSAGE);
                return;
            }
        }
    }

    private boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();

        if(input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}