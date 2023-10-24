-[x] GameEngine
    - [x] 정답값을 입력받는다.
        - [x] 그 값이 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
        - [x] 세자리 음수이면, IllegalArgumentException 반환
        - [x] 0이 포함되어있을떄,IllegalArgumentException 반환

        -[x] 점수를 체점해준다.
            - [x] 체점가능한 숫자일경우, 채점을 해준다.
            - [x] 채점할 값이 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
            - [x] 0이 포함되어있을떄,IllegalArgumentException 반환

        -[x] 종료명령어를 판단한다.
            -[x] 1번을 입력되면, false를 반환.
            -[x] 2번을 입력되면, true를 반환.
            -[x] 1,2가 아니면, IllegalArgumentException 반환

-[x] BaseBallGameValidator
    - [x] baseballGame숫자를 검증한다.
        - [x] 그 값이 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
        - [x] 숫자가 아니면,IllegalArgumentException 반환
        - [x] 세자리 음수이면, IllegalArgumentException 반환
        - [x] 0이 포함되어있을떄,IllegalArgumentException 반환
    - [x] 엔드커멘드를 검증한다.
        -[x] 1이나2가 아니라면, 예외를 반환한다.

-[x] RandomNumberGenerator
    -[x] n자리의 숫자를 만들어준다.
        -[x] 중복되지않게 n자리의 숫자를 만든다.
-[x] InputReader
    -[x] 값을 읽는다
    -[x] 입력 지원을 멈춘다.

-[x] UI
    - [X] 게임 시작 문구를 출력한다.
    - [x] 게임 플레이중인 문구를 출력한다.
    - [x] 판단한 결과 값을 출력한다.
        -[x] 0볼,0스트라이크면,낫싱을 출력한다
        - [x] n볼,m스트라이크인경우, n볼 m스트라이크로 출력한다.
        - [x] n볼이나,m스트라이크만 있으면,n볼 혹은 m스트라이크만 나오게 한다.
    - [x] 게임 종료 문구가 나온다.

-[x] AppConfig
    -[x] 위에서 언급한 객체들을 팩토리 역할을 한다.

-[x] BaseBallGame
    -[x] 게임을 시작하게 해준다
        -[x] 초반의 문구를 출력한다.
        -[x] 플레이 문구와 게임 플레이를 진행한다.
        -[x] 플레이가 종료되면, 재시작할건지 물어본다.
            -[x] 재시작을 원한다면, 다시 플레이부터 시작한다.
        - [x] 종료되면, 입력하는 객체를 종료한다.  