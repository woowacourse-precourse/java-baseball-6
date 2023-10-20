package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Computer {
    public static final int RANDOM_MIX_NUMBER = 1;
    public static final int RANDOM_MAX_NUMBER = 9;
    static List<Integer> numbers;
    public Computer(){
        this.numbers = createRandomNumbers();
    }
    public List<Integer> getRandomNumbers() {
        return numbers;
    }

    public static List<Integer> createRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIX_NUMBER, RANDOM_MAX_NUMBER);
            if(!randomNumbers.contains(randomNumber))
                randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
