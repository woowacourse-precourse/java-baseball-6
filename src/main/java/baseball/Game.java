package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private Initializer initializer;
    private Analyzer analyzer;

    public Game() {
        this.initializer = new Initializer();
        this.analyzer = new Analyzer();
    }

    private boolean resultFlag = true;

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comNum = initializer.setCom();
        System.out.println("comNum = " + comNum);
        do {
            List<Integer> userNum = initializer.setUser();
            resultFlag = analyzer.analysis(comNum, userNum);
        } while(resultFlag == true);
    }

    public boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String nextAction = Console.readLine();

        if(nextAction.equals("1")){
            return true;
        }else {
            return false;
        }
    }

}
