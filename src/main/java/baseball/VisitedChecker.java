package baseball;

public class VisitedChecker {
    private boolean[] userVisited;
    private boolean[] answerVisited;
    public VisitedChecker (int numberLength) {
        this.userVisited = new boolean[numberLength];
        this.answerVisited = new boolean[numberLength];
    }
    /* 인덱스를 입력받아, 정답, 유저 입력 두 방문 배열에 입력받은 인덱스를 방문처리 */
    public void checkVisited (int index) {
        this.userVisited[index] = true;
        this.answerVisited[index] = true;
    }
    /* 인덱스를 입력받아, 정답 방문 배열에만 입력받은 인덱스를 방문처리 */
    public void checkVisitedForAnswer (int index) {
        this.answerVisited[index] = true;
    }
    /* 인덱스를 입력받아, 정답 방문배열의 입력받은 인덱스가 방문했는지 확인 */
    public boolean isVisitedForAnswer (int index) {
        return this.answerVisited[index];
    }
}
