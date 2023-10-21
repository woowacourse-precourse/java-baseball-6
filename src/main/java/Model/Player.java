package Model;

import Constant.Ment;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

public class Player {
    static private ArrayList<Integer> PlayerNumbers;
    static private String Tempnumbers;

    public ArrayList<Integer> InputNumbers() {
        PlayerNumbers = new ArrayList<>();
        System.out.printf(Ment.getMentInput());
        Tempnumbers = readLine();
        for (int i = 0; i < 3; i++) {
            PlayerNumbers.add(Character.getNumericValue(Tempnumbers.charAt(i)));
        }
        return PlayerNumbers;
    }
}
