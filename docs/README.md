<br>

# 기능 구현
### 숫자 하나를 포장하는 `Number.class` 생성

### Number객체를 List Collection으로 가지는 일급 컬렉션 객체 `NumberGroup.class` 생성
>#### 예외처리
>1. List의 크기가 3인지 확인
>2. 중복된 숫자가 있는지 확인

### 에러를 확인하는 `Error.class`
1. 숫자 여부를 확인하는 `is_Not_Number()`
2. 숫자의 개수를 확인하는 `check_Numsize()`
3. 중복된 숫자 여부를 확인하는 `is_Duplicate()`
4. 게임 재시작 시 맞는 숫자가 들어갔는지 확인하는 `exit_error_check()`

### 유저의 숫자와 컴퓨터의 숫자를 비교하는 `Compare.class`
1. 유저의 숫자들이 컴퓨터의 숫자를 포함하고 있는 개수를 리턴하는 `contain()`
2. 유저의 숫자와 컴퓨터의 숫자의 위치와 값이 같은 개수를 리턴하는 `correct()`
3. 유저에게 힌트를 제공해주는 `Output()`
4. 유저의 승리 여부를 확인하는 `success()`
5. 포함 개수 리턴 `getContain()`, Strike 개수 리턴 `getStrike()`, ball 개수 리턴 `getBall()`

### 게임을 진행하는 `Game.class`
1. 게임을 이긴 뒤 2를 누르면 게임이 종료되고 1을 누르면 게임이 재시작되도록 하는 `play()`
2. 유저의 숫자와 컴퓨터의 숫자들을 `compare.class`를 이용하여 비교해 결과값을 출력하는 'game()'
3. 유저가 키보드로 숫자를 입력하는 `Input_user_num()`
4. 게임을 종료할지 확인하는 `not_exit()`