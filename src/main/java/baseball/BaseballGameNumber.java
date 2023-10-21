package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class BaseballGameNumber {

    private final List<Integer> numbers;

    public BaseballGameNumber() {
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public BaseballGameNumber(String input) {
        numbers = new ArrayList<>();
        int n = Integer.parseInt(input);
        int divisor = 100;
        while (numbers.size() < 3) {
            int quotient = n/divisor;
            numbers.add(quotient);
            n-=quotient*divisor;
            divisor/=10;
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static boolean validateBaseballGameNumber (String input) {
        if(!validateFormat(input) || !validateDuplication(input)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static private boolean validateFormat (String input) {
        return Pattern.matches("^[1-9]{3}",input);
    }

    static private boolean validateDuplication (String input) {
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            for (int j = 0; j < 3; j++) {
                if(i != j && c == input.charAt(j)) return false;
            }
        }
        return true;
    }
}
