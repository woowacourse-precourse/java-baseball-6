package baseball.game;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.GameMessage;

import java.util.ArrayList;

public class Control {
    public static final int DIGITS = 3;
    public static final int START_NUM = 1;
    public static final int LAST_NUM = 9;
    private ArrayList<Integer> computerNumbers;
    private ArrayList<Integer> playerNumbers;
    private Setting setting;
    private Player player;

    public void run(){
        setting = new Setting();
        player = new Player();
        GameMessage.printGameStart();

        do{
            startGame();
        }while(isEndDecision());

        System.out.println("게임 종료");
    }
    public void startGame(){
        initComputerNumbers();

        do {
            getPlayerNumbers();
            loadCorrectStatus();
        }while(setting.isNotAllStrike());
    }

    public boolean isEndDecision(){
        return player.inputEndDecision() == 1;
    }

    public void initComputerNumbers(){
        computerNumbers = Computer.createComputerNumbers(DIGITS,START_NUM,LAST_NUM);
        //System.out.println(computerNumbers);
    }

    public void getPlayerNumbers(){
        playerNumbers = player.getPlayerNumbers(DIGITS);
    }

    public void loadCorrectStatus(){
        setting.getCorrectStatus(computerNumbers, playerNumbers);
    }
}
