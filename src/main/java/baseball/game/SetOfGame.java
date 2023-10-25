package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.numbers.ComputerNumbersGenerator;
import java.util.Objects;

public class SetOfGame {

//    public SetOfGame() {
//
//    }

    public void play() {
        String userInput;

        do {
            UnitOfGame unitOfGame = new UnitOfGame(new ComputerNumbersGenerator());
            unitOfGame.play();
            userInput = promptUserInput();
        } while (Objects.equals(userInput, "1"));
    }

    private String promptUserInput() {
        String userInput;
        do {
            GameView.printAfterSetOfGame();
            userInput = readLine();
        } while (!Objects.equals(userInput, "1") && !Objects.equals(userInput, "2"));
        return userInput;
    }
}
