package baseball.service;

import java.util.List;

public class ScoreService {

    public Integer getStrikes(List<Integer> answer, List<Integer> userInput) {
        return Math.toIntExact(userInput.stream()
                .filter((input) ->
                        answer.contains(input) && (answer.indexOf(input) == userInput.indexOf(input)))
                .count());
    }

    public Integer getBalls(List<Integer> answer, List<Integer> userInput) {
        return Math.toIntExact(userInput.stream()
                .filter((input) ->
                        answer.contains(input) && (answer.indexOf(input) != userInput.indexOf(input)))
                .count());
    }
}
