package baseball.Controller;

import baseball.Model.ComputerNum;
import baseball.Model.UserNum;
import baseball.View.GameView;

public class GameController {
    ComputerNum computerNum;
    UserNum userNum;

    public GameController() {
        computerNum = new ComputerNum();
    }

    public void GameSet(String inputNum) {
        userNum = new UserNum(inputNum);
    }

    public void GameStart() {
        while(true) {
            String inputNum = GameView.inputNum(); // 사용자 숫자 입력 받음
            GameSet(inputNum);

            if(NumCheck()) break; // 숫자가 모두 동일하면(자리까지) 바로 종료
            else {
                getHint(); // 아니면 힌트 얻기
            }
        }
    }

    public boolean NumCheck() {
        if(computerNum.getComputerNum().equals(userNum.getUserNum())) {
            System.out.println("3스트라이크");
            return true;
        }
        else return false;
    }

    public void getHint() {
        int strikeCnt = 0;
        int ballCnt = 0;

        String[] computer = computerNum.getComputerNum().split("");
        String[] user = userNum.getUserNum().split("");

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(computer[i].equals(user[j]) && i == j) strikeCnt+=1; // 숫자와 자리 모두 동일하면 스트라이크 1 증가
                else if(computer[i].equals(user[j]) && i != j) ballCnt+=1; // 숫자는 동일하지만 자리가 다르다면 볼 1 증가
            }
        }

        // 힌트 결과 출력
        if(ballCnt != 0) {
            if(strikeCnt != 0) System.out.println(ballCnt+"볼 "+strikeCnt+"스트라이크");
            else System.out.println(ballCnt+"볼");
        } else {
            if(strikeCnt != 0) System.out.println(strikeCnt+"스트라이크");
            else System.out.println("낫싱");
        }
    }
}