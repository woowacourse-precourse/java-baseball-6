package baseball;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private Map<Integer, Integer> numberMap;

    public Player() { this.numberMap = new HashMap<>(); }
    /*
     * 사용자 입력값을 자릿수에 따라 Map 에 (숫자, 자릿수)형태로 담는다.
     * ex. 123 -> {(1, 100), (2, 10), (3, 1)}
     */
    public Map<Integer, Integer> makePlayerMap( Integer  number ) {
        if ( numberMap == null ) {
            numberMap = new HashMap<>();
        }

        int first  = number / 100;
        int second = (number / 10) % 10;
        int third = number % 10;

        numberMap.put( first, 100 );
        numberMap.put( second, 10 );
        numberMap.put( third, 1 );

        return numberMap;
    }
}
