package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 0:숫자 입력 후 결과 출력 1:사용자(컴퓨터)값설정 2:시스템종료 3:다시하기
    static int play_mode = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Play play = new Play();

        Balls goal = new Balls();

        while (true) {
            if (play_mode == 1) {
                //게임 시작: 목표값 설정
                goal = play.start_game();
                play_mode = 0;
            }
            if (play_mode == 0) {
                //게임 플레이: 사용자 입력값 받고 결과 받기
                Guess user_try = play.get_input(goal);
                play_mode = play.check_balls(goal, user_try);
            }
            if (play_mode == 2) {
                //게임 종료
                break;
            }
            if (play_mode == 3) {
                //3스트라이크 성공: 재경합 여부 확인
                play_mode = play.end_balls();
            }
        }
    }
}
