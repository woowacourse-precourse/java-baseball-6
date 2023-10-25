package baseball.util;

import baseball.Model.CountModel;
import baseball.Model.NumberModel;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    public static CountModel baseballCount(NumberModel number, NumberModel computer){
        int strike = strikeCount(number, computer);
        int ball = ballCount(number, computer);
        return new CountModel(strike,ball);
    }

    public static int strikeCount(NumberModel number, NumberModel computer){
        int cnt = 0;
        if(number.getFirstNumber() == computer.getFirstNumber())
            cnt++;
        if(number.getSecondNumber() == computer.getSecondNumber())
            cnt++;
        if(number.getThirdNumber() == computer.getThirdNumber())
            cnt++;
        return cnt;
    }

    public static int ballCount(NumberModel number, NumberModel computer){
        int cnt = 0;
        List<Integer> numberList = makeNumberList(computer);
        if(number.getFirstNumber() != computer.getFirstNumber() && numberList.contains(number.getFirstNumber()))
            cnt++;
        if(number.getSecondNumber() != computer.getSecondNumber() && numberList.contains(number.getSecondNumber()))
            cnt++;
        if(number.getThirdNumber() != computer.getThirdNumber() && numberList.contains(number.getThirdNumber()))
            cnt++;
        return cnt;
    }

    private static List<Integer> makeNumberList(NumberModel numberModel){
        List<Integer> numberList = new ArrayList<>();
        numberList.add(numberModel.getFirstNumber());
        numberList.add(numberModel.getSecondNumber());
        numberList.add(numberModel.getThirdNumber());

        return numberList;
    }
}
