package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while( true ) {
            // 컴퓨터의 랜덤 입력값
            Map<Integer, Integer> computerMap = new HashMap<>();

            int randomValue = 100;
            while ( computerMap.size() < 3 ) {

                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerMap.containsKey(randomNumber)) {

                    computerMap.put(randomNumber,randomValue);
                    randomValue /= 10;
                }
            }

            try{
                boolean onGame = true;
                while ( onGame ) {

                    System.out.print("숫자를 입력해주세요 : ");
                    int userInput =  Integer.parseInt( Console.readLine() );

                    if ( isValidInput( userInput ) ){ // 겹치지 않는 3자리 숫자인지 확인
                        int strike = 0;
                        int ball = 0;

                        Map<Integer, Integer> map = splitNum( userInput ); // 사용자 입력값을 자릿수에 따라 Map 에 (숫자, 자릿수)형태로 담는다. ( ex. 123 -> {(1, 100), (2, 10), (3, 1)} )

                        for ( Integer computerKey : computerMap.keySet() ) {

                            if ( map.containsKey(computerKey) ) { // 동일한 숫자(key)가 있는지 확인

                                if ( map.get( computerKey ).equals( computerMap.get(computerKey) )) { // 동일한 숫자의 자릿수(value) 확인

                                    strike++;

                                } else {

                                    ball++;
                                }
                            }
                        }
                        String result = (strike > 0 ? strike + "스트라이크 " : "") + (ball > 0 ? ball + "볼 " : "") + (strike == 0 && ball == 0 ? "낫싱" : "");
                        System.out.println(result);

                        if ( strike == 3 ) {
                            // 3스트라이크 경우 게임 종료
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            onGame = false;
                        }
                    } else {
                        // 겹치는 숫자가 있거나 1~9 이외의 입력값인 경우
                        throw new IllegalArgumentException("Wrong Input Number! Please restart program.");
                    }

                }
                // 3스트라이크로 게입 종료 후, 재시작 여부
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restartInput =  Integer.parseInt( Console.readLine() );

                if ( restartInput == 2 ) {

                    return;
                } else if( restartInput != 1 ) {

                    throw new IllegalArgumentException("Wrong Input Number! Please restart program.");
                }
            } catch ( Exception e ) {

                System.out.println("Wrong Input Number! Please restart program.");
                return;
            }
        }
    }

    public static Map<Integer, Integer> splitNum(  Integer  number ) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        int first  = number / 100;
        int second = (number / 10) % 10;
        int third = number % 10;

        resultMap.put( first, 100 );
        resultMap.put( second, 10 );
        resultMap.put( third, 1 );

        return resultMap;
    }

    public static boolean isValidInput(int number) {
        if ( number >= 123 && number <= 987 ) {
            int a = number / 100;
            int b = (number / 10) % 10;
            int c = number % 10;

            return a != b && b != c && a != c;
        }
        return false;
    }
}