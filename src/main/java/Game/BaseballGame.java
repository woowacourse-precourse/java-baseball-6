package Game;

import java.util.List;


public class BaseballGame {

    public static final int MAX_LENGTH = 3;
    PrintManager pm;
    public ScanManager sm;
    Computer computer;
    Player player;
    int[] ballStrike;
    boolean isWin;

    public BaseballGame(){
        pm = new PrintManager();
        sm = new ScanManager();
        computer = new Computer();
        player = new Player();
        ballStrike = new int[2];
        isWin = false;
    }

    public void play(){
        pm.printStartGame();
        try{
            do{
                pm.printScanRequire();
                player.setList(sm.getDigitAsList());
                ballStrike = countBallStrike(computer.getList(), player.getList());
                pm.printResult(ballStrike[0], ballStrike[1]);
                if(ballStrike[1] == 3){
                    isWin = true;
                }
            }
            while (!isWin);
            pm.printWin();
        }
        catch (IllegalArgumentException e){
            throw e;
        }

    }

    public int[] countBallStrike(List<Integer> player, List<Integer> computer){
        int[] ballStrike = new int[2];

        for (int i = 0; i < MAX_LENGTH; i++){
            for (int j = 0; j < MAX_LENGTH; j++){
                if(player.get(i) == computer.get(j)){
                    if(i == j){
                        ballStrike[1]++;
                    }
                    else{
                        ballStrike[0]++;
                    }
                }
            }
        }


        return ballStrike;
    }
}
