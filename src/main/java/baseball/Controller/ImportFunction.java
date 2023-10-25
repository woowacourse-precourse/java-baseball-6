package baseball.Controller;

import baseball.Model.DataOfGame;
import baseball.View.InputView;
import baseball.View.OutputView;

public class ImportFunction {
    public void init(){
        GameStart gamestart = new GameStart();
        InputView inputview = new InputView();
        GameFunction gamefunction = new GameFunction();
        DataOfGame dataofgame = new DataOfGame();
        OutputView outputview = new OutputView();
        
        boolean end = true;

        outputview.startMsg();
        while(end){
            String comnum = gamestart.randomNum();
            dataofgame.setCom(comnum);
            System.out.println(dataofgame.getCom());
            inputview.inputMsg();
            
            
            String num = gamefunction.inputUserNum();
            dataofgame.setUser(num);
            
            gamefunction.compareString(dataofgame.getCom(), dataofgame.getUser());

            outputview.endMsg();
            inputview.branchMsg();
            String branch = gamefunction.inputUserNum();
            end = gamefunction.branchChoice(branch);
        }
    }
}
