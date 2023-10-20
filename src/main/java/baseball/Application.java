package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static int strike_count, ball_count;
    static List<Integer> computer;
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        computerInit();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            in = new BufferedReader(new InputStreamReader(System.in));
            String str = in.readLine();
            strike_count = 0;
            ball_count = 0;
            List<Integer> user = new ArrayList<>();
            for(int i=0; i<str.length(); i++){
                user.add(str.charAt(i)-'0');
            }
            strikeCount(computer, user);
            if(strike_count < 3){
                ballCount(computer, user);
            }
            if(strike_count >0 && ball_count >0){
                System.out.println(ball_count+"볼 "+strike_count+"스트라이크");
            }
            else{
                if(strike_count == 0 && ball_count == 0){
                    System.out.println("낫싱");
                }else{
                    if(strike_count > 0){
                        System.out.println(strike_count+"스트라이크");
                    }
                    else if(ball_count > 0){
                        System.out.println(ball_count+"볼");
                    }
                }
            }
            if(strike_count == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                String cmd = in.readLine();
                if(cmd.equals("1")){
                    computerInit();
                }
                else if(cmd.equals("2")){
                    break;
                }
            }


        }

    }
    static void strikeCount(List<Integer> computer, List<Integer> user){
        for(int i=0; i<computer.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike_count++;
            }
        }
    }
    static void ballCount(List<Integer> computer, List<Integer> user){
        int left = 0;
        int right = 0;
        while(left < computer.size() && right < computer.size()){
            if(left != right ){
                if(computer.get(left) == user.get(right)){
                    ball_count++;
                    left++;
                    right = -1;
                }
            }
            right++;
            if(right == computer.size()){
                left++;
                right = 0;
            }

        }
    }
    static void computerInit(){
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

}
