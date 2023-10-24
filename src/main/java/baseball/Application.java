package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    // baseball 게임의 ball, strike 저장 store
    public static class baseballStore {
        int ballCount = 0;
        int strikeCount = 0;

        public baseballStore(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 야구 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 랜덤으로 배열한 computer
        List<Integer> computer = getRandomNumberToList();

        // 게임 진행을 확인할 flag 변수
        boolean flag = true;
        while (flag) {
            // 입력
            System.out.print("숫자를 입력해주세요 : ");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            int num = 0;
            // 사용자의 입력값을 저장할 list
            List<Integer> list = new ArrayList<>();

            try {
                // 입력이 3자리인지, 자연수인지 확인하고 변환
                num = changeInteger(input);

                // List 변환
                list = integetToList(num);

                // 중복된 값이 있는지 확인
                if (checkDuplicated(list)) {
                    throw new IllegalArgumentException("중복된 값이 들어있습니다");
                }

            } catch (IllegalArgumentException e) {
                // Input error 발생 시, 프로그램 종료
                throw new IllegalArgumentException(e);
            }

            // ball, strike 갯수 저장소
            baseballStore store = new baseballStore(0, 0);
            for (int i = 0; i < list.size(); i++) {
                // computer 와 비교해보며 계산
                for (int j = 0; j < computer.size(); j++) {
                    // computer 값과 입력 값이 일치
                    if (computer.get(j) == list.get(i)) {
                        // 위치가 같으면, strike 갯수 올림
                        if (i == j) {
                            store.strikeCount++;
                        }
                        // 위치가 다르면, ball 갯수 올림
                        if (i != j){
                            store.ballCount++;
                        }
                    }
                }
            }

            // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
            StringBuilder sb = new StringBuilder();
            if (store.ballCount == 0 && store.strikeCount == 0) {
                sb.append("낫싱");
            }
            if (store.ballCount > 0) {
                sb.append(store.ballCount).append("볼");

                if (store.strikeCount > 0) {
                    sb.append(" ");
                }
            }
            if (store.strikeCount > 0) {
                sb.append(store.strikeCount).append("스트라이크");
            }
            System.out.println(sb);

            // 3 스트라이크인 경우, 게임 종료 or 재시작
            if (store.strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                try {
                    // 1 or 2 의 값을 입력 받고 예외 발생시, IllegalArgumentException 처리
                    int check = checkOneOrTwo(camp.nextstep.edu.missionutils.Console.readLine());

                    if (check == 1) {
                        // 게임을 재시작하기 위해, computer 값 변경
                        computer = getRandomNumberToList();
                    }
                    if (check == 2) {
                        // 게임 종료
                        flag = false;
                    }

                } catch (IllegalArgumentException e) {
                    // Input error 발생 시, 프로그램 종료
                    throw new IllegalArgumentException(e);
                }
            }
        }

    }

    // 3자리의 1 ~ 9의 랜덤한 값을 가지는 List 반환
    private static List<Integer> getRandomNumberToList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int checkOneOrTwo(String str) {
        try {
            int num = Integer.parseInt(str);

            if (num != 1 && num != 2) {
                throw new IllegalArgumentException("입력값이 1 또는 2가 아닙니다");
            }

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }

    // List에 중복된 값이 있는지 체크
    private static boolean checkDuplicated(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            return true;
        }

        return false;
    }

    // integer 값을 자릿수대로 List 자료형으로 변환
    private static List<Integer> integetToList(int num) {
        List<Integer> resultList = new ArrayList<>();
        while (num > 0) {
            resultList.add(num % 10);
            num /= 10;
        }

        Collections.reverse(resultList);
        return resultList;
    }

    /**
     *  String 자료형을 입력 형식에 맞게 Integer로 변환
     *  입력 형식: 3자리의 서로 다른 자연수
     */
    private static int changeInteger(String str) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다");
        }

        try {
            int num = Integer.parseInt(str);

            if (num < 0) {
                throw new IllegalArgumentException("입력값이 자연수가 아닙니다");
            }

            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다");
        }
    }
}
