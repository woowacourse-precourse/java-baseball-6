package baseball.repository;

import baseball.domain.Answer;
import baseball.domain.AnswerFactory;

public class BaseballRepository {

    private Answer answer;

    public void createAnswer(){
        AnswerFactory answerFactory = new AnswerFactory();
        answer = answerFactory.createAnswerArray();
    }

    public int[] getAnswer(){
        return answer.getAnswers();
    }

    public boolean[] getNumberVisit(){
        return answer.getVisit();
    }
}