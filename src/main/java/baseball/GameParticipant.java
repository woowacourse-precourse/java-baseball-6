package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;


public class GameParticipant {
    private String playerGuessedNumber;
    private GameStatus playerStatus;
    private GameManager game;

    public GameParticipant(){
        this.playerStatus = GameStatus.PLAYING;
        this.game = new GameManager();
    }
    public GameStatus playGameByRequest(){
        while(playerStatus == GameStatus.PLAYING){
            System.out.print("숫자를 입력해주세요 :");
            this.playerGuessedNumber = Console.readLine();
            playerStatus = this.game.processTurn(this.playerGuessedNumber);    // 게임을 진행시킴
        }
        System.out.print("다시 플레이? : ");
        String replay = Console.readLine();
        if (Objects.equals(replay, "1")){
            playerStatus = GameStatus.PLAYING;
        }else if(Objects.equals(replay, "2")){
            playerStatus = GameStatus.STOP;
        }else{
            throw new IllegalArgumentException();
        }
        return playerStatus;
    }
}
