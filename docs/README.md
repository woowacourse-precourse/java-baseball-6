## 개요

프로그램은 다음의 4 개의 객체로 구성한다.

### Game

전체 게임을 진행할 클래스이다. <br>
사용자와 컴퓨터 클래스의 메서드를 호출하여 게임을 진행하며, 게임의 흐름을 주관한다.

### Player

사용자의 입력을 처리한다.

### Computer

게임에서 사용할 3자리 수를 선택하고, 입력에 대한 결과를 반환한다.

### Result

사용자의 입력에 대한 결과를 표시

## 기능

### Game

- [x] `void startGame()`
    - 엔트리 포인트
    - 전체 게임 흐름을 진행한다.
        - 첫 게임 실행
        - 게임이 끝난 후 재시작/종료 여부를 파악
        - 재시작의 경우 다시 게임을 실행
- [x] `void play()`
    - 한 번의 게임을 진행한다.
        - 컴퓨터에게 숫자를 선택하게 함
        - 사용자가 정답을 맞힐 때 까지 다음을 반복
            - 사용자에게 서로 다른 3개의 숫자를 입력 받음
            - 컴퓨터에게 결과를 받아온다.
            - 컴퓨터가 알려준 결과를 출력

**주의!!** 프로그램의 종료 전에 `Console`의 `close()`메서드 호출해주기

### Player

- [x] `List<Integer> getInput()`
    - 사용자의 입력을 `List` 형태로 반환
        - 서로 다른 3개의 숫자
    - **throws** : 잘못된 입력의 경우 `IllegalArgumentException`
- [x] `boolean restart()`
    - 재시작 여부를 입력받아 `boolean`으로 반환
        - 재시작 : 1 -> `true`
        - 종료 : 2 -> `false`
    - **throws** : 잘못된 입력의 경우 `IllegalArgumentException`

### Computer

`List<Integer> answer` : 랜덤으로 선택된 정답을 저장

- [x] `void init()`
    - 게임에서 사용할 3개의 숫자를 선택
- [x] `Result getResult(List<Integer> input)`
    - 사용자의 입력 값에 대해 `Result` 객체를 반환한다.

### Result

`int strike`: 결과의 strike 수<br>
`int ball` : 결과의 ball 수

- [x] `void addStrike()`
    - strike 값 증가
- [x] `void addBall()`
    - ball 값 증가
- Override :
    - toString()
    - equals()
    - hashCode()