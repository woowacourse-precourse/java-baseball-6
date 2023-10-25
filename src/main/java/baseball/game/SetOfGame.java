package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Objects;

public class SetOfGame extends Game {

    private final UnitOfGameFactory unitOfGameFactory;

    public SetOfGame(UnitOfGameFactory unitOfGameFactory) {
        this.unitOfGameFactory = unitOfGameFactory;
    }

    @Override
    public void play() {
        String userInput;

        do {
            UnitOfGame unitOfGame = unitOfGameFactory.create();
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
