package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static com.sun.nio.sctp.AssociationChangeNotification.AssocChangeEvent.RESTART;


public class Application {
    public static String RESTART_VALUE = "1";
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        gameStart();
        while(game.equals(RESTART_VALUE)){
            getRandom3Number(); // 서로 다른 3자리수 생성

            while(true){
                String input = getUserInput();
                List<Integer> baseballResult = baseball(input);

                String output = "";
                if (baseballResult.get(0) == 0 && baseballResult.get(1) == 0)
                    output += "낫싱";
                else{
                    if (baseballResult.get(0) > 0)
                        output += baseballResult.get(0) + "볼 ";
                    if( baseballResult.get(1) > 0)
                        output += baseballResult.get(1) + "스트라이크";
                }
                System.out.println(output);

                if(baseballResult.get(1) == 3) {
                    gameOver(); break;
                }
            }
        }
    }

    public static List<Integer> baseball(String input){
        int ball=0, strike=0;
        for(int i=0 ; i<3 ; i++) {
            Integer num = input.charAt(i) - '0';
            if(num == computer.get(i))
                strike += 1;
            else if(computer.contains(num))
                ball += 1;
        }

        List<Integer> result = new ArrayList<>();
        result.add(ball);
        result.add(strike);
        return result;
    }

    public static void getRandom3Number(){
        // 랜덤 1~9 서로 다른 수로 이루어진 3자리 수 생성
        computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
    }

    public static String getUserInput() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        String input = readLine();
        if(input.length()!=3)
            throw new IllegalArgumentException();
        if(input.charAt(0) < '1' && input.charAt(0) > '9' )
            throw new IllegalArgumentException();
        if(input.charAt(1) < '1' && input.charAt(1) > '9' )
            throw new IllegalArgumentException();
        if(input.charAt(2) < '1' && input.charAt(2) > '9' )
            throw new IllegalArgumentException();

        return input;
    }

    public static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        game = "1";
    }

    public static void gameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        game = readLine();
    }

    private static List<Integer> computer;
    private static String game;
}
