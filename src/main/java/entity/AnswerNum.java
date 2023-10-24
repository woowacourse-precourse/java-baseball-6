package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerNum {
    private final List<Integer> answerNum = new ArrayList<>();

    public AnswerNum(String answer) {

        validateSize(answer);
        validateType(answer);

        for (int i = 0; i < 3; i++) {
            answerNum.add(answer.charAt(i) - '0');
        }
        validateDuplcate();
    }

    public void validateSize(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateType(String answer) {
        if (!answer.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
    public void validateDuplcate(){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(answerNum);
        if(nonDuplicateNumbers.size() != answerNum.size()){
            throw new IllegalArgumentException();
        }
    }
        public List<Integer> getAnswerNum () {
            return answerNum;
        }
}