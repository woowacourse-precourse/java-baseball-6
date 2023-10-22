package baseball;

public class Game {
    //사용자 객체
    //컴퓨터 객체

    public void start() {
        //게임 시작 멘트 출력
        //컴퓨터 객체에게 난수 생성
        // <-- 정답 맞출때까지 반복 -->
        //사용자 객체에게 입력 받기
        //입력 검증 -> checkInput()
        //문제 없으면 컴퓨터 객체에게 입력값에 대해서 결과값 검증
        //결과값 출력
        //만약 결과값 맞다 -> result 호출
    }

    public void checkInput() {

    }

    public void result() {
        //결과 출력하기
    }

    public void end() {
        //재시작할지 여부 묻기
        //사용자 객체에게 입력 받기
        //입력 검증 -> checkInput()
        //1 받았으면 start() 재호출, 2 받았으면 그대로 종료
    }
}
