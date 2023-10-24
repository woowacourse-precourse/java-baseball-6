package baseball.controller;

import baseball.domain.AnswerNumbers;
import baseball.validation.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static baseball.constant.NumberConstant.*;

public class BaseballController {

    private static int RESTART = 1;
    private static int FINISH = 2;

    private InputView inputView;
    private OutputView outputView;
    private Validator validator;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator = new Validator();
    }

    public void run() {

        boolean isRestart = true;
        AnswerNumbers answerNumbers = null;

        outputView.start();

        while (true) {
            answerNumbers = getNewAnswerNumbers(isRestart, answerNumbers);

            String input = inputView.input();
            List<Integer> inputNumbers = mapToInListInteger(input);

            validator.validateThreeNumber(input);
            validator.validateDuplicate(inputNumbers);

            Map<Integer, Integer> result = answerNumbers.getBallNStrkie(inputNumbers);
            outputView.printResult(result.get(BALL), result.get(STRIKE));

            if (result.get(STRIKE) == SUCCESS_NUMBER) {
                String inputFinish = inputView.finish();

                validator.validate1Or2(inputFinish);

                if (Integer.parseInt(inputFinish) == RESTART) {
                    isRestart = true;
                    continue;
                }
                return;
            }
            isRestart = false;
        }

    }

    private AnswerNumbers getNewAnswerNumbers(boolean isRestart, AnswerNumbers answerNumbers) {
        if (isRestart) {
            answerNumbers = new AnswerNumbers(getAnswerNumbers());
        }
        return answerNumbers;
    }

    public List<Integer> getAnswerNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < VALID_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> mapToInListInteger(String str) {
        return Arrays.stream(str.split(""))
                .mapToInt(x -> Integer.parseInt(x))
                .boxed()
                .collect(Collectors.toList());
    }


}
