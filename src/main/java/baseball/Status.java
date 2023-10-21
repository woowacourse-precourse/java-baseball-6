package baseball;

public class Status {
    private int[] status;
    private int statusCode;
    public Status (int[] status) {
        this.status = status;
        this.statusCode = checkStatusCode();
    }
    /* 상태 코드에 따른 문자 처리 */
    public String toString () {
        switch (this.statusCode) {
            case 0 :
                return "낫싱";
            case 1 :
                return this.status[0] + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
            case 2 :
                return this.status[0] + "스트라이크";
            case 3 :
                return this.status[1] + "볼";
            case 4 :
                return this.status[1] + "볼" + " " + this.status[0] + "스트라이크";
        }
        return "오류";
    }
    /* [스트라이크, 볼, 아웃] 배열에 따른 상태 코드 확인 */
    private int checkStatusCode () {
        if (this.status[0] == 0) {
            if (this.status[1] == 0)
                return 0;
            return 3;
        }
        if (this.status[1] == 0) {
            if (this.status[2] == 0)
                return 1;
            return 2;
        }
        return 4;
    }
    /* 입력된 사용자 답에 대한 정답 여부 확인 */
    public boolean isCorrect () {
        if (statusCode == 1)
            return true;
        return false;
    }
}
