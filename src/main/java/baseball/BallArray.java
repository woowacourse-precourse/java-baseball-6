package basball;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class BallArray{
    private List<BallArray> numbers;
    public static final int SIZE = 3;

    public BallArray(List<BallArray> numbers){
        validate(numbers);
        this.numbers = numbers;

    }

    public static BallArray RandomComputer(){
        List<BallArray> numbers = new ArrayList<>();

        while(numbers.size() < BallArray.SIZE){
            BallArray ballArray = new BallArray(Randoms.pickNumberInRange(1,9));
            if(!ballArray.contains(ballArray)){
                ballArray.add(ballArray);
            }

        }

        return new BallArray(ballArray);
    }

    public static BallArray RandomUser(String input){
        List<BallArray> userRandom = Arrays.stream(input.split(""))
                //TODO

        return new BallArray(userRandom);
    }
}