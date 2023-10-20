package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class BaseBallGame implements Game{
    private final String COMPUTER_VALUE = matchFormat(getRandomNumber());
    private final int VALUE_SIZE = 3;

    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            String user_input = Console.readLine();
            if (user_input.length() > 3  || isDuplicated(user_input)) { // 숫자가 아닐 경우, 초과되는 숫자일 경우에 대비한 에러 처리 ++
                throw new IllegalArgumentException();
            }
            // STRIKE

            // BALL
            break;
        }
    }

    @Override
    public void exit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String select = Console.readLine();
        return;
    }
    private String matchFormat(String value){
        return String.format("%03d", Integer.parseInt(value));
    }
    private String matchFormat(int value){
        return String.format("%03d", value);
    }
    public boolean isDuplicated(String value){
        return value.charAt(0) == value.charAt(1) || value.charAt(1) == value.charAt(2) || value.charAt(0) == value.charAt(2);
    }
    private String getRandomNumber(){
        String randomNumber = matchFormat(Randoms.pickNumberInRange(0, 999));
        while(isDuplicated(randomNumber)){
            randomNumber = matchFormat(Randoms.pickNumberInRange(0, 999));
        }
        return randomNumber;
    }
    private int getStrikeCount(String user_value){
        int strike_count = 0;
        for (int i=0; i < VALUE_SIZE; i++){
            if (user_value.charAt(i) == COMPUTER_VALUE.charAt(i)) {
                strike_count++;
            }
        }
        return strike_count;
    }
    private int getBallCount(String user_value){
        int ball_count = 0;
        for (int userIdx =0; userIdx < VALUE_SIZE; userIdx++){
            for (int comIdx = 0; comIdx < VALUE_SIZE; comIdx++){
                if (comIdx == userIdx) continue;
                if (user_value.charAt(userIdx) == COMPUTER_VALUE.charAt(comIdx)) ball_count++;
            }
        }
        return ball_count;
    }
}
