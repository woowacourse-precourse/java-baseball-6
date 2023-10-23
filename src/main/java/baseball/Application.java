package baseball;

import java.util.ArrayList;
import java.util.List;
import static baseball.Baseball_Game.*;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> input_list = new ArrayList<>();
        List<Integer> com_list = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            com_list.clear();
            pick_num(com_list); //랜덤 숫자 3개 고르기

            do{
                input_list.clear();
                valid_check(input_list); //입력값이 유효하면 list에 넣기
            }
            // 스트라이크 3일경우 게임종료
            while(!game_check(input_list,com_list)) ;

        }while(get_continue()); //새로 시작 및 최종 종료 선택

    }
}
