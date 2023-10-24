package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //step0. 게임 시작
        GameRunner.gameStart();
        while(true) {
            //step1. 랜덤 숫자 생성하거나 이전 랜덤 숫자 반환
            GameRunner.makeNumbers();
            //step2. 사용자 입력
            GameRunner.readInput();
            //step3. 사용자 입력을 바탕으로 스트라이크/볼 개수 기록
            GameRunner.count();
            //step4. 결과 출력
            GameRunner.printResult();
            //step5. 만약 결과가 3strike라면 게임을 새로 시작할건지 사용자에게 질문
            if(GameRunner.isEnd()) {
                return;
            }
        }
    }
}
