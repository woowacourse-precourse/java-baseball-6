package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String gameState = "1";//1:게임진행, 2:게임종료
        List<Integer> computer = new ArrayList<>();//컴퓨터 수
        String input;//유저 입력
        int ball=0; int strike=0;//볼, 스트라이크 개수

        //게임 시작
        while(gameState.equals("1")){
            //1.상대방 수 생성
            while (computer.size() < 3){
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if(!computer.contains(randomNumber)){
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer.toString());
            //2.3자리수 입력 시작
            while(true){
                System.out.printf("숫자를 입력해주세요 : ");
                input = Console.readLine();
                if(isValidInput(input)){
                    System.out.println("유효");
                } else {
                    System.out.println("무효");
                }
            }
        }
    }
    //2. 사용자 입력이 유효한지 확인하는 메소드
    public static boolean isValidInput(String input){
        if(input == null || input.length()!=3){
            return false;
        }
        try {
            int n = Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
