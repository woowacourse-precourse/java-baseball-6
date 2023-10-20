package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        BaseballGame Game = new BaseballGame();
        Game.GetComputer();
    }
};

// 야구 게임의 클래스 선언
class BaseballGame{

    // 데이터 필드
    List<Integer> Computer = new ArrayList<>();
    List<Integer> User = new ArrayList<>();
    int Strike;
    int Ball;

    // 메서드 ( Method )

    // 사용자의 숫자 입력을 받는 부분
    public void GetUser(){};

    // 컴퓨터가 자신의 랜덤 숫자 3가리를 선정하는 부분
    public void GetComputer(){
        while (Computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Computer.contains(randomNumber)) {
                Computer.add(randomNumber);
            }
        }
    };
    // 스트라이크 점수를 추가하는 함수
    public void AddStrike(){};

    // 볼 점수를 추가하는 함수
    public void AddBall(){};

    // 두개의 숫자에 대해 점수 계산을 진행하는 함수
    public void CheckNumber(){};

    // 점수를 확인하고 출력 및 종료와 재시작 여부를 판단하는 코드
    public void CheckScore(){};

    public void CheckEnd(){};

}