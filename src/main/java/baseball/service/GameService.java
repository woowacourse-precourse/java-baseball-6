package baseball.service;

import baseball.Util.Validator;
import baseball.constants.ErrorCode;
import baseball.constants.Baseball;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    private final ScoreService scoreService;
    private final Validator validator;
    private List<Integer> answer;
    private Boolean isRoundEnd;


    public GameService(ScoreService scoreService, Validator validator) {
        this.scoreService = scoreService;
        this.validator = validator;
        answer = createAnswer();
        this.isRoundEnd = false;
    }


    public void init() {
        this.isRoundEnd = false;
        this.answer = createAnswer();
    }

    public Result playRound() {
        List<Integer> input = getInput();
        return getResult(answer, input);
    }

    // TODO: 테스트 코드로 인해 protected으로 설정했음 private로 변경 필요
    protected Result getResult(List<Integer> answer, List<Integer> userInput) {
        return new Result(scoreService.getStrikes(answer, userInput), scoreService.getBalls(answer, userInput));
    }

    // TODO: 테스트 코드로 인해 protected으로 설정했음 private로 변경 필요
    protected List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Baseball.MAX_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(Baseball.MIN_NUMBER.getValue(), Baseball.MAX_NUMBER.getValue());
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
            throw new IllegalArgumentException(ErrorCode.NOT_NUMERIC.toString());
        }
    }

    public boolean isWin(Result result) {
        return result.getStrike() == Baseball.GOAL.getValue();
    }

    public boolean isRoundEnd() {
        return isRoundEnd;
    }

    public void setRoundEnd() {
        this.isRoundEnd = true;
    }

    public Boolean askCommand() {
        Integer command = validator.validateCommand(Console.readLine());
        return command == Baseball.RESTART.getValue();
    }
}
