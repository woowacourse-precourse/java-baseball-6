## 구현해야할 기능

### User class 구현

야구게임 유저인 user를 구현한다

* inputNum() : 유저 입력을 받아 BaseballNum class를 만든다
* boolean chooseRestart() : 유저 입력을 받아 RestartNum class를 만든다
* BaseballNum getUserNum() : userNum을 반환해준다

### Computer class 구현

야구게임 상대방인 computer를 구현한다

* Computer() : 기본적인 생성자로 게임이 시작하면 정답이 될 번호를 고른다
* boolean checkNum() : User가 고른 번호와 Computer가 고른 번호를 비교해서 그에따른 대답을 해준다

### BaseballNum class 구현

야구게임에서 사용하는 1 ~ 9 범위의 수 3개를 가지고있는 class(일급 컬렉션)이다

* BaseballNum(String) : 문자열을 메개변수로 받아 초기화해주는 생성자이다 이때 잘못된 값이 들어오면 IllegalArgumentException을 발생시킨다
* BaseballNum() : 기본적인 생성자로 랜덤한 수 3개를 얻어 초기화해주는 생성자이다
* int getNum(int) : 원하는 index의 값을 반환해준다
* int isSamePositionNum(BaseballNum) : 비교할 BaseballNum을 받아서 자신의 값과 같은 인덱스에 같은 값을 가지고있는 개수를 반환한다
* int isContainsNum(BaseballNum) : 비교할 BaseballNum을 받아서 자신의 값과 같은 개수를 반환한다

### CheckBaseballNum class 구현

BaseballNum class의 유효성을 검사해주는 class이다

boolean isError(string) : 문제가 발생하면 true 문제가 없으면 false를 반환해준다
boolean isCorrectRange(string) : 값이 1 ~ 9 사이로 맞게 들어왔는지를 검사해준다
boolean isDuplicated(string) : 중복된 값이 있는지 검사해준다
boolean isDigit(char num) : 값이 1 ~ 9 사이인지 검사해준다

### RestartNum class 구현

재시작을 선택하는 값 1 ~ 2 범위의 수 1개를 가지고 있는 class(일급 컬렉션)

* restartNum() : 기본적인 생성자로 입력을 받아서 값을 변수에 넣어준다 이때 잘못된 값이 들어오면 IllegalArgumentException을 발생시킨다
* int getRestartNum() : 값을 반환해준다

### CheckRestartNum class 구현

RestartNum class의 유효성을 검사해주는 class이다

* boolean isError(String) : 문제가 발생하면 true 문제가 없으면 false를 반환해준다
* boolean isCorrectValue(string) : string의 값이 맞는 값(1 or 2)인지 판단해준다

### Printer class 구현

야구게임에서 스트라이크 볼 낫싱을 판정해 print해주는 class이다

* baseball(int strike int ball) : strike, ball 개수를 바탕으로 그에맞는 메소드를 호출해준다
* boolean isNothing(int strike, int ball) : ball과 strike가 하나도 없는지 확인한다
* boolean isAll(int strike, int ball) : ball과 strike가 하나 이상씩 존재하는지 확인한다
* boolean isBall(int ball) : ball이 하나 이상 존재하는지 확인한다
* boolean isStrike(int strike) : strike가 하나 이상 존재하는지 확인한다
* nothing() : 낫싱을 출력해준다
* all(int strike int ball) : ball과 strike를 출력해준다
* ball(int ball) : ball을 출력해준다
* strike(int strike) : strike를 출력해준다

### Util Class 구현

여러 class에서 공통으로 사용하는 메소드를 구현해둔 class이다

* boolean isCorrectLength(String, int) : String의 길이가 맞는길이(int)인지 판단해준다
* boolean isNull(String) : String이 null인지 판단해준다