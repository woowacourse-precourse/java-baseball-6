package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class BaseballGameModel {

    private List<Integer> computerNums = new ArrayList<>(); //컴퓨터 랜덤 넘버 생성

    public BaseballGameModel(){
        generateRandomNums();
    }

    /**
     * TODO 2: 컴퓨터가 임의의 수 3개를 선택하는 기능 구현
     *
     * 컴퓨터가 1~9까지의 임의의 숫자를 생성하는 메서드입니다.
     * */
    public void generateRandomNums(){
        while (computerNums.size() < 3){
            int randomNums = Randoms.pickNumberInRange(1, 9);
            if(!computerNums.contains(randomNums)){
                computerNums.add(randomNums);
            }
        }
    }

    public List<Integer> getComputerNums(){
        return computerNums;
    }

    /**
     * 1. 힌트 기능 구현
     *
     * @param userGuessNums
     * @return result[0] - strike / result[1] - ball
     * */
    public int[] guess(List<Integer> userGuessNums){
        int strikeCount = strikeCounter(userGuessNums);
        int ballCount = ballCounter(userGuessNums);

        return new int[]{strikeCount, ballCount};

    }

    /**
     * 1. 힌트 기능 구현
     * TODO 1-1: 스트라이크 개수를 세는 메서드
     *
     * @param userGuessNums 사용자 입력값
     * @return strike 갯수
     * */
    private int strikeCounter(List<Integer> userGuessNums){
        int strike = 0;

        return strike = (int) IntStream.range(0,3)
                .filter(i -> userGuessNums.get(i).equals(computerNums.get(i)))
                .count();

//        for (int i = 0; i < 3; i++){
//            if (userGuessNums.get(i).equals(computerNums.get(i))){
//                strike++;
//            }
//        }

//      return strike;
    }

    /**
     * 1. 힌트 기능 구현
     * TODO 1-2: 볼 개수를 세는 메서드
     *
     * @param userGuessNums 사용자 입력값
     * @return ball 갯수
     * */
    private int ballCounter(List<Integer> userGuessNums){
        int ball = 0;

        return ball = (int)IntStream.range(0,3)
                .filter(i -> !userGuessNums.get(i).equals(computerNums.get(i)) && computerNums.contains(userGuessNums.get(i)))
                .count();

//        for (int i =0; i <3; i++){
//            if (!userGuessNums.get(i).equals(computerNums.get(i)) && computerNums.contains(userGuessNums.get(i))){
//                ball++;
//            }
//        }
//        return ball;
    }




}
