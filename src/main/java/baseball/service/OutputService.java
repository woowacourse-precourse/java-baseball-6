package baseball.service;

import java.util.HashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class OutputService {
    private Map<String,Integer> results;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    public OutputService(Map<String,Integer> results){
        this.results = results;
    }
    public int printThreeStrikeResult(){
        System.out.println(results.get(STRIKE)+STRIKE);
        System.out.println("3개 숫자를 모두 맞히셨습니다. 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
    public int printResult(int bvalue, int svalue){ // 볼, 스트라이크
        if(svalue == 0 && bvalue!=0) {
            System.out.println(bvalue+BALL);
            return 1;
        }
        if(svalue!=0 && bvalue==0 && svalue!=3){
            System.out.println(svalue+STRIKE);
            return 1;
        }
        if(svalue!=0 && bvalue!=0 && svalue!=3){
            System.out.println(bvalue+BALL+" "+svalue+STRIKE);
            return 1;
        }
        if(svalue==3){
            return printThreeStrikeResult();
        }
        if(svalue==0 && bvalue ==0){
            System.out.println(NOTHING);
            return 1;
        }
        return 1;
    }
    public int print(){
        return printResult(results.get(BALL),results.get(STRIKE));
    }

}
