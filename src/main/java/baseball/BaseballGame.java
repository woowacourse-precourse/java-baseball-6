package baseball;

import java.util.ArrayList;

public class BaseballGame {
    private Player player;
    private Rule rule;
    private BaseballNumber baseballNumber;
    private boolean isVictory;
    private boolean isGameOver;

    public BaseballGame(){
        this.player = new Player();
        this.rule = new Rule();
        this.baseballNumber = new BaseballNumber();
        this.isVictory = false;
        this.isGameOver =false;
    }

    //게임 전체 진행
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(!isGameOver){
            playRound();
            isGameOver = isPlayQuit();
        }
        System.out.println("숫자 야구 게임이 종료되었습니다.");
    }

    //한 라운드 진행
    public void playRound(){
        ArrayList<Integer> correctNumbers = baseballNumber.generateCorrectNumbers();
        isVictory = false;

        while(true) {
            System.out.print("숫자를 입력해주세요: ");
            ArrayList<Integer> playerInputNumbers = player.outputPlayerNumbers();
            //정답 여부 판정
            isVictory = rule.judgeGuess(playerInputNumbers, correctNumbers);
            //예측 결과 출력
            rule.printGuess();

            if (isVictory) {
                break;
            }
        }
    }

    //게임 종료 여부 결정
    public boolean isPlayQuit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInputQuitInt = player.outputPlayerIsQuit();
        if(playerInputQuitInt==2){
            return true;
        }
        return false;
    }
}
