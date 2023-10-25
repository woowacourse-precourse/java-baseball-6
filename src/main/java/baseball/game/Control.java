package baseball.game;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.GameMessage;

import java.util.ArrayList;

public class Control {
    private static final int DIGITS = 3;
    private static final int START_NUM = 1;
    private static final int LAST_NUM = 9;
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
    private void startGame(){
        initComputerNumbers();

        do {
            loadPlayerNumbers();
            assessMatchStatus();
        }while(setting.isNotAllStrike());
    }
    private boolean isEndDecision(){
        return player.inputEndDecision() == 1;
    }
    private void initComputerNumbers(){
        computerNumbers = Computer.createComputerNumbers(DIGITS,START_NUM,LAST_NUM);
    }
    private void loadPlayerNumbers(){
        playerNumbers = player.getPlayerNumbers(DIGITS);
    }
    private void assessMatchStatus(){
        setting.loadCorrectStatus(computerNumbers, playerNumbers);
    }
}
