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
            //숫자 야구 게임을 맞출 때까지 사용자의 수는 초기화를 해줍니다.
            List<Integer> user = new ArrayList<>();
            for(int i=0; i<str.length(); i++){
                user.add(str.charAt(i)-'0');
            }
            strikeCount(computer, user);
            //스트라이크 카운트가 3보다 작으면 ball 카운트를 세줍니다.
            if(strike_count < 3){
                ballCount(computer, user);
            }
            //스트라이크 카운트와 볼 카운트가 존재 하면 그 결과를 알려줍니다.
            if(strike_count >0 && ball_count >0){
                System.out.println(ball_count+"볼 "+strike_count+"스트라이크");
            }
            else{
                //스트라이크 카운트와 볼 카운트가 없으면 낫싱을 출력하도록 합니다.
                if(strike_count == 0 && ball_count == 0){
                    System.out.println("낫싱");
                }else{
                    //스트라이크와 볼 카운트가 각각 존재 하면 그 갯수를 출력합니다.
                    if(strike_count > 0){
                        System.out.println(strike_count+"스트라이크");
                    }
                    else if(ball_count > 0){
                        System.out.println(ball_count+"볼");
                    }
                }
            }
            /*
            * 스트라이크가 3개면 모두 맞혔으므로 게임을 새로시작할 것인지 종료할것인지 입력하라고 알려줍니다.
            * 1 입력하면 새로 시작
            * 2 입력하면 종료
             * */

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

    //스트라이크 갯수 세는 함수입니다.
    static void strikeCount(List<Integer> computer, List<Integer> user){
        // 컴퓨터의 자릿수 수와 사용자의 자릿수가 같은지 비교합니다.
        for(int i=0; i<computer.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike_count++;
            }
        }
    }
    //볼 갯수 세는 함수입니다.
    static void ballCount(List<Integer> computer, List<Integer> user){
        /* 컴퓨터와 사용자의 수가 같은 것이 있는 지 비교를 합니다.
        백의 자릿수가 0인덱스로 일의 자릿수를 마지막 인덱스라고 가정해서 비교를 합니다.
        같은 수가 있다면 볼 카운트를 증가하고 컴퓨터 인덱스를 증가하고 사용자의 인덱스는 초기화를 하면서 비교합니다.
        만약 마지막 인덱스까지 비교를 하였다면 해당 loop는 탈출하게 됩니다.
        * */
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
    //숫자 야구 초기화
    static void computerInit(){
        computer = new ArrayList<>();
        //컴퓨터가 총 3자리수를 가지도록 설정합니다.
        while (computer.size() < 3) {
            //1~9까지의 랜덤 수를 가져옵니다.
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            //중복 숫자가 나오지 않도록 설정합니다.
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

}
