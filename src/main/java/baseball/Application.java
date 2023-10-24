package baseball;

import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.input.Input;
import baseball.domain.output.Output;
import baseball.domain.util.Judgement;

public class Application {
    public static void main(String[] args) {

        Output output = new Output();
        Computer computer = new Computer();
        Input input = new Input();
        Judgement judgement = new Judgement();
        Game game = new Game(input, computer, output, judgement);

        output.printStartGameMessage();
        game.startGame();

    }
}
