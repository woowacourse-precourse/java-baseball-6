package baseball.view;

public class InputMessage {
    public void requestNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void callBallCount(int[] count) {
        String temp_string = "";
        int ball = count[0];
        int strike = count[1];
        if (ball == 0 && strike == 0) temp_string = "낫싱";
        if (ball != 0) temp_string += ball + "볼 ";
        if (strike != 0) temp_string += strike + "스트라이크";
        System.out.println(temp_string.trim());
    }
}
