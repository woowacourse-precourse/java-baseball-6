package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> computer; // 정답을 담을 리스트
    private List<Integer> player; // 사용자의 입력값을 담을 리스트
    public boolean playBaseball(){
        // startGame();
        // while(!onGame())
        // if(!quiteGame()) (
        // return true;
        return false;
    }
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = RandomUtil.createRandomNumbers();
    }

    public boolean onGame(){
        // 숫자를 입력 받기 위한 매세지 출력
        // 입력받는 메서드 호출
        // 점수 계산하는 score 메서드 호출 / 결과값 출력
        // 정답을 맞추면 return true / 틀리면 return false
        return true;
    }

    public boolean quitGame(){
        // 3개의 숫자를 모두 맞히셨습니다! 게임종료
        // 게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.
        // 입력받는 메서드 호출
        // 결과 값에 따라 프로그램 종료 or start game()
        return false;
    }
}
