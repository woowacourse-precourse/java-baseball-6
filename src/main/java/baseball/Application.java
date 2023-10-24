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
            Set<Character> dup_check = new HashSet<>();//중복 체크용 set

            //숫자 입력
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();

            if(input.length() != 3){//예외 1 : 길이가 3이 아닌 경우
                throw new IllegalArgumentException();
            }
            if(input.matches("[+-]?\\d*(\\.\\d+)?") == false){//예외 2 : 숫자 이외의 문자가 포함되어 있을 경우
                throw new IllegalArgumentException();
            }

            for(int i = 0; i<input.length(); i++){
                dup_check.add(input.charAt(i));
            }
            if(dup_check.size() != input.length()){ //예외 3: 입력 숫자를 중복해서 입력하였을 경우
                throw new IllegalArgumentException();
            }


            //입력한 문자열을 담을 int 배열
            int[] input_split = new int[input.length()];
            //입력한 문자열을 input_split에 담는다
            for(int i = 0; i<input.length(); i++){
                input_split[i] = Character.getNumericValue(input.charAt(i));
            }

            //배열 길이(3) 만큼 실행
            for(int i = 0 ; i<input_split.length; i++){
                if(answer_list.get(i) == input_split[i]){ // 자릿수와 숫자 모두 같을  떄 : strike 증가
                    strike++;
                }else{
                    if(answer_list.contains(input_split[i])){ // 숫자만 포함하고 있을 때 : ball 증가
                        ball++;
                    }
                }

            }

            //스트라이크나 볼이 하나도 없을 때
            if(strike == 0  && ball == 0){
                System.out.println("낫싱");
            }else{//있을 시,  각자 값 출력
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            if(strike == 3){// 모두 맞추었을 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


              //1이나 2를 입력해서 재시작 or 종료
                input = Console.readLine();
                if(input.length() != 1){ //예외 1 : 길이가 1이 아닐 경우
                    throw new IllegalArgumentException();
                }
                if(input.matches("[1-2]") == false){//예외 2 : 1이나 2 가 아닌 다른 숫자/문자일 경우
                    throw new IllegalArgumentException();
                }

                if(input.equals("1")){//1 : 게임 재시작
                    answer_list = random_pick(); // 다시 answer 값을 만든다.
                }else if(input.equals("2")){//2 : 게임 종료
                    end_check = true;}

            }

        }

    }
}
