package baseball;

import java.util.List;

public class App {
    Computer computer = new Computer();
    Text text = new Text();
    Input input = new Input();
    Output output = new Output();
    Game game = new Game();

    public void start() {
        text.start();
    }

    public void randomNum() {
        computer.threeRandomsNum();
    }

    public void game() {
        do {
            game.clear();
            String userNum = input.userNum();
            game.listCompare(computer.numbers, userNum);
            output.scorePrint(game.score.get(game.BALL), game.score.get(game.STRIKE));
        } while (game.score.get(game.STRIKE) != 3);
    }

    public boolean end() {
        text.win();
        return input.restartOrEndOption();
    }

    public void app() {
        boolean option;
        start();
        do {
            randomNum();
            game();
            option = end();
        } while (option);
    }
}
