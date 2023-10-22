package baseball.service;

import baseball.Util.Validator;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final Validator validator;
    private Boolean isGameEnd;

    public GameService(Validator validator) {
        this.validator = validator;
        this.isGameEnd = false;
    }


    public void init() {
        this.isGameEnd = false;
    }

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    //TODO: createAnswer와 유사한 부분이 많으므로 하나의 메서드로 묶을 수 있을 듯!
    public List<Integer> getInput() {
        List<Integer> userInput = new ArrayList<>();
        while (userInput.size() < 3) {
            Integer input = validator.validateRange(Console.readLine());
            if (!userInput.contains(input)) {
                userInput.add(input);
            }
        }
        return userInput;
    }


    public Result compare(List<Integer> answer, List<Integer> userInput) {
        return new Result(getStrikes(answer, userInput), getBalls(answer, userInput));
    }

    private Integer getStrikes(List<Integer> answer, List<Integer> userInput) {
        return Math.toIntExact(userInput.stream()
                .filter((input) ->
                        answer.contains(input) && (answer.indexOf(input) == userInput.indexOf(input)))
                .count());
    }

    private Integer getBalls(List<Integer> answer, List<Integer> userInput) {
        return Math.toIntExact(userInput.stream()
                .filter((input) ->
                        answer.contains(input) && (answer.indexOf(input) != userInput.indexOf(input)))
                .count());
    }


    public boolean isWin(Result result) {
        return false;
    }

    public boolean isGameEnd() {
        return false;
    }

    public void setGameEnd() {

    }
}
