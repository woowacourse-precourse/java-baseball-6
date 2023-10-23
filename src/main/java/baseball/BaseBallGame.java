package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class BaseBallGame {
    public List<Integer> computer;
    public List<Integer> user;
    private String userString;
    private int userInteger;
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
            IsLength(userString);
            IsInteger();
            IsOverlap(userInteger);
            IsZero();
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
    // 입력값 길이 판별 함수
    public void IsLength(String s){
        if(s.length() !=3){
            throw new IllegalArgumentException("세자리 수가 아닙니다.");
        }
    }
    // 입력값 숫자 판별 함수
    public void IsInteger(){
        try{
            userInteger = Integer.parseInt(userString);
        }catch(NumberFormatException ex){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
    //중복 확인 함수
    public void IsOverlap(int n){
        user = new ArrayList<>();
        while(user.size() < 3){
            int userNumber = n%10;
            n=n/10;
            if (user.contains(userNumber)) {
                throw new IllegalArgumentException("같은 숫자가 중복된 값입니다.");
            }
            user.add(userNumber);
        }
    }
    // 입력값 1~9숫자인지 판별 함수
    public void IsZero() {
        if (user.contains(0)) {
            throw new IllegalArgumentException("1~9 숫자 이외의 값입니다.");
        }
    }
}
