# 구현할 기능 목록

## playGame
- parameter: X
- return: X
- 게임을 시작하는 기능. 안에서 1.랜덤 숫자를 생성하고 2.사용자의 입력을 받고 3. 입력값 유효성 검사와 결과 출력을 담당함.

## generateRandomNumberList
- parameter: 생성할 숫자의 최소값, 생성할 숫자의 최대값, 숫자 생성 횟수.
- return: array 형태의 3자리 숫자.
- 단순히 pickNumberInRange 기능을 3번 쓰는 것보다, 정확하게 '몇개'의 숫자를 생성하는지 명시 해주는 것이 좋다고 판단했다.

## getInputFromUser
- parameter: 출력할 메시지 내용.
- return: 사용자의 입력값.
- 숫자를 입력해달라는 메시지를 출력하고, 사용자의 입력값을 입력받는 기능.

private static List<Integer> parseInput(String input) {
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            inputList.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return inputList;
    }

    private static int[] calculateResult(List<Integer> inputList, List<Integer> answerList) {
        int[] result = new int[2]; // result[0] = strike, result[1] = ball
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputList.get(i).equals(answerList.get(j))) {
                    if (i == j) {
                        result[0]++; // Strike
                    } else {
                        result[1]++; // Ball
                    }
                }
            }
        }
        return result;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }

    private static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        return restart.equals("1");
    }

## parseInput
- parameter: 사용자의 입력값.
- return: array 형태의 3자리 숫자.
- 사용자의 입력값을 3자리 숫자로 변환하는 기능.

## calculateResult
- parameter: 사용자의 입력값, 랜덤 숫자.
- return: array 형태의 결과값.
- 사용자의 입력값과 랜덤 숫자를 비교하여 결과값을 계산하는 기능.

## printResult
- parameter: 결과값.
- return: X
- 결과값을 출력하는 기능 (낫싱, 볼, 스트라이크).

## playAgain
- parameter: X
- return: 입력값이 1인지 아닌지 확인.
- 게임을 다시 시작할지 종료할지를 결정하는 기능.