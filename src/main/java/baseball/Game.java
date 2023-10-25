package baseball;

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

        do {
            List<Integer> userNum = initializer.setUser();
            resultFlag = analyzer.analysis(comNum, userNum);
        } while(resultFlag == true);

        System.out.println("종료!!");
    }
}
