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
    List<Integer> numbers;
    StringBuilder message;

    public void run(){
        init();
        // while 자리
        countBallAndStrike(inputParams());

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
        }

        return numbers;
    }

    public int[] countBallAndStrike(String param){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0 ; i<3; i++){
            boolean check = false;
            for(int j = 0 ; j<numbers.size(); j++){
                if(i==j){
                    // 여기 하는 중
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }

    public String inputParams(){
        String param = Console.readLine();

        if(param.length()!=3 || isInteger(param) || isDiffer(param)){
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
}
