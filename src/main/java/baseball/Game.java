package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Computer pc;
    private final Player player;
    private final Referee referee;

    private Printer printer;

    Game(int length) {
        this.pc = new Computer(length);
        this.player = new Player(length);
        this.referee = new Referee(length);
        this.printer = new Printer();
    }


    public void start(){
        printer.startMessage();
        int restart;
        do{
            restart = play();
        }while(restart == 1);
    }

    private int play() {
        int input;
        List<Integer> answer = new ArrayList<>();
        answer = pc.makeAnswer();
        referee.setAnswer(answer);
        do{
            printer.inputMessage();
            input = player.readInput();
        }while(!referee.judge(input));
        printer.endMessage();
        printer.restartMessage();
        return player.readRestartInput();
    }
}
