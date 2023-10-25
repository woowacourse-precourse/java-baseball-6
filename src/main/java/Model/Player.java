package Model;

import Constant.ExceptionHandling;

import java.util.ArrayList;

public class Player {
    static private ArrayList<Integer> PlayerNumbers;

    public ArrayList<Integer> GuessNumbers(String Tempnumbers) {
        PlayerNumbers = new ArrayList<>();
        for (int i = 0; i < Tempnumbers.length(); i++) {
            PlayerNumbers.add(Character.getNumericValue(Tempnumbers.charAt(i)));
        }

        return PlayerNumbers;
    }
}
