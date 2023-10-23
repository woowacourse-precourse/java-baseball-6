package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class BaseBallGame {
    public List<Integer> computer;
    private boolean cycle = true;

    //상대방(컴퓨터)의 수 생성 함수
    public void RandomNum() {
        computer =new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber =Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
    public BaseBallGame(){
        RandomNum();
        Play();
    }
    //게임 진행 함수
    public void Play(){
        StartGamePrint();
        while(cycle) {
            StartPrint();
            userString = InputNum();
        }
        StopGamePrint();
    }
    //게임 시작 알림 함수
    public void StartGamePrint(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    //게임 종료 알림 함수
    public void StopGamePrint(){
        System.out.print("게임 종료");
    }
    //숫자 입력 알림 함수
    public void StartPrint(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    //플레이어 숫자 입력 함수
    public String InputNum(){
        String player = Console.readLine();
        return player;
    }
}
