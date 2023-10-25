package generator;

import static domain.BaseBallNumber.*;
import static gameRunner.BaseBallGame.*;

import java.util.*;

public class RandomGameNumbersGenerator implements GameNumbersGenerator{
    priavte List <Integer> numberList=new ArraryList();

    public RandomGameNumbersGenerator(){
        this.numberList=IntStream.range(MIN_NUM, MAX_NUM)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getGeneratedNumbers(){
        collections.shuffle(this.numberList);
        return this.numberList.subList(0, GAME_NUMBERS_SIZE);
    }
}