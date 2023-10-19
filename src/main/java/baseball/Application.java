package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    private static int playDecision = 0;
    private static int strike =0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            play();
        }while (playDecision==1);
    }

    private static void play() {
        while (true){
            ArrayList<Integer> computerAnswer = getComputerAnswer();
        }
    }

    private static ArrayList<Integer> getComputerAnswer() {
        ArrayList<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerAnswer.contains(randomNumber)){
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }
}
