package baseball.repository;

import java.util.Map;
import java.util.TreeMap;
public class ComputerRepository {
    private Map<Integer,Integer> answerMap = new TreeMap<>();


    public Map<Integer, Integer> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<Integer, Integer> answerMap) {
        this.answerMap = answerMap;
    }
}
