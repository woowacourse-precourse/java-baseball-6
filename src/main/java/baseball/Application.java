package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.start();
        do {
            baseball.randomNum();
            baseball.game();
        } while (baseball.end());
    }
}
class Baseball {
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
        do {
            game.clear();
            input.userNum();
            game.listCompare(computer.numbers, user.number);
            output.scorePrint(game.ball, game.strike);
        } while (game.strike == 3);
    }

    public boolean end() {
        text.win();
        return input.restartOrEndOption();
    }
}
