package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBallGame extends Game {
    private static final String REGEX_THREE_NUMBER = "^[1-9]{3}"; // 3개의 1에서 9까지 수

    @Override
    public boolean initGame() {
        return true;
    }

    @Override
    public void playGame() {
        List<Integer> computer = selectComputerNumber();
        List<Integer> user = null;
        do {
            user = inputNumber();
        } while (compareNumber(computer, user));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean compareNumber(List<Integer> computer, List<Integer> user){
        int strikeNumber = 0;
        int ballNumber = 0;

        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i).equals(user.get(i))){
                strikeNumber++;
            }
            if(computer.contains(user.get(i))){
                ballNumber++;
            }
        }
        ballNumber -= strikeNumber;
        printStatus(ballNumber, strikeNumber);

        return strikeNumber != 3;
    }

    private void printStatus(int strikeNumber, int ballNumber){
        if(ballNumber == 0 && strikeNumber == 0){
            System.out.println(("낫싱"));
        }
        if(ballNumber != 0 && strikeNumber == 0){
            System.out.printf("%d볼", ballNumber).println();
        }
        if(ballNumber == 0 && strikeNumber != 0){
            System.out.printf("%d스트라이크", strikeNumber).println();
        }
        if(ballNumber != 0 && strikeNumber != 0){
            System.out.printf("%d볼 %d스트라이크", ballNumber, strikeNumber).println();
        }
    }

}
