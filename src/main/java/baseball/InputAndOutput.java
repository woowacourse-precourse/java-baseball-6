package baseball;

public class InputAndOutput {

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void scanInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void gameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void checkInputNumber(int[] strikeAndBall) {
        String message = switch (strikeAndBall[0]) {
            case 1 -> "1볼 ";
            case 2 -> "2볼 ";
            case 3 -> "3볼 ";
            default -> "";
        };

        message += switch (strikeAndBall[1]) {
            case 1 -> "1스트라이크";
            case 2 -> "2스트라이크";
            case 3 -> "3스트라이크";
            default -> "낫싱";
        };

        System.out.println(message);
    }
}
