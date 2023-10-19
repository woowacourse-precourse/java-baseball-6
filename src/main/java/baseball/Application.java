package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play_mode =1; // 0:숫자 입력 후 결과 출력 1:사용자(컴퓨터)값설정 2:시스템종료 3:다시하기
        Balls goal = new Balls();

        while(true){
            if(play_mode ==1){
                // 목표값 설정
                goal.remove_balls();
                while(goal.size < goal.limit_size){
                    int randomNumber = Randoms.pickNumberInRange(1,9);
                    goal.add_ball(randomNumber);
                }
                play_mode=0;
            }
            if(play_mode ==0) {
                System.out.print("숫자를 입력해주세요 : ");
                try{
                    String guess = Console.readLine();
                    Guess user_try = new Guess(guess);

                    int locate = 0; //locate 를 알 수 있게 하는 역할
                    while(locate < goal.size){
                        int ball = user_try.get_ball(locate);
                        int goal_index = goal.get_index(ball);

                        if(goal_index>=0){
                            if(goal_index == locate){
                                user_try.strike++;
                            } else user_try.ball++;
                        }else user_try.nothing--;
                        locate++;
                    }


                    play_mode= user_try.get_result(play_mode);
                } catch (IllegalArgumentException e) {
                    throw e;
                } catch (IndexOutOfBoundsException e){
                    throw new IllegalArgumentException();
                }
            }
            if(play_mode==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int user_input = Integer.parseInt(Console.readLine());
                play_mode = user_input;
            }
            if(play_mode==2){
                break;
            }

        }



    }
}
