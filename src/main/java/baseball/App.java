package baseball;

public class App {
    Computer computer = new Computer();
    Text text = new Text();
    Input input = new Input();
    Output output = new Output();
    Game game = new Game();
    User user = new User();

    public void start() {
        text.start();
    }

    public void randomNum() {
        computer.threeRandomsNum();
    }

    public void game() {
        String userNum;
        do {
            game.clear();
            userNum = input.userNum();
            game.listCompare(computer.numbers, userNum);
            output.scorePrint(game.ball, game.strike);
        } while (game.strike != 3);
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
