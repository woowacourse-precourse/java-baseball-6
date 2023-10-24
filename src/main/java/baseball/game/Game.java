package baseball.game;

import baseball.role.Computer;
import baseball.role.User;
import baseball.utils.PrintUtils;
import baseball.utils.InputValue;

import java.util.List;
import static baseball.constvalue.ConstValue.*;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    private InputValue input = new InputValue();
    private Score score = new Score();
    private final PrintUtils printUtil = new PrintUtils();

    public Game(){
        computer.generateNewNumbers();
    }

    public void play(){
        printUtil.printStartGame();

        boolean againGame = true;

        while (againGame) {
            getUserAnswer();
            compareAnswer();
            if (score.isThreeStrike()){
                printUtil.printClear();
                againGame = restart();
            }
            score.resetScore();
        }
    }

    public void getUserAnswer(){
        printUtil.printQuestion();
        input.getUserNumbersInput();
        user.setNumbers(input.convertUserNumbers());
        System.out.println();
    }

    public void compareAnswer(){
        List<Integer> com = computer.getNumbers();
        List<Integer> usr = user.getNumbers();

        for (int i=0;i<NUMBER_LENGTH;i++){
            if(usr.get(i).equals(com.get(i))) {
                score.addStrike();
            } else if(com.contains(usr.get(i))){
                score.addBall();
            }
        }

        printUtil.printScore(score);
    }

    public boolean restart(){
        printUtil.printRestartQuestion();

        input.getGameRestartInput();
        boolean userRestart = input.convertGameRestart();

        if (userRestart){
            computer.generateNewNumbers();
        }

        return userRestart;
    }
}
