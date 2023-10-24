package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] com = Creator.getComputer();  // 컴퓨터 숫자 얻기
        int[] user;  // 사용자 숫자 입력받을 배열
        while (true) {
            Counter counter = new Counter();  // 이번 게임에서 얻을 카운트 계산 객체
            user = Creator.getUser();  // 사용자 입력 얻기
            counter.checkCounts(com, user, counter);  // 카운트 계산
            if (counter.isCorrect()) {  // 카운트 출력하고 사용자 숫자가 컴퓨터 숫자와 일치하는지 검사
                if(!Manager.restart()){  // 일치한다면 재시작 여부 묻기
                    break;  // 게임 종료
                }
                com = Creator.getComputer();  // 재시작을 위해 컴퓨터 숫자 재생성
            }
        }
    }
}
