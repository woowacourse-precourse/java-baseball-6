package baseball;

public class Baseball_Game {
    Score score = new Score();
    final int STRIKES_OUT = 3;
    public int[] OPPONENT_NUM;
    public int[] USER_NUM;
    public void run() {
        OPPONENT_NUM = Set_Different_Number.set_different_numbers(3);
        while(score.Get_Strike() != STRIKES_OUT) {
            USER_NUM = User_Input.baseball_user_input();
            score.Play_Ball(OPPONENT_NUM, USER_NUM);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        score.reset_score();
    }
}
