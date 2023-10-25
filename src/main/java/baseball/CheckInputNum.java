package baseball;

import java.util.Map;

public class CheckInputNum {

    private int strike;
    private int ball;

    public CheckInputNum() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() { return strike; }
    public int getBall() { return ball; }

    public void checkPlayerNum(Map<Integer, Integer> computerMap, Map<Integer, Integer> playerMap) {

        for ( Integer computerKey : computerMap.keySet() ) {

            if ( playerMap.containsKey( computerKey ) ) { // 동일한 숫자(key)가 있는지 확인

                int userValueByComputerKey = playerMap.get( computerKey );
                int computerValue = computerMap.get( computerKey );

                if ( userValueByComputerKey == computerValue ) { // 동일한 숫자의 자릿수(value) 확인
                    strike++;
                }
                if ( userValueByComputerKey != computerValue ) {
                    ball++;
                }
            }
        }
    }
}
