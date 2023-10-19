package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            ArrayList<Integer> playerValue = getPlayerValue();

        }
    }

    private static ArrayList<Integer> getPlayerValue() {
        ArrayList<Integer> playerValue = new ArrayList<>();
        String[] stringValue  = Console.readLine().split("");
        for(String s : stringValue){
            playerValue.add(Integer.parseInt(s));
        }
        playerValueValidation(playerValue);

        return playerValue;
    }

    private static void playerValueValidation(ArrayList<Integer> playerValue) {
        if(playerValue.size()!=3||playerValue.contains(0)||duplicationCheck(playerValue)==false) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean duplicationCheck(ArrayList<Integer> playerValue) {
        Set<Integer> playerValueSet = new HashSet<>();
        for(int i : playerValue)
            playerValueSet.add(i);

        if(playerValue.size()!=playerValueSet.size())
            return false;

        return true;
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
