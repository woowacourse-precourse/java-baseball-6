package baseball;

import java.util.Arrays;
import java.util.List;

public class Judger {
    private int[] score;

    public Judger() {
        this.score = new int[3];
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void compareNumbers(List<Integer> human, List<Integer> computer) {
        int[] strikeIdx = checkStrike(human, computer);
    }

    private int[] checkStrike(List<Integer> human, List<Integer> computer){
        int[] strikeIdx = new int[3];

        for(int i = 0; i < 3; i++) {
            if(human.get(i).equals(computer.get(i))){
                this.score[0] += 1;
                strikeIdx[i] = 1;
            }
        }

        return strikeIdx;
    }
}
