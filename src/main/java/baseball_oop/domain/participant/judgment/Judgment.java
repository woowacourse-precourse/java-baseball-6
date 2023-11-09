package baseball_oop.domain.participant.judgment;

import baseball_oop.vo.Answer;
import baseball_oop.vo.Result;

public interface Judgment {
    Result judge(Answer answer, Answer input);
}
