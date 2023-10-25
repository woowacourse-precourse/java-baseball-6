package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Application {

    public static void main(String[] args) {

        System.out.println( PrintMessage.START.getMessage() );

        while( true ) {
            // 컴퓨터의 랜덤 입력값을 map에 담는다.
            Computer computer = new Computer();
            Map<Integer, Integer> computerMap = computer.makeComputerRandomNum();

            try{
                boolean onGame = true;
                while ( onGame ) {

                    System.out.print( PrintMessage.ASK_INPUT.getMessage() );
                    int userInput =  Integer.parseInt( Console.readLine() );

                    if ( ValidInput.isValidInput( userInput ) ){ // 입력된 숫자의 유효성 체크

                        // 사용자의 입력값을 map에 담는다.
                        Player player = new Player();
                        Map<Integer, Integer> playerMap = player.makePlayerMap( userInput );

                        // 사용자의 입력값 확인
                        CheckInputNum checkInput = new CheckInputNum();
                        checkInput.checkPlayerNum( computerMap, playerMap );

                        // 사용자 입력값에 따른 결과 도출
                        String gameResult =  PrintMessage.resultGame( checkInput );
                        System.out.println( gameResult );

                        if ( checkInput.getStrike() == 3 ) {
                            // 3스트라이크 경우 게임 종료
                            System.out.println( PrintMessage.CLEAR.getMessage() );
                            onGame = false;
                        }
                    } else {

                        throw new IllegalArgumentException( PrintMessage.ERROR.getMessage() );
                    }
                }
                // 게입 종료 후, 재시작 여부 체크
                System.out.println( PrintMessage.RESTART.getMessage() );
                int restartInput =  Integer.parseInt( Console.readLine() );

                if ( restartInput == 2 ) {

                    return;

                } else if( restartInput != 1 ) {

                    throw new IllegalArgumentException( PrintMessage.ERROR.getMessage() );
                }
            } catch ( Exception e ) {

                break;
            }
        }
    }
}