package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Balls {

    private static final Integer BALLS_SIZE=3;
    private List<Integer> balls;

    public Balls(List<Integer> balls){

        validateSize(balls);
        validateDuplication(balls);
        this.balls=balls;
    }


    private void validateDuplication(List<Integer> balls){
        Set<Integer> nonDuplicatedNumber= new HashSet<>();
        Stream<Integer> stream=balls.stream();
        stream.forEach(ball->nonDuplicatedNumber.add(ball));
        if(nonDuplicatedNumber.size()!=BALLS_SIZE){
            throw new IllegalArgumentException("중복된 값을 입력하였습니다.");
        }
    }

    public void validateSize(List<Integer> balls){
        if(balls.size()!=BALLS_SIZE){
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
    }

    public List<Integer> getBalls(){
        return balls;
    }
}
