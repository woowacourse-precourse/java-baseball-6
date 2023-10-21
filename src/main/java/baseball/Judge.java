package baseball;

public class Judge {
    private int strike;
    private int ball;

    private String result;

    public void judgeResult(String computerNumber, String userNumber) { // 들여쓰기 초과
        for (int i = 0; i < userNumber.length(); i++) {
            for (int j = 0; j < computerNumber.length(); j++) {
                if(userNumber.charAt(i) == computerNumber.charAt(j) && i == j) { // 스트라이크 증가
                    strike++;
                } else if (userNumber.charAt(i) == computerNumber.charAt(j)) { // 볼 증가
                    ball++;
                }
            }
        }
    }

    public String getResult() {
        setResult();
        return result;
    }

    private void setResult() {
        if (strike != 0 && ball != 0) { // N 스트라이크, N 볼
            result = ball + "볼 " + strike + "스트라이크";
        }
        if (strike != 0 && ball == 0) { // N 스트라이크, 노 볼
            result = strike + "스트라이크";
        }
        if (strike == 0 && ball != 0) { // 노 스트라이크, N 볼
            result = ball + "볼";
        }
        if (strike == 0 && ball == 0) { // 노 스트라이크, 노 볼
            result = "낫싱";
        }
    }

    public boolean checkThree() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); // 게임 종료 알림
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    public void reset() {
        strike =0;
        ball =0;
        result = "";
    }
}
