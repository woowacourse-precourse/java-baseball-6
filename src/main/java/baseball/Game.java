package baseball;

import java.util.ArrayList;

public class Game {

    private final Player player;
    private final Computer computer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    void run(){
        while (true){
            System.out.println("숫자 야구 게임을 시작합니다");
            ArrayList<Integer> computerAnswer = settingNewGame();
            start(computerAnswer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(player.getContinueDecision()==2)
                break;
        }
    }

    private ArrayList<Integer> settingNewGame(){
        return computer.getComputerAnswer();
    }
    void start(ArrayList<Integer> computerAnswer){
       while (score.getStrike!=3){
           System.out.println("숫자를 입력해주세요 : ");
           ArrayList<Integer> playerAnswer=player.getNewAnswer();
           gameProcessor.updateScore(playerAnswer,computerAnswer);
           gameProcessor.printScore();
       }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }




}
