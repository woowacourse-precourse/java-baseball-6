package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerValue;
    private final DataValidator dataValidator;

    public Player() {
        this.playerValue = new ArrayList<Integer>();
        this.dataValidator = new DataValidator();
    }

    public ArrayList<Integer> getPlayerValue() {
        System.out.print("숫자를 입력해주세요 : ");
        ArrayList<Integer> playerValue = new ArrayList<>();
        String[] stringValue  = Console.readLine().split("");
        for(String s : stringValue){
            playerValue.add(Integer.parseInt(s));
        }
        dataValidator.playerValueValidation(playerValue);

        return playerValue;
    }
}
