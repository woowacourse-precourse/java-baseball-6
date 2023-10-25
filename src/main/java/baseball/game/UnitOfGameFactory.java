package baseball.game;

import baseball.numbers.ComputerNumbersGenerator;

public class UnitOfGameFactory implements GameFactory {
    @Override
    public UnitOfGame create() {
        return new UnitOfGame(new ComputerNumbersGenerator());
    }
}
