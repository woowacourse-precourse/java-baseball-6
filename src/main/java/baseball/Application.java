package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Order;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        boolean gaming = true;
        boolean predicting = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gaming){

            Map<Integer,Integer> computer = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            makeRandomValue(computer,sb);
            String OrderOfNum = sb.toString();

            predicting = true;
            while(predicting){
                int strike=0;
                int ball=0;
                boolean nothing = false;

                System.out.print("숫자를 입력해주세요 : ");

                String inputLine = readLine();
                if(inputLine.length() != 3 ){
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                try{
                    Integer.parseInt(inputLine);
                } catch (IllegalArgumentException e){
                    throw e;
                }

                char[] myInputValue = inputLine.toCharArray();

                Result result = getResult(myInputValue, OrderOfNum, strike, computer, ball);

                outPutSentance(result, nothing);

                if(result.strike() == 3){
                    gaming = isAfterGaming(gaming);
                    predicting = false;
                }

            }
        }

    }

    private static boolean isAfterGaming(boolean gaming) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = readLine();
        if (!(input.length() == 1 && (input.charAt(0) == '1' || input.charAt(0) == '2'))) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        int temp = Integer.parseInt(input);


        if(temp == 2)
            gaming = false;
        return gaming;
    }


    private static void outPutSentance(Result result, boolean nothing) {
        if(result.strike() == 0 && result.ball() == 0) nothing = true;

        if(nothing)
            System.out.println("낫싱");
        else if(result.ball() > 0 && result.strike() ==0){
            System.out.println(result.ball() +"볼");
        }else if(result.ball() == 0 && result.strike() > 0){
            System.out.println(result.strike() + "스트라이크");
        }else if(result.ball() > 0 && result.strike() > 0){
            System.out.println(result.ball() +"볼 " + result.strike() +"스트라이크");
        }
    }

    private static Result getResult(char[] myInputValue, String OrderOfNum, int strike, Map<Integer, Integer> computer, int ball) {
        for(int i=0; i<3; i++){
            int value = myInputValue[i] - '0';
            if(value == OrderOfNum.charAt(i) - '0'){
                strike++;
            }
            else if(computer.getOrDefault(value,0) == 1){
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private record Result(int strike, int ball) {
    }

    private static void makeRandomValue(Map<Integer, Integer> computer, StringBuilder sb) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.containsKey(randomNumber)) {
                computer.put(randomNumber,1);
                sb.append(randomNumber);
            }
        }
    }
}
