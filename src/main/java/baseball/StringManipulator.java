package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringManipulator {
    public static List<Integer> strToArrayList(String input){
        List<Integer> threeNumList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            threeNumList.add(digit);
        }
        return threeNumList;
    }
    public static boolean hasDuplicates(String input) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!characterSet.add(c)) {
                return true;
            }
        }
        return false;
    }
}
