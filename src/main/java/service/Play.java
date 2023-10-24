package service;

import java.util.Iterator;
import java.util.List;
public class Play {
    private int strike = 0;
    private int ball = 0;
    private boolean continueGame = true;
    private List<Integer> computer;
    private List<Integer> human;
    public Play(List<Integer> computer, List<Integer> human) {
        this.computer = computer;
        this.human = human;
    }
    public void startGame() {
        play();
        displayResult();
        if (strike == 3) {
            continueGame = false;
        }
    }

    public void play() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            checkGame(computer.get(i), human.get(i), i, human.indexOf(computer.get(i)));
        }
    }

    private void checkGame(Integer computerNumber, Integer humanNumber, int computerIndex, int humanIndex) {
        if (computerNumber.equals(humanNumber)) {
            strike++;
        } else if (humanIndex != -1) {
            ball++;
        }
    }

    private void displayResult() {

        if(ball!=0 && strike!=0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(ball==0 && strike!=0) {
            System.out.println(strike + "스트라이크");
        }
        if(ball!=0 && strike==0){
            System.out.println(ball + "볼");
        }
        if(ball==0 && strike==0){
            System.out.println("낫싱");
        }
        if (strike == 3) {
            System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isContinue() {
        return continueGame;
    }
}