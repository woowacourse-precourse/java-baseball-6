package baseball.domain;

import java.util.List;

public class BaseBalls {
    private List<BaseBall> numbers;
    private NumberGenerator numberGenerator;

    public BaseBalls(List<BaseBall> numbers){
        this.numbers = numbers;
        validate();
    }

    private void validate(){
        // TODO: (1) 3자리 숫자가 아닌 값을 입력한 경우 예외처리
        //       (2) 3자리 숫자중에 중복되는 숫자가 존재하는 경우 예외처리
    }

    public static BaseBalls getBaseBallNumbers(){
        return new BaseBalls(NumberGenerator.generateAnswerNumbers());
    }
}
