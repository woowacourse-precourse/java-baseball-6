-[ ] GameEngine
    - [ ] 서로 다른 임의의 수 3개를 선택한다
        - [ ] 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
    -[ ] 점수를 체점해준다.
    - [ ] 채점할 값이 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
        -[ ] 게임을 종료시킨다.
    -[ ] 게임이 종료한 후에, 1번을 입력되면,게임을 다시 시작한다.
    -[ ] 게임이 종료한 후에,2번을 입력되면,완전히 종료할수 있다.
    -[ ] 1,2가 아니면, IllegalArgumentException 반환

-[ ] BaseBallGameValidator
    - [x] baseballGame숫자를 검증한다.
        - [x] 그 값이 같은 값이 있거나, 3개가 아닌 수를 선택하면,IllegalArgumentException 반환
        - [x] 숫자가 아니면,IllegalArgumentException 반환
        - [x] 세자리 음수이면, IllegalArgumentException 반환

-[x] InputReader
    -[x] 값을 읽는다
    -[x] 입력 지원을 멈춘다.

-[ ] UI
    - [X] 게임 시작 문구를 출력한다.
    - [x] 게임 플레이중인 문구를 출력한다.
    -[ ] 판단한 결과 값을 출력한다.
    - [ ] 게임 종료 문구가 나온다.
        -[ ] 게임 종료 관련 문구가 출력한다.

