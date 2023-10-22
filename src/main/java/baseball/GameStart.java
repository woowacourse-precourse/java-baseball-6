package baseball;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

    private User user = new User();
    private inputView inputView = new inputView();
    private Count count = new Count();

    private Computer computer = new Computer();
    private List<Integer> BallandStrike= new ArrayList<>();
    private ResultView resultView= new ResultView();
    private GameStatus gameStatus = new GameStatus();


    public void start()
    {
        while(gameStatus.getIsGameOnGoing()) {

            System.out.println(gameStatus.getIsGameOnGoing());
            computer.setComputerNumber();
            System.out.println(computer.getComputerNumber());
            user.setUserNumber(inputView.userInput());
            System.out.println(computer.getComputerNumber());
            BallandStrike = count.CountcountBallsAndStrikes(user.getUserNumber(), computer.getComputerNumber());
            getResultView(BallandStrike);


        }

    }

    public void getResultView(List<Integer> BallandStrike)
    {
        if(BallandStrike.get(1)==3)
        {
            resultView.ThreeStrike();
            gameStatus.threeStrikeCase();
        }
        if(BallandStrike.get(1)!=3)
        {
            resultView.printEndMessage(BallandStrike);

        }

    }



}
