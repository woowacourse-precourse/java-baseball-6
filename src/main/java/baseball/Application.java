package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static boolean game_check(List<Integer> input_list, List<Integer> com_list){
        int strick_cnt=0;
        int ball_cnt=0;

        for(int i=0;i<input_list.size();i++){
            if(input_list.get(i).equals(com_list.get(i))) strick_cnt++;
        }

        if (strick_cnt==3) {
            System.out.println(strick_cnt+"스트라이크");
            return true;
        }
        else {
            for(int i : com_list){
                if(input_list.contains(i)) ball_cnt++;
            }
            ball_cnt=ball_cnt-strick_cnt;

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
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> input_list=new ArrayList<>();
        List<Integer> com_list = new ArrayList<>();

        String game;
        do{
            com_list.clear();
            while (com_list.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!com_list.contains(randomNumber)) {
                    com_list.add(randomNumber);
                }
            }

            do{
                input_list.clear();
                System.out.print("숫자를 입력해주세요. : ");
                String num = readLine();

                if(num.length() != 3){
                    throw new IllegalArgumentException("Invalid size ");
                }
                for (int i = 0; i < num.length(); i++) {
                    input_list.add((int) num.charAt(i) - '0');
                }
            }
            while(!game_check(input_list,com_list)) ;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game=readLine();
        }while(game.contains("1"));

    }
}
