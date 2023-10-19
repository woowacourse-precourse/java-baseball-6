package baseball.controller;

import baseball.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.constant.NumberConstant.*;

public class BaseballController {

    public void run(){

    }

    public List<Integer> getAnswerNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
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
