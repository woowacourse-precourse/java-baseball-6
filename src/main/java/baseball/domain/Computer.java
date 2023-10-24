package baseball.domain;

import java.util.ArrayList;

import baseball.utils.RandomUtil;

public class Computer {
    public static ArrayList<Integer> createNumber(int digits, int start, int end){
        ArrayList<Integer> numberList = RandomUtil.getRandomNumber(digits, start, end);
        System.out.println(numberList);

        return numberList;
    }
}