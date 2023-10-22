package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RightAnswer {

    static String gameSet ="";

    public boolean threeStrikeVAR(String decision) {
        if(decision.equals("3스트라이크")){
            return true;
        }
        return false;
    }
    public String restartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameSet = readLine();
        if(gameSet.equals("1")) return "재시작";
        else if(gameSet.equals("2")) return "게임 종료";
        throw new IllegalArgumentException("잘못된 재시작/종료번호 입니다 :"+gameSet);
    }

    private void reset() {
       // computer.clear();
    }

}
