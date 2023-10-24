package baseball;

import game.GameOutputInterface;

public class ConsoleLogger implements GameOutputInterface {
    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
