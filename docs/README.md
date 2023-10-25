# 미션 - 숫자 야구

## 요구 사항 점검

1. 기능 요구 사항
    - [x] 1부터 9까지 서로 다른 수로 이루어진 3가지릐 수를 만드는가?
    - [x] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이라는 힌트를 제공하는가?
    - [x] 정답을 맞춘 경우 게임을 다시 시작할 수 있도록 하는가?
    - [x] 사용자가 잘못된 값을 입력 할 경우 `IllegalArgumentException`을 발생시킨후 게임을 종료하는가?
2. 프로그래밍 요구 사항
    - [x] JDK 17 를 사용하는가?
    - [x] 프로그램 실행의 시작점은 `Application` 의 `main()`인가?
    - [x] `build.gradle` 파일을 변경하지 않고, 외부 라이브러리를 사용하지 않는가?
    - [x] 프로그램 종료 시, `system.exit()` 을 호출하지 않는가?
    - [x] `ApplicationTest`의 모든 테스트가 성공했는가?
    = [x] 요구 사항에서 명시하지 않는 파일, 패키지 이름을 수정하거나 이동하지 않았는가?

## 구현 기능 목록

### Game.class
#### 게임을 진행하는 클래스로 게임의 시작과 종료에 관한 구현이 되어 있다.
- public void start()
    - 게임을 시작한다. game()의 반환 값에 따라 게임을 계속 진행 할 것인지를 결정한다.
- public boolean game()
    - 사용자에게 값을 입력 받고 숫자야구를 실행한다. 숫자 야구 게임이 종료 되기 전, 사용자에게 입력받은 값을 기반으로 다시 진행 할 것인지 여부를 파악한다.

### Number.class
#### 사용자가 맞춰야 하는 수와 관련된 클래스로 맞추어야 하는 정답을 생성하거나, 볼 혹은 스트라이크와 같은 정답 유무를 판단한다.
- public void generateAnswer()
    - 숫자 야구 게임을 위한 정답을 생성한다. 처음 숫자는 0이 될 수 없으며, 그 외에 2개의 숫자는 1부터 9 사이의 값을 가진다.
- public int genNumber(int first, int last)
    - first 와 last 범위 안의 랜덤한 숫자를 만든다.
- public int checkBall(List<Integer> predict)
    - predict list 에 담긴 값(사용자로부터 입력 받은 값)에 자리는 같지 않으나, 숫자는 같은 값의 갯수를 반환한다.
- public int checkStrike(List<Integer> predict)
    - predict list 에 담긴 값(사용자로부터 입력 받은 값)에 자리와 숫자가 모두 동일한 갯수를 반환한다.
- public List<Integer> checkAnswer(List<Integer> predict)
    - 사용자로부터 입력받은 값을 통해 볼과 스트라이크의 갯수를 세어 그 갯수를 반환한다.

### Util.class
#### 게임에 진행되는데에 필요한 메소드들이 구현되어 있다. 객체 생성 없이 사용하기 위해 static method 로 구현되어 있다.
- public static List<Integer> getNumberFromUser() throws IllegalArgumentException
    - 사용자로부터 정답을 입력받는다. 입력값에 문제가 있는 경우 IllegalArgumentException 을 발생시킨다.
- public static boolean isValidNumber(List<Integer> number)
    - 사용자에게 입력받은 값이 게임을 진행하는데 유효한 값인지 검증한다. 검증 기준은 다음과 같다.
        - 입력한 숫자가 3자리 수 이상인 경우
        - 입력한 숫자의 범위가 102부터 1000 사이가 아닌 경우
        - 중복된 숫자를 입력한 경우