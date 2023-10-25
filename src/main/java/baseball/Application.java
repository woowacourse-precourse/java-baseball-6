package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean again = true;

            //1. 프로그램이 시작 문구 출력
            System.out.println("숫자 야구게임을 시작 합니다.");
            //2. 컴퓨터에게 1~9까지의 임의의 숫자 3개 발급
            List<Integer> computer = 컴퓨터_랜덤값();
        while(again) {
            System.out.print("숫자를 입력해 주세요 : ");
            //3.사용자에게 3자리 수 입력 받도록 구현
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            try {
                예외_테스트(userInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            List<Integer> userInputList = 입력값_리스트_반환(userInput);
            String result = "";
            while(심판(computer,userInputList).equals("3스트라이크")){
                result = 심판(computer,userInputList);
                System.out.println(result);
                again = playagain();
                if(!again){
                    break;
                }else{
                    computer = 컴퓨터_랜덤값();
                    userInputList = new ArrayList<>();
                }
            }
            result = 심판(computer,userInputList);
            System.out.println(result);
        }

    }
    static List<Integer> 컴퓨터_랜덤값(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }
    static void 예외_테스트(String 입력값) throws IllegalArgumentException{
        boolean exceptionTnf = true;
        //4. 3자리 이상 입력햇을 때 Exception
        if(입력값.length() != 3){
            exceptionTnf = false;
            throw new IllegalArgumentException("3자리 입력해주셔야합니다.");
        }
        exceptionTnf = 입력값_문자열포함_체크(입력값);

    }
    //4. 3자리 입력이지만 문자열이 포함되어 있을 때 Exception
    static boolean 입력값_문자열포함_체크(String 입력값) throws IllegalArgumentException{
        try {
            Integer.parseInt(입력값);
            return true;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }
    static List<Integer> 입력값_리스트_반환(String 입력값){
        List<Integer> userInputList = new ArrayList<>();
        userInputList.add(Integer.parseInt(입력값.substring(0,1)));
        userInputList.add(Integer.parseInt(입력값.substring(1,2)));
        userInputList.add(Integer.parseInt(입력값.substring(2)));
        return userInputList;
    }

    static int ballCount(List<Integer> 컴퓨터, List<Integer> 플레이어){
        int result = 0;
        for (int i = 0; i < 플레이어.size(); i++) {
            if(컴퓨터.contains(플레이어.get(i))){
                result += 1;
            }
        }
        return result;
    }

    static int strikeCount(List<Integer> 컴퓨터, List<Integer> 플레이어){
        int strike = 0;
        for(int i = 0; i < 플레이어.size(); i++){
            if(컴퓨터.get(i)==플레이어.get(i)){
                strike += 1;
            }
        }
        return strike;
    }

    //5. 컴퓨터가 가진 숫자 3개와 사용자에게 입력 받은 숫자 비교 로직 구현
    static String 심판 (List<Integer> 컴퓨터, List<Integer> 플레이어){
        int total = ballCount(컴퓨터, 플레이어);
        int strike = strikeCount(컴퓨터, 플레이어);
        int ball = total - strike;

        if(total == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball+" 볼 "+strike+ " 스트라이크";
    }

     //7. 게임이 끝난 후 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 라는 문구 출력
     static boolean playagain(){
         System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
         System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
         String answer = camp.nextstep.edu.missionutils.Console.readLine();
         if(Integer.parseInt(answer) == 1){
            return true;
         }
            return false;
    }
}

