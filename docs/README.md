## 필요한 기능 in Baseball Game

- 상수들을 모아둔 Costants class

  숫자야구 게임에서 쓰이는 상수들을 모아둠

- cpu와 플레이어의 숫자를 생성시키는 `NumberGenerator` class
    - `cpuRandomNumber()`
        - CPU 랜덤숫자 3자리 정수 반환하는 메서드. List<Interger>
    - `getPlayerNumber()`
        - 플레이어에게 3자리 정수 입력받아서 반환하는 메서드. List<Interger>
- 플레이어가 입력한 숫자를 검증하는 `ValidationPlayerNumber` class
    - 입력된 String을 숫자로 바꿔주는 코드 `changeListNumber(String)`
    - 입력된 String에 문자가 포함되어 있는지 검증하는 `isNumber(String)`
    - 플레이어가 입력한 값이 제대로 된 값인지 확인하는 `validatePlayerNumber(String)`
        - 잘못의 예)
            - 0을 입력했는지?
            - 중복된 값인지?
            - 3자리의 값이 아닌지?
            - 입력된 문자열에 숫자가 아닌 값이 포함되어 있는지?
- 야구게임의 룰을 정리한 `GameRule` class
    - `checkEndGame()`
        - 3 strike를 입력받으면 게임을 종료시키는 메서드 boolean
        - 그 이외가 입력되면 playingGame 메서드를 다시 실행시킴
    - `checkStrike(List<Integer>,List<Intrger>)`
        - 두 리스트를 비교해서 스트라이크의 갯수를 반환하는 메서드
        - 반환형 int
    - `playGameAgain(int)`
        - 게임을 다시 시작할지 말지 물어보는 메서드
    - `checkBalls(List<Integer>,List<Intrger>)`
        - 두 리스트를 비교해서 낫싱인지 아닌지 체크하는 메서드
        - 반환형 int
    - `checkNothing(List<Integer>,List<Intrger>)`
        - 두 리스트를 비교해서 볼의 갯수를 반환하는 메서드
        - 반환형 String
- 실제 게임이 이루어지는 과정을 담은 `BaseballGame` class
    - 게임을 초기화하는 `initiallizeGame()`
    - 게임을 다시 할지 물어보는 `askToPlayAgain()`
    - 게임의 결과를 출력하는 `printGameResult()`
    - 한 사이클의 게임 (시작 ~ 3스트라이크 까지)을 실행하는 `playSingleGame()`
    - 모든 사이클의 게임을 담당하는 `playWholeGame()`