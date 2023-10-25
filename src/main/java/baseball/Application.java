package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Answer answer = new Answer();
        Input input = new Input();
        Result result = new Result();
        Re re = new Re();
        String output = "";
        String again="";

        System.out.println("숫자 야구 게임을 시작합니다.");         //처음에 시작할때 한번만
        do {                                                    //do while을 통해 무조건 한 번은 실행
            List<Integer> ans = answer.RandomAns();                  //랜덤 값 생성(Answer) 답은 ans에 List형식으로 저장
            System.out.println(ans);
            while(!output.equals("3스트라이크")) {           //정답을 찾울때 까지 실행
                List<Integer> inputnum = input.inputnum();               //입력값 받기(Input) 입력값은 inputnum에 List형식으로 저장
                output = result.result(ans,inputnum);
                System.out.println(output);
            }

            output = "";                    //다음 게임을 위한 초기화

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            again = re.re();

        }while(again.equals("1"));

        //예외 처리도 추가
    }
}
