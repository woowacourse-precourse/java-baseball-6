## 필요한 기능 in Baseball Game

- 상수들을 모아둔 costants class

  숫자야구 게임에서 쓰이는 상수들을 모아둠

- cpu와 플레이어의 숫자를 생성시키는 numberGenerator class
    - cpuRandomNumber()
        - CPU 랜덤숫자 3자리 정수 반환하는 메서드. List<Interger>
    - getPlayerNumber()
        - 플레이어에게 3자리 정수 입력받아서 반환하는 메서드. List<Interger>
- 플레이어가 입력한 숫자를 검증하는 validationPlayerNumber class
    - validatePlayerNumber(List<Integer>)
        - 플레이어가 입력한 값이 제대로 된 값인지 확인하는 메서드. boolean
        - 잘못의 예)
            - 0을 입력했는지?
            - 중복된 값인지?
            - 3자리의 값이 아닌지?
- 야구게임의 룰을 정리한 gameRule class
    - checkEndGame()
        - 3 strike를 입력받으면 게임을 종료시키는 메서드 boolean
        - 그 이외가 입력되면 playingGame 메서드를 다시 실행시킴
    - checkStrike(List<Integer>,List<Intrger>)
        - 두 리스트를 비교해서 스트라이크의 갯수를 반환하는 메서드
        - 반환형 int
    - playGameAgain(int)
        - 게임을 다시 시작할지 말지 물어보는 메서드
        - *이때 숫자 이외의 값을 입력했을때 1 혹은 2를 다시 입력하게 유도함 → else 써서 구현했기에 수정 필요*
    - checkBalls(List<Integer>,List<Intrger>)
        - 두 리스트를 비교해서 낫싱인지 아닌지 체크하는 ㅔㅁ서드
        - 반환형 int
    - checkNothing(List<Integer>,List<Intrger>)
        - 두 리스트를 비교해서 볼의 갯수를 반환하는 메서드
        - 반환형 String
- playGame()
    - 실제 게임이 이루어지는 메서드
    - *메서드가 길기 때문에 나중에 분리 필요.*