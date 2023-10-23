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
                    //3. 비교기능
                    for(int i=0; i<input.length(); i++){
                        int tmp = Integer.parseInt(String.valueOf(input.charAt(i)));
                        if(computer.contains(tmp)){
                            if(computer.get(i).equals(tmp)){
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }

                    //3. 출력기능
                    if(ball!=0){System.out.printf("%d볼 ",ball);}
                    if(strike!=0){System.out.printf("%d스트라이크",strike);}
                    if(ball==0&&strike==0){System.out.print("낫싱");}
                    System.out.println();
                    ball=0; strike=0;//다음 비교를 위해 ball strike 수 초기화
                } else {
                    throw new IllegalArgumentException("유효하지 않은 입력 발생");//2.2 유효판별 종료기능
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
