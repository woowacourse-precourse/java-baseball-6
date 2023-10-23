package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().run();
    }

    final String startMessage = "숫자 야구 게임을 시작합니다.";
    final String strike = "스트라이크";
    final String ball = "볼";
    final String nothing = "낫싱";
    final String requestCommand = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String inputMessage = "숫자를 입력해 주세요 : ";
    final String end = "게임 종료";
    List<Integer> numbers;

    public void run(){
        // while 자리
            // 0 진행 1 init 2 종료
        int gameStatus = 1;
        while(gameStatus!=2){
            if(gameStatus==1){
                init();
                System.out.println(startMessage);
                gameStatus = 0;
            }

            System.out.print(inputMessage);
            int[] ballCount = countBallAndStrike(inputNumber());

            // ball/strike 메시지
            System.out.println(makeMessage(ballCount));

            if(ballCount[1]==3){
                System.out.println(requestCommand);
                String cmd = inputCmd();
                gameStatus = Integer.parseInt(cmd);
                System.out.println(end);
            }
        }
    }

    public void init(){
        numbers = setNumbers();
    }

    public List<Integer> setNumbers(){
        boolean[] check = new boolean[10];

        List<Integer> numbers = new ArrayList<>();

        while(numbers.size()<3){
            Integer number = Randoms.pickNumberInRange(1,9);

            if(check[number]){ continue; }

            check[number] = true;
            numbers.add(number);
            System.out.print(number);
        }
        System.out.println();
        return numbers;
    }

    public int[] countBallAndStrike(String param){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0 ; i<3; i++){
            for(int j = 0 ; j<numbers.size(); j++){
                if( param.charAt(i)-'0'== numbers.get(j) ){
                    if(i==j){
                        strikeCount++;
                    }else{
                        ballCount++;
                    }
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }

    public String inputNumber(){
        String param = Console.readLine();

        if(param.length()!=3 || !isInteger(param) || !isDiffer(param)){
            throw new IllegalArgumentException();
        }

        return param;
    }

    public String inputCmd(){
        String param = Console.readLine();

        if(param.length()!=1 || !isInteger(param) || !isCmd(param)){
            throw new IllegalArgumentException();
        }

        return param;
    }
    public boolean isInteger(String param){
        try{
            Integer.parseInt(param);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isDiffer(String param){
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i<param.length(); i++){
            set.add(param.charAt(i));
        }

        if(set.size()==3){
            return true;
        }

        return false;
    }

    public boolean isCmd(String param){
        int n = Integer.parseInt(param);
        if(n==1 || n==2){
            return true;
        }
        return false;
    }

    public String makeMessage(int[] ballCount){
        StringBuilder message = new StringBuilder();

        // nothing
        if(ballCount[0] == 0 && ballCount[1] == 0){
            return message.append(nothing).toString();
        }

        // ball
        if(ballCount[0] != 0){
            message.append(ballCount[0]).append(ball).append(' ');
        }

        // strike
        if(ballCount[1] != 0){
            message.append(ballCount[1]).append(strike);
        }

        return message.toString();
    }
}
