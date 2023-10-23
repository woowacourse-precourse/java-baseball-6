package baseball;

public class Printer {

    //게임 시작 시 '숫자 야구 게임을 시작합니다.' 출력 기능
    public void printStartMent() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //숫자를 입력 받기 위해 '숫자를 입력해주세요 : ' 출력 기능
    public void printInputMent() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    //게임 종료 시 '게임을 새로 시작하려면 ~ 를 입력하세요.' 출력 기능
    public void printFinishMent() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    //게임 결과를 출력하는 기능
    public void printResult(int ball, int strike) {
        if (ball==0 && strike==0) {
            System.out.println("낫싱");
        }

        //볼 또는 스트라이크인 경우
        StringBuilder sb = new StringBuilder();
        if (ball!=0) sb.append(ball).append("볼 ");
        if (strike!=0) sb.append(strike).append("스트라이크");
        sb.append("\n");

        System.out.println(sb);
    }

}
