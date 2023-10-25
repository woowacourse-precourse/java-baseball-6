package baseball.domain;

import java.util.ArrayList;

import baseball.utils.RandomUtil;

public class Computer {
    public static ArrayList<Integer> createComputerNumbers(int digits, int start, int end){
        return RandomUtil.getRandomNumber(digits, start, end);
    }
}