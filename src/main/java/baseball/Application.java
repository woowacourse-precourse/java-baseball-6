package baseball;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){ //숫자 야구 진행
            Game game = new Game(); //게임 인스턴스 생성 및 게임 상태 초기화
            game.startGame(); //게임 시작
            if(!game.isRestart()) //게임의 재시작 여부 결정
                break;
        }
    }
}
