package baseball.core;

import baseball.property.GameScore;

import java.util.List;

public class CompareNumber {

    public static GameScore compareNumberList(List<Integer> user,List<Integer> computer){

        if (userListAndComputerListSizeCompare(user,computer)){
            throw new IllegalArgumentException("[Err] 유저 입력값과 컴퓨터 생성의 수의 개수가 다릅니다.");
        }

        int loop_cnt = user.size();
        int ball_count=0;
        int strike_count=0;

        for (int i=0;i<loop_cnt;i++){
            int user_number = user.get(i);
            int computer_number = computer.get(i);
            int strike_result = compareStrikeCount(user_number, computer_number);
            if (strike_result ==0){
                ball_count+=compareBallCount(user_number,computer);
            }
            strike_count+=strike_result;
        }
        return new GameScore(ball_count,strike_count);
    }

    private static int compareStrikeCount(int user_number,int computer_number){
        if (user_number==computer_number){
            return 1;
        }
        return 0;
    }

    private static int compareBallCount(int user_number,List<Integer> computer){
        if (computer.contains(user_number)){
            return 1;
        }
        return 0;
    }

    private static boolean userListAndComputerListSizeCompare(List<Integer> user,List<Integer> computer){
        return user.size()!=computer.size();
    }
}
