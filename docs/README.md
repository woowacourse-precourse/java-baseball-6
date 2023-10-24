# 우테코 프리코스 1주차 미션 - 숫자 야구

## 🔍 기능 구현 


### 🚀 random_pick()

1. 1~9까지의 랜덤한 숫자 3개가 set에 삽입된다.
2. set의 사이즈가 3이 될 때까지 while문이 돌아간다.
3. 중복되지 않은 3개의 숫자가 담긴 set을 list (answer) 로 변환한다.
4. answer를 리턴한다. 

### 🚀 input_number()

* 입력값을 받는 함수이다. 
* 사용자가 입력한 3개의 중복되지 않은 숫자를 입력받는다.
* 숫자의 길이가 3자리를 초과하거나 / 중복되는 숫자가 있거나 / 숫자가 아닌 경우를 판별하여 IllegalArgumentException()를 throw한다.

### 🚀 check_StrikeAndBall()
* 정상적으로 입력된 값을 for문을 이용하여 스트라이크와 볼을 카운트한다.
* answer과 자릿수와 숫자 모두 같다면 strike가 증가, 그렇지 않은 경우 answer가 해당 값을 포함하고 있다면 ball을 증가시킨다.
* 판별 이후, ball과 strike의 수를 출력한다.
* ball과 strike가 모두 0일 경우에는 낫싱을 출력한다.

### 🚀 check_StrikeAndBall()
* 숫자를 모두 맞힌 경우, 1이나 2를 입력하여 게임을 재시작 할지, 혹은 종료할지 선택할 수 있다.
* 1을 입력 시, 새로운 숫자가 담긴 answer를 생성하고 다시 while문이 돌아가며 숫자야구를 시작한다.
* 2를 입력 시, while문을 빠져나오며 게임이 종료된다.
* 이외의 숫자 입력 시, IllegalArgumentException()를 throw한다.

### 🛵 main 함수 

1. random_pick() 함수를 이용해 랜덤 숫자 3개를 담은 answer_list 생성
2. 숫자 야구 게임 시작 알림 메시지 
3. while문으로 숫자야구 진행 
* input_number() -> check_StrikeAndBall() -> EndOrRestart(조건부) 순서로 반복된다. 




