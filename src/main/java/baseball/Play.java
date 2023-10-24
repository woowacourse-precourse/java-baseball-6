package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    public Balls start_game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Balls goal = new Balls();
        while (goal.size < goal.limit_size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            goal.add_ball(randomNumber);
        }
        return goal;
    }

    public Guess get_input(Balls goal) {
        //사용자 입력값 받기
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String guess = Console.readLine();
            Guess user_ball = new Guess(guess);
            // throw new error
            if (user_ball.size != goal.size) {
                throw new IllegalArgumentException();
            }
            return user_ball;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
        }
    }

    public int check_balls(Balls goal, Guess user_ball) {
        // 사용자 추측값 검증하기
        int locate = 0;
        String result="";
        while (locate < goal.size) {
            // 입력값 중 target ball 설정
            int ball = user_ball.get_ball(locate);
            //-1: 해당 값이 없음
            int goal_index = goal.get_index(ball);

            if (goal_index >= 0) {
                if (goal_index == locate) {
                    result = "strike";
                }
                if(goal_index != locate){
                    result = "ball";
                }
            }
            if (goal_index == -1) {
                result = "nothing";
            }
            locate++;
            user_ball.add_score(result);
        }
        return get_result(user_ball);
    }

    public int get_result(Guess user_ball) {
        int play_mode=0; // 게임 계속 진행
        if (user_ball.the_number_of("nothing") == 0) {
            System.out.println("낫싱");
            return play_mode;
        }
        int strike = user_ball.the_number_of("strike");
        int ball = user_ball.the_number_of("ball");

        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                return play_mode=3; //정답 맞춤, end_balls() 실행
            }
            return play_mode;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return play_mode;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
        return play_mode;
    }


    public int end_balls() {
        // 사용자 숫자야구 성공
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int play_mode = Integer.parseInt(Console.readLine());
        return play_mode;
    }
}
