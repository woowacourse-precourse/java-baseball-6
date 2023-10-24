package baseball;

import java.util.List;

public class Game {
    public int run(){
        User user = new User();
        Computer com = new Computer();
        // 정답을 맞출때까지 반복하는 변수
        boolean end_game = true;
        int one_more=2;
        // 게임 시작
        do {
            // 사용자 입력 받기
            List<Integer> user_answer = user.userChoice();
            // 정답과 비교
            String result = com.check(user_answer);
            // 결과 출력
            System.out.println(result);
            // 정답을 맞출 경우 게임 재시작여부 물어봄
            if(result.equals("3스트라이크")){
                end_game = false;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                one_more = user.regame();
            }
        }while(end_game); // 정답을 맞출때까지 반복
        // 게임 재시작 질문에 대한 입력값 전달
        return one_more;
    }
}
