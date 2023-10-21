package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {

    }
}

class Game {
    private  static final String InputNumberMessage = "숫자를 입력해주세요 : ";
    private  static final String CheckingRestart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int RandomNumber(){ // 1~9까지 랜덤 숫자 생성
        return pickNumberInRange(1,9);
    }

    int[] Answer = new int[3]; // 정답 숫자
    Game(){
        int num;
        for (int i=0; i<3; i++){  // 컴퓨터가 임의의 숫자 3개 선택
            num = this.RandomNumber();
            if (!Check.RepeatNumber(Answer,num)){
                Answer[i] = num;
            }
        }
    }
}

class Check{
    static boolean RepeatNumber(int[] arr, int number){  // 각 자리 숫자가 중복되지 않도록 체크
        for (int num : arr) {
            if (num == number){ // 중복된 숫자가 있을 경우
                return true;
            }
        }
        return false;
    }
}

