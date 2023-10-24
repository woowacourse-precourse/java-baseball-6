package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//코드에 중복이 되는 요소가 없는가?
//한 메서드에 너무 많은 기능이 들어가 있지는 않는가?
//객체 간 기능의 분리가 잘 되어있는가?
//리팩토링
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

//Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
//사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

//        int pickNumberInList(final List<Integer> numbers)
//  리스트 안 숫자 체크( 볼? )

//        int pickNumberInRange(final int startInclusive, final int endInclusive)
//        List<Integer> pickUniqueNumbersInRange
//        List<T> shuffle(final List<T> list)
//        void validateNumbers(final List<Integer> numbers)
//        void validateRange(final int startInclusive, final int endInclusive)
//        void validateCount(final int startInclusive, final int endInclusive, final int count)
//        String readLine() {
//                return getInstance().nextLine();
//            }
//        void close()
//        Scanner getInstance()

        int strike = 0;
        int ball;
        //1. 서로 다른 3자리의 수를 입력받는 객체
        System.out.println("숫자 야구 게임을 시작합니다.");
        //기능구현 3
        boolean flag = false;
        while (!flag) {
            List<Integer> random_nums = make_random_nums();
            while (strike != 3) {
                try {
                    strike = 0;
                    ball = 0;
                    System.out.print("숫자를 입력해주세요 : ");
                    String str_baseball_num = Console.readLine();
                    int baseball_num = Integer.parseInt(str_baseball_num);
                    //지금 asdf 넣으면 에러생김 예외처리 필수

                    if (100 <= baseball_num && baseball_num < 1000) {
                        //기능구현 1
                        String strBaseball_num = Integer.toString(baseball_num);
                        char[] Baseball_numArr = strBaseball_num.toCharArray();
                        //기능구현 2
                        if (Baseball_numArr[0] != Baseball_numArr[1] && Baseball_numArr[1] != Baseball_numArr[2]
                                && Baseball_numArr[0] != Baseball_numArr[2]) {

                            //기능구현 4 입력으로 3개 받아서 스트라이크 볼 낫싱 확인

                            //스트라이크 확인하는거
                            //i j가 같으면 strike for문 사용, 다른경우는 ball +=1
                            System.out.println("\n checking random nums  " + random_nums);
                            System.out.println("checking intput nums  " + baseball_num);

                            //비교하는 좋은 방법 체크
                            //그리고 객체 분리.
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
//                                    System.out.println("int i= " + i +"  int j= " + j);
                                    if (i == j) {
//                                        System.out.println(random_nums.get(i));
//                                        System.out.println(Character.valueOf(Baseball_numArr[j]));
                                        if (random_nums.get(i) == Character.getNumericValue(Baseball_numArr[j])) {
//                                            System.out.println("strike checking");
//                                            System.out.println("Random num " + i + "= " + random_nums.get(i));
//                                            System.out.println("User num " + j + "= " + Baseball_numArr[j]);
                                            strike++;
                                        }
                                    } else {
                                        if (random_nums.get(i) == Character.getNumericValue(Baseball_numArr[j])) {
//                                            System.out.println("ball cheking");
//                                            System.out.println("Random num " + i + "= " + random_nums.get(i));
//                                            System.out.println("User num " + j + "= " + Baseball_numArr[j]);
                                            ball++;
                                        }
                                    }
                                }
                            }
                            if (ball != 0) {
                                System.out.print(ball + "볼" + " ");
                            }
                            if (strike != 0) {
                                System.out.print(strike + "스트라이크" + " ");
                            }
                            if (ball == 0 && strike == 0) {
                                System.out.print("낫싱");
                            }
                            System.out.println();

                        } else {
                            throw new IllegalArgumentException("OMG! you input over the same of two numbers. Error.");
                        }

                    } else {
                        throw new IllegalArgumentException("OMG! should input the nums well in range. Error.");
                    }
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("no. should not input out of variable");
                }
                //-- 0< num <1000
                //-- 변수 숫자가 아니어도 오류
                //-- tochararray 변환해서 length 3자리 이상일경우 IllegalArgumentException
                // try catch문으로 IllegalArgumentException e로 처리.
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            boolean flag3 = false;
            while (!flag3) {
                //!flag3 = true
                try {

                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String choice = Console.readLine();
                    if (choice.length() != 1) {
                        System.out.println("should input only 1");
                    } else if (Integer.parseInt(choice) == 1) {
                        System.out.println(choice);
                        flag3 = true;
                        strike = 0;
                    } else if (Integer.parseInt(choice) == 2) {
                        flag = true;
                        flag3 = true;
                        System.out.println("게임 종료");
                    } else {
                        throw new IllegalArgumentException("Should input num 1 or 2");
                    }
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("no. should not input out of variable");
                }
            }


        }
        Console.close();

    }

    public static List<Integer> make_random_nums() {
        List<Integer> computer = new ArrayList<>();
        //리스트에 1~9까지 넣는데 이미 포함되어있으면 작업 X 크기 3까지 작업
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}