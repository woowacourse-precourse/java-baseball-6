package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    public Balls start_game() {
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
            throw new IllegalArgumentException();
        }
    }

    public int check_balls(Balls goal, Guess user_ball) {
        int locate = 0;
        while (locate < goal.size) {
            // 입력값 중 target ball 설정
            int ball = user_ball.get_ball(locate);
            //-1: 해당 값이 없음
            int goal_index = goal.get_index(ball);

            if (goal_index >= 0) {
                if (goal_index == locate) {
                    user_ball.strike++;
                } else user_ball.ball++;
            } else user_ball.nothing--;

            locate++;
        }
        return user_ball.get_result();
    }

    public int end_balls() {
        // 사용자 숫자야구 성공
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int user_input = Integer.parseInt(Console.readLine());
        return user_input;
    }
}
