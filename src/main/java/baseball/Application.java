package baseball;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        boolean isContinue = output.start();

        while (isContinue) {
            Computer computer = new Computer();
            Player player = new Player();

            String comNumber = computer.randComNumber();

            while (true) {
                Referee referee = new Referee();
                output.InputNumber();
                String playerNumber = input.inputNumber();

                int count_ball = referee.countBall(comNumber, playerNumber);
                int count_strike = referee.countStrike(comNumber, playerNumber);

                String answer = referee.judgement(count_ball, count_strike);
                output.score(answer);

                if (referee.gameEnd(comNumber, playerNumber)) {
                    output.end();
                    int gameOver = input.inputContinue();
                    if (gameOver==2) {
                        isContinue = output.gameOver();
                        break;
                    }else if(gameOver==1){
                        comNumber = computer.randComNumber();
                    }
                }
            }
        }
    }
}
