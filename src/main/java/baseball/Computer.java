package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> makeAnswerList() {
        AnswerRandomList answerRandomList = new AnswerRandomList(new ArrayList<>());
        return answerRandomList.generateThreeRandomNumber();
    }

}