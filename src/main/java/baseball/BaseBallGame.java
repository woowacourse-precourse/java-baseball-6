package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame implements Game{
    private View view;
    private String computer_Value;
    private final int VALUE_SIZE = 3;

    public BaseBallGame(View view) {
        this.view = view;
    }
    @Override
    public void start() {
//        System.out.println("숫자 야구 게임을 시작합니다.");
        view.out("숫자 야구 게임을 시작합니다.");
        while(true){
            run();
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            view.out("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (view.in().equals("2")) {
//            if (Console.readLine().equals("2")) {
                break;
            }
        }
    }
    public void run(){
        computer_Value = matchFormat(generateRandomNumber());
        while(true){
//            System.out.print("숫자를 입력해주세요 : ");
            view.out("숫자를 입력해주세요 : ");
//            String userInput = Console.readLine();
            String userInput = view.in();
            if (userInput.length() > 3  || isDuplicated(userInput)) { // 숫자가 아닐 경우, 초과되는 숫자일 경우에 대비한 에러 처리
                throw new IllegalArgumentException();
            }
            if (checkScore(userInput)) {
                return;
            }
        }
    }
    private boolean checkScore(String userStr){
        StringBuilder response = new StringBuilder();
        int strikeCount = getStrikeCount(userStr);
        int ballCount = getBallCount(userStr);
        if (ballCount > 0) {
            response.append(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            response.append(strikeCount + "스트라이크");
        }
        System.out.println(response.isEmpty() ? "낫싱" : response);
        if (strikeCount == 3){
            view.out("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
    @Override
    public void exit() {
        view.out("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private String matchFormat(String str){
        return String.format("%03d", Integer.parseInt(str));
    }
    private String matchFormat(int str){
        return String.format("%03d", str);
    }
    private boolean isDuplicated(String str){
        return str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2);
    }
    private String generateRandomNumber(){
        String generatedNumber = "";
        List<Integer> usingNumbers = new ArrayList<>();
        while (usingNumbers.size() < VALUE_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!usingNumbers.contains(number)) {
                usingNumbers.add(number);
            }
        }
        for (int temp: usingNumbers) {
            generatedNumber += temp;
        }
        return generatedNumber;
    }
    private int getStrikeCount(String userStr){
        int strike_count = 0;
        for (int i=0; i < VALUE_SIZE; i++){
            if (userStr.charAt(i) == computer_Value.charAt(i)) {
                strike_count++;
            }
        }
        return strike_count;
    }
    private int getBallCount(String userStr){
        int ballCount = 0;
        for (int userIdx =0; userIdx < VALUE_SIZE; userIdx++){
            for (int comIdx = 0; comIdx < VALUE_SIZE; comIdx++){
                if (comIdx == userIdx) continue;
                if (userStr.charAt(userIdx) == computer_Value.charAt(comIdx)) ballCount++;
            }
        }
        return ballCount;
    }
}