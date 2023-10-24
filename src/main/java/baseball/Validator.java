package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public boolean validateUserNum(String userNums) {
        return isRightLen(userNums) && isDigit(userNums)
                && isRightRange(userNums)
                && isNotDuplicate(userNums);
    }


    public boolean isRightLen(String userNums) {
        if (userNums.length() == 3) {
            return true;
        }
        return false;
    }

    public boolean isDigit(String userNums) {
        for (int i=0; i<3; i++) {
            if (!Character.isDigit(userNums.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public boolean isRightRange(String userNums) {
        for (int i=0; i<3; i++) {
            int num = Integer.parseInt(userNums.substring(i, i+1));
            if (num < 1 || num > 9) {
                return false;

            }
        }
        return true;
    }

    public boolean isNotDuplicate(String userNums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i=0; i<3; i++) {
            int num = Integer.parseInt(userNums.substring(i, i+1));
            numSet.add(num);
        }
        if (numSet.size() == 3) {
            return true;
        } else {
            return false;
        }

    }

}
