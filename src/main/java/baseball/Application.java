package baseball;

public class Application {
    private static List<Integer> createRandomBaseballNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        // TODO: 숫자야구 시작 메시지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: computer 의 임의 숫자 생성
        List<Integer> baseball_num = createRandomBaseballNumber();
        // TODO: while 로 exception 또는 게임 종료 시까지 guess 진행
    }
}
