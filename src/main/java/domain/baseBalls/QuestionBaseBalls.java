package domain.baseBalls;

import java.util.*;
import domain.OneBaseBall;
import lombok.Getter;

public class QuestionBaseBalls extends BaseBalls{
    private QuestionBaseBalls(List<Integer> numbers){
        super(numbers);
    }

    public static QuestionBaseBalls ofManual(List<Integer> numbers){
        return new QuestionBaseBalls(numbers);
    }

    public Result getCalculateResult(AnswerBaseBalls answerBaseBalls){
        return new Result(answerBaseBalls);
    }

    private boolean strike(OneBaseBall answerOneBaseBall){
        Optional<OneBaseBall> baseBall=getBaseBalls().stream()
                .filter(question -> question.equalStrike(answerOneBaseBall))
                .findFirst();
        baseBall.ifPresent(qu->this.getBaseBalls().remove(qu));
        return baseBall.isPresent();
    }

    private boolean ball(OneBaseBall answerOneBaseBall){
        Optional<OneBaseBall> baseBall=getBaseBalls().stream()
                .filter(question -> question.equalBall(answerOneBaseBall))
                .findFirst();
        baseBall.ifPresent(qu->this.getBaseBalls().remove(qu));
        return baseBall.isPresent();
    }

    private Integer calculateStrikeNumber(AnswerBaseBalls answerBaseBalls){
        long count=answerBaseBalls.getBaseBalls().stream()
                .filter(this::strike)
                .count();
        return (int)count;
    }

    private Integer calculateBallNumber(AnswerBaseBalls answerBaseBalls){
        long count=answerBaseBalls.getBaseBalls().stream()
                .filter(this::ball)
                .count();
        return (int)count;
    }

    @Getter
    public class Result{
        private Integer ball;
        private Integer strike;

        Result(AnswerBaseBalls answerBaseBalls){
            this.strike=calculateStrikeNumber(answerBaseBalls);
            this.ball=calculateBallNumber(answerBaseBalls);
        }

        public boolean hasStrike(){
            return this.strike!=0;
        }

        public boolean hasBall(){
            return this.ball!=0;
        }
    }
}