package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputReOrEnd {
    /**
     * 사용자가 게임을 재시작할지 종료할지를 코인을 넣는다는 것으로 표현해봄
     * 코인을 입력하는 기능 구현
     */
    public int inputCoin(){
        String tmp = Console.readLine();
        int coin = Integer.parseInt(tmp);

        return coin;
    }
}
