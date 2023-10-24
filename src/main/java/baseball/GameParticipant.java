package baseball;

import camp.nextstep.edu.missionutils.Console;


public class GameParticipant {
    private String playerGuessedNumber;
    private GameStatus playerStatus;
    private GameManager game;

    public GameParticipant(){
        this.playerStatus = GameStatus.PLAYING;
        this.game = new GameManager();
    }
    public void playGameByRequest(){
        while(playerStatus == GameStatus.PLAYING){
            System.out.print("숫자를 입력해주세요 :");
            this.playerGuessedNumber = Console.readLine();
            this.game.processTurn(this.playerGuessedNumber);    // 게임을 진행시킴
        }
    }
}
