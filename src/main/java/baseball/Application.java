package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){//게임 실행의 한 루프
            List<Integer> random_num = new ArrayList<>();
            while (random_num.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!random_num.contains(randomNumber)) {
                    random_num.add(randomNumber);
                }
            }
            game(random_num);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart=readLine();
            if(restart.equals("2"))
                break;
            else if(restart.equals("1")){}
            else{
                throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
            }
        }

    }
    public static void game(List random_num){
        while(true){
            int ball=0, strike=0;
            System.out.print("숫자를 입력해주세요 : ");

            List<Integer> input_num=make_List(readLine());

            if(input_num.get(0).equals(random_num.get(0))) {
                strike++;
            }else if(input_num.get(0).equals(random_num.get(1))||input_num.get(0).equals(random_num.get(2))){
                ball++;
            }

            if(input_num.get(1).equals(random_num.get(1))) {
                strike++;
            }else if(input_num.get(1).equals(random_num.get(0))||input_num.get(1).equals(random_num.get(2))){
                ball++;
            }

            if(input_num.get(2).equals(random_num.get(2))) {
                strike++;
            }else if(input_num.get(2).equals(random_num.get(0))||input_num.get(2).equals(random_num.get(1))){
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
    public static List<Integer> make_List(String s){
        List<Integer> input_num=new ArrayList<>();
        if(s.length()!=3){//크기가 3이 아닐 경우
            throw new IllegalArgumentException("크기가 3이 아닙니다.");
        } else if (s.charAt(0)<49||s.charAt(0)>57||s.charAt(1)<49||s.charAt(1)>57||s.charAt(2)<49||s.charAt(2)>57) {//0==48, 9==57
            throw new IllegalArgumentException("1부터 9까지의 정수가 아닙니다.");
        } else if(s.charAt(0)==s.charAt(1)||s.charAt(0)==s.charAt(2)||s.charAt(1)==s.charAt(2)) {
            throw new IllegalArgumentException("숫자가 중복되었습니다.");
        }else {
            input_num=new ArrayList<>();
            input_num.add(Character.getNumericValue(s.charAt(0)));
            input_num.add(Character.getNumericValue(s.charAt(1)));
            input_num.add(Character.getNumericValue(s.charAt(2)));
        }

        return input_num;
    }
}
