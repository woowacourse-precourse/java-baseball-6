package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            RandomNum num = new RandomNum(); //랜덤 숫자 생성

            System.out.println("숫자 야구 게임을 시작합니다.");
            game(num);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (endCheck()) break;
        }
    }

    private static void game(RandomNum num) {
        Integer[] counting={0,0}; //0:볼 ,1:스트라이크
        while (counting[1]!=3) { //3스트라이크가 아니라면 계속 실행
            String s = readLine(); //사용자 입력받음
            List<Integer> input = input(s); //사용자 입력 유효한지 확인 및 데이터 변환

            counting = counting(num,input);

            Integer ball = counting[0];
            Integer strike = counting[1];

            print(ball,strike);
        }
    }

    static List<Integer> input(String s) {
        if (s.length()!=3) throw new IllegalArgumentException();

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Integer num = s.charAt(i) - '0';
            if(num<1 || num>9) throw new IllegalArgumentException(); //입력한 단어가 1~9사이의 숫자가 아니라면 에러
            if(input.contains(num)) throw new IllegalArgumentException(); //숫자를 중복해서 입력할 경우 에러

            input.add(num);
        }

        return input;
    }

    static Integer[] counting(RandomNum num,List<Integer> input) {
        Integer[] counting = {0, 0}; // 0:볼 ,1:스트라이크

        for (int i = 0; i < 3; i++) {
            int answerNum = num.getNum(i);
            int inputNum = input.get(i);

            if(answerNum==inputNum) counting[1]++; //스트라이크
            if(input.contains(answerNum) && answerNum!=inputNum) counting[0]++; //볼
        }

        return counting;
    }

    static void print(Integer ball, Integer strike) {
        if(ball==0 && strike==0){
            System.out.println("낫싱");
        }
        if(ball==0 && strike>0){
            System.out.println(strike + "스트라이크");
        }
        if(ball>0 && strike==0){
            System.out.println(ball+"볼");
        }
        if(ball>0 && strike>0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    private static boolean endCheck() {
        String reTry = readLine();
        if(reTry.length()==0) throw new IllegalArgumentException();

        Integer status = reTry.charAt(0) - '0';

        if (status<1 || status>2) throw new IllegalArgumentException(); //범위 벗어난다면 에러 처리
        if (status==2) return true;
        return false;
    }
}
