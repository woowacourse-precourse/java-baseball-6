package baseball;


import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    //랜덤 숫자 list 삽입 함수
    public static List<Integer> random_pick(){
        Set<Integer> set_answer = new HashSet<>();
        //1~9까지의 랜덤 숫자 3개 Set에 삽입
        while(set_answer.size() != 3){
            int random = Randoms.pickNumberInRange(1, 9);
            set_answer.add(random);
        }
        //Set에 담긴 정답 숫자 list에 삽입
        List<Integer> answer = new ArrayList<>(set_answer);
        return answer;
    }
    //메인 숫자야구 함수
    public static void main(String[] args) {
        List<Integer> answer_list = new ArrayList<>();
        int ball =0;
        int strike = 0;
        String input = "";
        boolean end_check = false;

        //1. 랜덤 숫자 3개를 담은 answer_list 생성
        answer_list = random_pick();

        //2. 숫자 야구 게임 시작 알림
        System.out.println("숫자 야구 게임을 시작합니다.");

        //3.while문으로 숫자야구 진행
        //while 문 조건 - strike 갯수가 3개가 아니거나 end_check 가 false 상태일 것
        while (strike != 3 || end_check == false){
            //while문 돌 때마다 ball과 strike는 초기화
            ball = 0;
            strike = 0;


            //숫자 입력
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();

            if(input.length() != 3){//예외 1 : 길이가 3이 아닌 경우
                throw new IllegalArgumentException();
            }
            if(input.matches("[+-]?\\d*(\\.\\d+)?") == false){//예외 2 : 숫자 이외의 문자가 포함되어 있을 경우
                throw new IllegalArgumentException();
            }








        }

    }
}
