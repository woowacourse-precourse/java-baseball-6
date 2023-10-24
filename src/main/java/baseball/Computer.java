package baseball;

import static baseball.GameComponent.*;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {

    // 난수 생성 메소드
    public String makeRandNum(){
        StringBuilder randNum = new StringBuilder();

        while (randNum.length() < DIGIT){
            String temp = Integer.toString(Randoms.pickNumberInRange(1,9));
            // 중복 제거
            if(!randNum.toString().contains(temp)){
                randNum.append(temp);
            }
        }
        return String.valueOf(randNum);
    }
    // 숫자 비교
    public String compareNumbs(){
        // 카운트 초기화
        ballCnt = 0;
        strikeCnt = 0;

        for (int i = 0; i < DIGIT; i++){
            parseNum(i, randNum.charAt(i));
        }
        return compareResult();
    }

    private void parseNum(int i, char comNum){
        if (userNum.contains(Character.toString(comNum))) {
            if (userNum.charAt(i) == comNum) {
                strikeCnt++;
                return;
            }
            ballCnt++;
        }
    }
    // 비교 결과값 출력
    private String compareResult() {
        if (strikeCnt == 3) {
            return strikeCnt + STRIKE;
        }
        if (strikeCnt == 0 && ballCnt == 0){
            return NOTHING;
        }
        if (strikeCnt == 0){
            return ballCnt + BALL;
        }
        if (ballCnt == 0){
            return strikeCnt + STRIKE;
        }
        return ballCnt + BALL+ " " + strikeCnt + STRIKE;
    }
}
