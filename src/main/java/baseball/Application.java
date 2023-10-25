package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> random_num = pick_random_nums();

        game(random_num);
    }

    //랜덤값을 뽑는 함수
    public static List pick_random_nums(){
        List<Integer> random_nums = new ArrayList<>();
        while (random_nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!random_nums.contains(randomNumber)) {
                random_nums.add(randomNumber);
            }
        }
        return random_nums;
    }

    //야구 게임을 실행하기 위한 함수 game
    public static void game(List random_nums){
        while(true){
//            System.out.println(random_nums.toString());
            int ball=0, strike=0;
            System.out.print("숫자를 입력해주세요 : ");

            List<Integer> input_nums=make_List(readLine());

            strike=compare_strike(input_nums,random_nums);
            ball=compare_ball(input_nums,random_nums,strike);

            if(output_comment(strike,ball)){//문제를 맞혔을 경우
                break;
            }
        }

        if(game_restart()){//true면 벗어남
            return;
        }else{
            game(pick_random_nums());
        }

    }

    //입력값을 정제하기 위한 함수 make_List
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


    //숫자를 비교하기 위한 함수(겹치는 수가 만큼 리턴)
    public static int compare_ball(List input_nums,List random_nums,int strike){
        int ball=0;
        for(int i=0;i<3;i++){
            if(input_nums.contains(random_nums.get(i)))
                ball++;
        }
        ball-=strike;
        return ball;
    }


    //스트라이크 숫자 비교 함수
    public static int compare_strike(List input_nums,List random_nums){
        int strike=0;
        for (int i=0;i<3;i++) {
            if(input_nums.get(i).equals(random_nums.get(i)))
                strike++;
        }
        return strike;
    }


    //게임 종료 및 출력을 위한 함수
    public static boolean output_comment(int strike,int ball){
        boolean game_ing=false;
        if(ball==0&&strike==0){
            System.out.println("낫싱");
        }else if(ball==0){
            System.out.println(strike+"스트라이크");
            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                game_ing=true;
            }
        }else if(strike==0){
            System.out.println(ball+"볼");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        return game_ing;
    }

    //재실행을 결정하는 함수
    public static boolean game_restart(){
        boolean restart_bool=false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String restart=readLine();
        if(restart.equals("2")) {restart_bool=true;}//종료
        else if(restart.equals("1")){
        }
        else{
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        return restart_bool;
    }
}
