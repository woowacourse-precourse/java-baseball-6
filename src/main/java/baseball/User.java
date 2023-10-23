package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> number = new ArrayList<>();

    public List<Integer> getNumber() {
        return number;
    }

    public void resetNumber() {
        number.clear();
    }

    public void addNumber(int newNumber) {
        number.add(newNumber);
    }

    public boolean validateNumber(String numberFromUser) {
        //3자리인지
        if (numberFromUser.length() != 3) {
            return false;
        }
        //같은 숫자 없는지, 숫자가 맞는지
        String[] newNumbers = numberFromUser.split("");
        try {
            for (String newNum : newNumbers) {
                if (number.contains(Integer.parseInt(newNum))) {
                    return false;
                }
                addNumber(Integer.parseInt(newNum));
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
