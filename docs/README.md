## 구현 기능 목록

### `23.10.25 16:30

1. Game, Player, Judge 클래스, 메소드 만들기

- Game
    - Member 변수 : `Player player`, `Judge judge`, `Computer computer`, `boolean gameOn`
    - `init()` - 멤버 변수들을 초기화해준다.
    - `start()` - 게임을 실행시킨다.
    - judge의 판단에 따라 게임을 계속 실행 혹은 종료시킨다.

- Player
    - Member 변수 : 유저가 입력한 숫자 3개를 입력받을 List<Integer>
    - `input()` : 사용자로부터 숫자 3개를 입력받는다.
    - `pitch()` : 입력맏은 숫자 3개로 게임을 한다.


- Judge - game finish 판단(a. player win and finish game, b. error input)
    - Member 변수 : `int strikes` :  strike 갯수, `int ball` : ball 갯수, `boolean finish` : 게임 종료 여부
    - `judgePitch(List<Integer> pitchNumbers)` : 유저가 던진 숫자 3개로 점수를 매긴다.
    - `callPitch()` : 플레이어의 피치를 허가한다.
    - `callSignal()` : 피치의 결과를 출력한다. ("m볼 n 스트라이크" 혹은 "낫싱")

### `23.10.25 18:30

1. Game, Player, Judge 메소드 중 예외처리 추가.

- fix
    - Game
        - `askGame()` - 유저로부터 입력 받은 값이 숫자 1 혹은 2인지 확인.

    - Player
        - `input()` : 유저로부터 입력 받은 값이 1~9 사이의 서로 다른 세 숫자로 구성되어 있는지 확인.
