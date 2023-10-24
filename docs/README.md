# 미션 - 숫자 야구

## 요구사항
+ 기능 요구사항
    + 기본적으로 1투거 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
    + 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

+ 입력 요구사항
    + 서로 다른 3자리의 수
    + 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수

+ 출력 요구사항
    + 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

## 구현할 기능

+ model
    +
+ view
    + static List<Integer> inputNumber() : 사용자의 숫자 입력을 받는 함수
    + static boolean
    + static void check(List<Integer> computer, List<Integer> user): 게임의 결과를 출력하는 함수
+ control
    + static void game(): 게임을 시작하는 함수
    + static void play():
### 테스트
