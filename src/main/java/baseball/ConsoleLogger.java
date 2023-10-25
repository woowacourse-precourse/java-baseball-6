package baseball;

import game.GameOutputInterface;

public class ConsoleLogger implements GameOutputInterface {
    @Override
    public void print(String input) {
        System.out.print(input);
    }
}
