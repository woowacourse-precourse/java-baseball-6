package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static boolean game_check(List<Integer> input_list, List<Integer> com_list){
        int strick_cnt=0;
        int ball_cnt=0;
        int input_int;
        int com_int;

        for(int i=0;i<input_list.size();i++){
            input_int=input_list.get(i);
            com_int=com_list.get(i);

            //스트라이크 판별
            if(input_int==com_int) {
                strick_cnt++;
            }
            //스트라이크가 아닐 시 볼 판별
            else if(com_list.contains(input_int)){
                ball_cnt++;
            }
        }

        //스트라이크가 3개일 경우
        if (strick_cnt==3) {
            System.out.println(strick_cnt+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else {
            //스트라이크, 볼 둘다 0일 경우
            if(strick_cnt==0 && ball_cnt==0){
                System.out.println("낫싱");
            }
            else{
                System.out.print(ball_cnt+"볼 ");
                System.out.println(strick_cnt+"스트라이크");
            }
            return false;
        }
    }
    public static void pick_num(List<Integer> com_list){
        while (com_list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!com_list.contains(randomNumber)) {
                com_list.add(randomNumber);
            }
        }
    }

    public static void valid_check(List<Integer> input_list){
        System.out.print("숫자를 입력해주세요. : ");
        String input_num = readLine();

        if(input_num.length() != 3) //3자리 숫자가 아닌값 판별
            throw new IllegalArgumentException("Invalid size");

        for (int i = 0; i < input_num.length(); i++) {
            if(input_num.charAt(i)<'0' || input_num.charAt(i)>'9')//숫자가 아닌 값 판별
                throw new IllegalArgumentException("Invalid value");

            input_list.add((int) input_num.charAt(i) - '0');
        }
    }
    public static boolean get_continue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String game=readLine();
        return game.equals("1");
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> input_list=new ArrayList<>();
        List<Integer> com_list = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            com_list.clear();
            pick_num(com_list); //랜덤 숫자 3개 고르기

            do{
                input_list.clear();
                valid_check(input_list); //입력값이 유효하면 list에 넣기
            }
            while(!game_check(input_list,com_list)) ; // 랜덤숫자와 입력숫자 비교

        }while(get_continue()); //게임 진행 및 종료 선택

    }
}
