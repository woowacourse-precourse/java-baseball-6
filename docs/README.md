# 기능 목록 정리 - 숫자 야구

## 1. 사용할 객체

→ Game, Player, Computer, Result 4개의 객체로 구성

### Game

게임을 진행 할 클래스

사용자, 컴퓨터 클래스의 메소드를 호출하며 게임을 진행

### Player

사용자의 입력을 처리

### Computer

게임에서 사용할 임의의 수를 선택

### Result

사용자 입력에 대한 힌트 제공

### Validate

입력에 대한 예외처리

---

## 2. 각 객체에서 사용할 함수 (기능)

### Game

- [x]  `void startGame()`
    - 게임 흐름을 진행한다.
        - 처음 코드 실행 시 첫 게임 실행
        - 게임이 종료 후 재시작 여부 확인
        - 재시작의 경우 다시 게임을 실행
- [x]  `void play()`
    - 한 번의 게임을 진행한다.
        - 컴퓨터에게 숫자를 선택하게 함
        - 사용자가 정답을 맞힐 때 까지 다음을 반복
            - 사용자에게 서로 다른 3개의 숫자를 입력 받음
            - 컴퓨터가 힌트를 제작
            - 제작된 힌트를 출력

### Player

- [x]  `List<Integer> getInput()`
    - 사용자의 입력
        - 서로 다른 3개의 숫자를 `List` 형태로 제작

- [x]  `boolean getRestart()`
    - 재시작 여부를 입력
        - 재시작`true`
        - 종료`false`

### Computer

- [x]  `List<Integer> makeAnswer`
    - 랜덤으로 선택된 정답을 저장
- [x]  `Result getResult(List<Integer> input)`
    - 사용자의 입력 값에 대해`Result`객체를 반환

### Result

`int strike`: 결과의 strike 수

`int ball`: 결과의 ball 수

- [x]  `void addStrike()`
    - strike 값 증가
- [x]  `void addBall()`
    - ball 값 증가

### Validate

- [x]  `validate`
    - 오버로딩을 통해 잘못된 입력값에 `IllegalArgumentException`
    - 매개변수 종류
        - `String[]`,  `Set<Integer>` , `String` , `int`