package baseball;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.service.RefereeService;
import baseball.view.Input;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        boolean isContinue = true;

        output.start();
        while (isContinue) {
            Computer computer = new Computer();
            computer.randComNumber();
            String comNumber = computer.getNumber();

            Player player = new Player();
            while (true) {
                output.InputNumber();
                String playerNumber = input.inputNumber();

                Referee referee = new Referee();
                int count_ball = referee.countBall(comNumber, playerNumber);
                int count_strike = referee.countStrike(comNumber, playerNumber);

                RefereeService refereeService = new RefereeService();
                String answer = refereeService.judgement(count_ball, count_strike);

                System.out.println(answer);

                if (refereeService.gameEnd(comNumber, playerNumber)) {
                    output.end();
                    int gameOver = input.inputContinue();
                    if (gameOver==2) {
                        isContinue = output.gameOver();
                        break;
                    }else if(gameOver==1){
                        computer.randComNumber();
                        comNumber = computer.getNumber();
                    }
                }
            }
        }
    }
}
