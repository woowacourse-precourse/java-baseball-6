# 요구사항 분석

## ⚙️ 필요한 기능

### ✔️ 게임 진행을 컨트롤: `GameController.class`

- 게임시작 기능: `gameStart()`
    - '게임시작문구' 출력
    - '사용자입력값' 받기
- 게임종료 기능: `handleGameActive()`
    - 정답을 맞출 시 '게임종료문구' 출력
    - 사용자 입력값에 따라 '게임재시작' 및 '게임종료' 핸들링
- 게임점수 출력 기능: `reportGameResult()`
- 게임결과에 따른 점수('strike', 'ball')를 출력

### ✔️ 게임에 사용할 숫자 컨트롤: `NumberController.class`

- 게임 정답 생성 기능: `generateComputerNumberList()`
    - 정답조건: 1부터 9까지 서로 다른 수로 이루어진 3자리 수
- 3자리 숫자를 각자리 숫자의 배열로 나누는 기능: `splitter()`
    - ex) 입력값: 123 ->  배열: {1,2,3}
- 두 개의 숫자배열을 비교하여 점수를 측정하는 기능: `compareNumberList()`
    - 게임점수란 'strike'와 'ball' 각각의 개수
        - 인덱스와 값이 모두 같으면 'strike': `contStrike()`
        - 인덱스는 다르나 같은 값이 있으면 'ball': `countBall()`

### ✔️ 사용자 입력값 유효성 체크: `InputValidatorController.class`

- 게임정답 입력값이 세자리 숫자가 아닌경우: `validateThreeDigitNumber()`
- 정답을 맞춘 후 게임진행 입력값이 1이나 2가 아닌경우: `validateGameProgressNumber()`