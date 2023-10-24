package baseball;

public class Counter {
    private int ball;
    private int strike;

    // 사용자 숫자와 컴퓨터 숫자 기반 카운트 계산 메서드
    public void count(int[] com, int[] user) {
        for (int i = 0; i < user.length; i++) {
            if (user[i] == com[i]) {  // 위치가 같으면 스트라이크 증가
                strike++;
                continue;
            }
            for (int computer : com) {
                if (user[i] == computer) {  // 숫자만 같으면 볼 증가
                    ball++;
                }
            }
        }
    }

    // 카운트를 기반으로 숫자가 일치하는지 검사하는 메서드
    public boolean isEqual() {
        if (strike == 3) {  // 3 스트라이크라면 true 반환
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    // 카운트 출력 문자열을 반환하는 메서드
    public String print() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball);
            sb.append("볼 ");
            if (strike != 0) {
                sb.append(strike);
                sb.append("스트라이크");
                return sb.toString();
            }
            return sb.toString();
        }
        if (strike != 0) {
            sb.append(strike);
            sb.append("스트라이크");
            return sb.toString();
        }
        sb.append("낫싱");
        return sb.toString();
    }
}
