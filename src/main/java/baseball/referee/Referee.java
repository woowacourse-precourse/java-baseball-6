package baseball.referee;

import baseball.computer.Computer;
import baseball.player.Player;

import java.util.Objects;

public class Referee {
    Player player = new Player();
    Computer computer = new Computer();

    private int strike, ball;
    private boolean restart;

    public Referee() {
        startGame();
        setRestart(true);
    }
    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    public boolean getRestart() {
        return restart;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.makeRandomNumber();
    }
    public void askNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        player.askNumber();
    }
    public void askRestart() {
        if(!Objects.equals(player.askRestart(), "1")){
            setRestart(false);
            return;
        }
        startGame();
    }
    public void endGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        askRestart();
    }

    public void compareNumber(){
        String playerNumber = player.getNumber();
        String computerNumber = computer.getNumber();
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < computerNumber.length(); i++){
            for(int j = 0; j < playerNumber.length(); j++){
                if(computerNumber.charAt(i) == playerNumber.charAt(j)){
                    if(i == j){
                        strike++;
                    }else {
                        ball++;
                    }
                }
            }
        }
        setStrike(strike);
        setBall(ball);
    }

    public void getResult() {
        int ball = getBall();
        int strike = getStrike();

        if(strike == 3) {
            endGame();
            return;
        }

        if(ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if(strike > 0){
            System.out.print(strike + "스트라이크");
        }
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
