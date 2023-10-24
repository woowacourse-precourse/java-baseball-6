package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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

}
