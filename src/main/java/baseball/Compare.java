package baseball;

// 실질적인 비교 연산을 처리하기 위해 사용하는 객체이다.
public class Compare {

    // 컴퓨터와 유저의 데이터를 비교하여 스트라이크와 볼 개수가 저장된 배열을 리턴한다.
    public int[] compare(int[] computer, int[] user){
        int strike = 0;
        int ball = 0;

        // score[0] = Strike 개수, score[1] = ball 개수
        int[] score = new int[2];

        for(int i=0; i<computer.length; i++){
            for(int j=0; j<user.length; j++){
                if(computer[i] == user[j] && i == j){
                    strike++;
                    break;
                } else if (computer[i] == user[j]) {
                    ball++;
                    break;
                }
            }
        }
        score[0] = strike;
        score[1] = ball;

        return score;
    }
}
