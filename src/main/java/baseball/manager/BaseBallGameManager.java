package baseball.manager;

import baseball.application.BaseBallGame;
import baseball.controller.BaseBallGameController;
import baseball.controller.Game;
import baseball.domain.BaseBallNumberList;
import baseball.ui.InputUserInterface;
import baseball.ui.OutputUserInterface;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGameManager implements GameManager {

    private final InputUserInterface inputUI;
    private final OutputUserInterface outputUI;
    private boolean exit;

    public BaseBallGameManager(InputUserInterface inputUI, OutputUserInterface outputUI) {
        this.inputUI = inputUI;
        this.outputUI = outputUI;
    }

    @Override
    public void execute() {
        exit=false;
        Game game = new BaseBallGameController(
                new BaseBallGame(new BaseBallNumberList(pickUniqueNumbersInRange(1,9,3)
                        ),
                        this));

        outputUI.print(GameOutputTemplate.FIRST_START.toString());
        while (!exit){
            outputUI.print(GameOutputTemplate.INPUT.toString());
            outputUI.print(game.play(inputUI.intercept())+"\n");
        }

        outputUI.print(GameOutputTemplate.EXIT.toString());
        outputUI.print(GameOutputTemplate.REPLAY.toString());
        Command command=new Command(inputUI.intercept());
        if(command.replay()){
            execute();
        }
    }

    private List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
        ArrayList<Integer> list = new ArrayList<>();
        while (count>0){
            int pick = Randoms.pickNumberInRange(start, end);
            if(!list.contains(pick)){
                list.add(pick);
                count--;
            }
        }
        return list;
    }

    @Override
    public void exit() {
        exit=true;
    }
}
