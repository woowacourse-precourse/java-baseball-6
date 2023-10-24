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

---

## 2. 각 객체에서 사용할 함수 (기능)

### Game

- [X]  `void startGame()`
    - 게임 흐름을 진행한다.
        - 처음 코드 실행 시 첫 게임 실행
        - 게임이 종료 후 재시작 여부 확인
        - 재시작의 경우 다시 게임을 실행
- [X]  `void play()`
    - 한 번의 게임을 진행한다.
        - 컴퓨터에게 숫자를 선택하게 함
        - 사용자가 정답을 맞힐 때 까지 다음을 반복
            - 사용자에게 서로 다른 3개의 숫자를 입력 받음
            - 컴퓨터가 힌트를 제작
            - 제작된 힌트를 출력

⚠️ 프로그램의 종료 전에 `Console`의 `close()`메서드 호출해주기

### Player

- [ ]  `List<Integer> getInput()`
    - 사용자의 입력
        - 서로 다른 3개의 숫자를 `List` 형태로 제작

- [ ]  `boolean getRestart()`
    - 재시작 여부를 입력
        - 재시작  `true`
        - 종료  `false`

⚠️ 잘못된 입력의 경우 `IllegalArgumentException`

### Computer

- [ ]  `List<Integer> makeAnswer`
    - 랜덤으로 선택된 정답을 저장
- [ ]  `Result getResult(List<Integer> input)`
    - 사용자의 입력 값에 대해 `Result` 객체를 반환

### Result

`int strike`: 결과의 strike 수

`int ball` : 결과의 ball 수

- [ ]  `void addStrike()`
    - strike 값 증가
- [ ]  `void addBall()`
    - ball 값 증가