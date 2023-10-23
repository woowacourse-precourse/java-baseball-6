package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerNumber {
    private static final int CNT_NUM = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;


    private List<Integer> randomNum;

    // 컴퓨터 랜덤 숫자 생성
    private int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    // 생성된 랜덤 숫자 조합
    public void mixRandomNum() {
        Set<Integer> randomNumSet = new HashSet<>();

        while(randomNumSet.size()<CNT_NUM) {
            randomNumSet.add(getRandomNum());
        }

        randomNum = new ArrayList<>(randomNumSet);
    }


}
