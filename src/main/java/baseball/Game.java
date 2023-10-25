package baseball;

import java.util.List;

public class Game {

    private Initializer initializer = new Initializer();
    private Analyzer analyzer = new Analyzer();

    private boolean resultFlag = true;

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comNum = initializer.setCom();
        System.out.println("comNum = " + comNum);

        do {
            List<Integer> userNum = initializer.setUser();
            
            System.out.println("userNum = " + userNum); //test
            resultFlag = analyzer.analysis(comNum, userNum);
        } while(resultFlag == true);

        System.out.println("종료!!");
    }
}
