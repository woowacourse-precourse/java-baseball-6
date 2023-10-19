package baseball.controller;

import baseball.constant.NumberConstant;
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

    public void run(){

        inputView.start();
        boolean isFirstTime = true;
        AnswerNumbers answerNumbers = null;
        while(true){


            if(isFirstTime){
                answerNumbers = new AnswerNumbers(getAnswerNumbers());
            }

            String input = inputView.input();

            validator.validateThreeNumber(input);

            List<Integer> inputNumbers = mapToInListInteger(input);

            validator.validateDuplicate(inputNumbers);

            Map<Integer, Integer> result = answerNumbers.getBallNStrkie(inputNumbers);

            outputView.printResult(result.get(BALL), result.get(STRIKE));

            if(result.get(STRIKE) == SUCCESS_NUMBER){
                int finishNum = Integer.parseInt(inputView.finish());

                if(finishNum == RESTART){
                    isFirstTime = true;
                    continue;
                }
                return;
            }

            isFirstTime = false;
        }

    }

    public List<Integer> getAnswerNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        for(Integer i : numbers){
            System.out.print(i + " ");
        }

        return numbers;
    }

    public List<Integer> mapToInListInteger(String str){
        return Arrays.stream(str.split(""))
                .mapToInt(x -> Integer.parseInt(x))
                .boxed()
                .collect(Collectors.toList());
    }











}
