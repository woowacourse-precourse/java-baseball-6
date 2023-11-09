package baseball_oop.domain.participant.judgment;

import baseball_oop.vo.Answer;
import baseball_oop.vo.Result;

public class Umpire implements Judgment {
    @Override
    public Result judge(Answer answer, Answer input) {
        int strikeCount = Answer.countSameElementAndPosition(answer.getValues(), input.getValues());
        int ballCount = Answer.countContainElement(answer.getValues(), input.getValues()) - strikeCount;

        return new Result(strikeCount, ballCount);
    }

}
