package baseball.service;

import baseball.Util.Validator;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    private final Validator validator;
    private List<Integer> answer;
    private Boolean isGameEnd;


    public GameService(Validator validator) {
        this.validator = validator;
        answer = createAnswer();
        this.isGameEnd = false;
    }


    public void init() {
        this.isGameEnd = false;
        this.answer = createAnswer();
    }

    public Result play() {
        List<Integer> input = getInput();

        return compare(answer, input);
    }

    // TODO: 테스트 코드로 인해 public으로 설정했음 private로 변경 필요
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

    private List<Integer> getInput() {
        String input = Console.readLine();
        List<Integer> inputList = convertToList(input);
        validator.validateInput(inputList);

        return inputList;
    }

    private List<Integer> convertToList(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
    }

    //TODO: 테스트 코드로 인해 public으로 설정했음 private로 변경 필요
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
        return result.getStrike() == 3;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void setGameEnd() {
        this.isGameEnd = true;
    }

    public Integer getCommand() {
        return validator.validateCommand(Console.readLine());
    }
}
