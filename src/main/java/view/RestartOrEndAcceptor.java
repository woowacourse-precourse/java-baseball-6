package view;

import camp.nextstep.edu.missionutils.Console;

public class RestartOrEndAcceptor {
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
