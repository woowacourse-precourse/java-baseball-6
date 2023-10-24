package baseball;


final class Game_Score
{
    public int strike;
    public int ball;
    public Game_Score()
    {
        this.strike = 0;
        this.ball = 0;
    }
    public void Set_Game_Score(int strike, int ball)
    {
        this.strike = strike;
        this.ball = ball;
    }
}

public class Score {
    Game_Score game_score = new Game_Score();
    public void reset_score() {
        game_score.Set_Game_Score(0,0);
    }
    public int Get_Strike()	{
        return game_score.strike;
    }
    public void Play_Ball(int[] opponent_num,int[] user_num){
        game_score.strike = Multi_Numeric_Comparator.count_correct_num_spot(opponent_num,user_num);
        game_score.ball = Multi_Numeric_Comparator.count_right_num_wrong_spot(opponent_num,user_num);
        print_Result(game_score.strike, game_score.ball);
    }
    void print_Result(int strike, int ball)
    {
        if(strike==0&&ball==0) {
            System.out.println("낫싱");
            return;
        }
        if(strike==0&&ball>0) {
            System.out.printf("%d볼\n",ball);
            return;
        }
        if(strike>0&&ball==0) {
            System.out.printf("%d스트라이크\n",strike);
            return;
        }
        if(strike>0&&ball>0) {
            System.out.printf("%d볼 %d스트라이크\n",ball,strike);
            return;
        }
    }
}
