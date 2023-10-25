package baseball;

public class User {
    private BaseBall baseBall;
    public User(final int first, final int second, final int third){
        baseBall = new BaseBall(first,second,third);
    }

    /***
     * 유저가 가진 BaseBall을 반환하는 메소드
     * @return BaseBall은 index3짜리 배열이다.
     */
    public int[] getPossessionBaseBall() {
        return baseBall.getNumbers();
    }

}
