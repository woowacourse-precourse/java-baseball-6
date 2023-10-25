package domain.baseBalls;

import java.util.List;

import generator.GameNumbersGenerator;

public class AnswerBaseBalls extends BaseBalls{
    private AnswerBaseBalls(List<Integer> numbers){
        super(numbers);
    }

    public static AnswerBaseBalls ofGenerator(GameNumbersGenerator generator){
        return new AnswerBaseBalls(generator.getGeneratedNumbers());
    }
}