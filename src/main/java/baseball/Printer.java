package baseball;

public interface Printer {
    //숫자를 입력 받기 위해 '숫자를 입력해주세요 : ' 출력 기능
    public void printInputMent();

    //게임 종료 시 '게임을 새로 시작하려면 ~ 를 입력하세요.' 출력 기능
    public void printFinishMent();

    //게임 결과를 출력하는 기능
    public String printResult(int ball, int strike);

}
