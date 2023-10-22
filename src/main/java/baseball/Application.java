package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
//            List<Integer> num_list = new ArrayList<>(3);
//            num_list = pickUniqueNumbersInRange(1, 9, 3);
            List<Integer> num_list = new ArrayList<>();
            while (num_list.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!num_list.contains(randomNumber)) {
                    num_list.add(randomNumber);
                }
            }
            game(num_list);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(readLine().equals("2"))
                break;
        }

    }
    public static void game(List num){//nl:정답
        while(true){
            int ball=0, strike=0;
            System.out.print("숫자를 입력해주세요 : ");
            int sca=Integer.parseInt(readLine());//sca:입력받는 수
            if(sca%10==(int)num.get(0)) {
                strike++;
            }else if(sca%10==(int)num.get(1)||sca%10==(int)num.get(2)){
                ball++;
            }
            sca/=10;
            if(sca%10==(int)num.get(1)) {
                strike++;
            }else if(sca%10==(int)num.get(0)||sca%10==(int)num.get(2)){
                ball++;
            }
            sca/=10;
            if(sca%10==(int)num.get(2)) {
                strike++;
            }else if(sca%10==(int)num.get(0)||sca%10==(int)num.get(1)){
                ball++;
            }
            if(ball==0&&strike==0){
                System.out.println("낫싱");
            }else if(ball==0){
                System.out.println(strike+"스트라이크");
                if(strike==3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }else if(strike==0){
                System.out.println(ball+"볼");
            }else{
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }
    }
}
