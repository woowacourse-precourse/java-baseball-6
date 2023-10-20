package baseball.models;

import baseball.gameLogic.RandomNumberGenerator;

import java.util.List;

/*
 Computer의 변수들을 기억하는 클래스
 */

public class Computer {
    public List<Integer> numberList;
    public RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
}
