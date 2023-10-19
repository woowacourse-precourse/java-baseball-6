## 개요

프로그램은 다음의 3 개의 객체 위주로 구성한다.

### Game

전체 게임을 진행할 클래스이다. <br>
사용자와 컴퓨터 클래스의 메서드를 호출하여 게임을 진행하며, 게임의 흐름을 주관한다.

### Player

사용자의 입력을 처리한다.

### Computer

게임에서 사용할 3자리 수를 선택하고, 입력에 대한 결과를 반환한다.

## 기능

### Game
- [ ] `void startGame()`
  - 전체 게임 흐름을 진행한다.
    - 첫 게임 실행
    - 게임이 끝난 후 재시작/종료 여부를 파악
    - 재시작의 경우 다시 게임을 실행
- [ ] `void play()`
  - 한 번의 게임을 진행한다.
    - 컴퓨터에게 숫자를 선택하게 함
    - 사용자가 정답을 맞힐 때 까지 다음을 반복
      - 사용자에게 서로 다른 3개의 숫자를 입력 받음
      - 컴퓨터에게 결과를 받아온다.
      - 컴퓨터가 알려준 결과를 출력

**주의!!** 프로그램의 종료 전에 `Console`의 `close()`메서드 호출해주기

### Player

- [ ] `List<Integer> getInput()`
  - 사용자의 입력을 `List` 형태로 반환
    - 서로 다른 3개의 숫자
  - **throws** : 잘못된 입력의 경우 `IllegalArgumentException`
- [ ] `int inputMenu()`
  - 사용자의 입력을 정수로 반환
    - 재시작 : 1
    - 종료 : 2
  - **throws** : 잘못된 입력의 경우 `IllegalArgumentException`

### Computer

- [ ] `void init()`
  - 게임에서 사용할 3개의 숫자를 선택
- [ ] `List<Result> getResult(List<Integer> input)`
  - 사용자의 입력 값에 대해 `enum Result`의 리스트를 반환한다.