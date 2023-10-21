package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.MakeComputerRandom;
import baseball.service.MakeUserAnswer;
import baseball.service.Play;
import baseball.service.PrintResult;
import baseball.service.Restart;
import baseball.service.UserValidation;

public class Application {
    private final MakeComputerRandom makeComputerRandom;
    private final MakeUserAnswer makeUserAnswer;
    private final Play play;
    private final PrintResult printResult;
    private final Restart restart;

    public Application(MakeComputerRandom makeComputerRandom, MakeUserAnswer makeUserAnswer, Play play,
                       PrintResult printResult, Restart restart) {
        this.makeComputerRandom = makeComputerRandom;
        this.makeUserAnswer = makeUserAnswer;
        this.play = play;
        this.printResult = printResult;
        this.restart = restart;
    }

    public static void main(String[] args) {
        UserValidation userValidation = new UserValidation();
        MakeComputerRandom makeComputerRandom = new MakeComputerRandom();
        MakeUserAnswer makeUserAnswer = new MakeUserAnswer(userValidation);
        Play play = new Play();
        Restart restart = new Restart(userValidation);
        PrintResult printResult = new PrintResult();

        Application app = new Application(makeComputerRandom, makeUserAnswer, play, printResult, restart);

        app.runGame();
    }

    private void runGame() {
        boolean isCheck = true;
        int result = 1;
        Computer computer = null;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isCheck) {
            switch (result) {
                case 1:
                    computer = makeComputerRandom.createRandom();
                    result = getResult(computer);
                    break;
                case 2:
                    isCheck = false;
                    break;
                default:
                    result = getResult(computer);
            }
        }
    }

    private int getResult(Computer computer) {
        printResult.printInput();
        User user = makeUserAnswer.input();
        play.playBaseBallGame(computer, user);
        boolean isEndOfGame = printResult.result(user);
        if (isEndOfGame) {
            return restart.restartOrExit();
        }
        return 0;
    }
}
