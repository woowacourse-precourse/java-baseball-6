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
            List<Integer> random_num = new ArrayList<>();
            while (random_num.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!random_num.contains(randomNumber)) {
                    random_num.add(randomNumber);
                }
            }
            System.out.println(random_num);
            game(random_num);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(readLine().equals("2"))
                break;
            else if(readLine().equals("1")){}
            else{
                //입력 오류
            }
        }

    }
    public static void game(List rand_num){
        while(true){
            int ball=0, strike=0;
            System.out.print("숫자를 입력해주세요 : ");

            String s=readLine();//sca:입력받는 수

            List<Integer> input_num=new ArrayList<>();
            input_num.add(Character.getNumericValue(s.charAt(0)));
            input_num.add(Character.getNumericValue(s.charAt(1)));
            input_num.add(Character.getNumericValue(s.charAt(2)));

            if(input_num.get(0).equals(rand_num.get(0))) {
                strike++;
            }else if(input_num.get(0).equals(rand_num.get(1))||input_num.get(0).equals(rand_num.get(2))){
                ball++;
            }

            if(input_num.get(1).equals(rand_num.get(1))) {
                strike++;
            }else if(input_num.get(1).equals(rand_num.get(0))||input_num.get(1).equals(rand_num.get(2))){
                ball++;
            }

            if(input_num.get(2).equals(rand_num.get(2))) {
                strike++;
            }else if(input_num.get(2).equals(rand_num.get(0))||input_num.get(2).equals(rand_num.get(1))){
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
