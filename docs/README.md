# BaseBall 기능 구현 목록
1. 1-9 숫자를 랜덤으로 3개 저장한다. 
2. 사용자로부터 1-9 숫자로 이루어진 3자리의 문자열을 입력받는다.
3. 랜덤숫자와 사용자로부터 입력받은 숫자를 비교한다.
   - 인덱스가 같으면 '스트라이크'
   - 인덱스가 같지않지만 일치하는 숫자가 존재하면 '볼'
   - 일치하는 숫자가 없으면 '낫싱'으로 처리한다.
4. 결과값을 출력한다.
5. 모든 값이 정확히 일치하면 게임승리, 아니라면 2번부터 다시 진행한다.
6. 재시작 여부를 사용자에게 묻는다 ( 1 : 재시작, 2 : 종료 )
7. 재시작을 선택하면 1번부터 다시 진행한다. 종료를 선택하면 게임을 종료한다.
  



### BaseController.java
- 전체 게임 관리
- game() 을 진행하고, 게임이 종료된 후 restart 여부를 묻는다.
- 사용자가 재시작을 선택하면 게임을 다시 진행한다.
- 재시작을 원하지 않는다면 게임을 종료한다.


### BaseService.java
- BaseService : 인터페이스, BaseServiceImpl : 구현체
- service.game() - 1번의 게임 관리
  - 중복없는 랜덤의 숫자 3개를 Randoms 라이브러리를 사용해 Baseball 객체에 저장한다.
  - 사용자로부터 1-9숫자를 3개 입력받는다.
  - 사용자가 입력한 숫자와 랜덤숫자를 비교한 값을 메세지로 출력한다.
  - 사용자가 입력한 숫자와 랜덤의 숫자가 정확히 일치할때까지 반복한다.
  
- service.isRestart() - 사용자가 재시작을 원하면 true, 원하지 않으면 false 을 반환한다.

### InputRepository.java
- InputRepository : 인터페이스, InputRepositoryImpl : 구현체
- Template 을 사용한다.
- 해당하는 메세지와 검증메서드를 Template에 전달한다.

### MessageTemplate.java, Callback.java
- InputRepository 에서 전달받은 메세지와 Valid를 템플릿에 맞게 출력한다.
- 메세지 출력 -> 사용자 입력 -> Valid 유효성검사 -> return 사용자입력값

### BaseRepository.java
- BaseRepository : 인터페이스, BaseRepositoryImpl : 구현체
- getMyNumber() : InputRepository에서 검증된 값을 List<Integer>로 변환한다.
- confirmNumber() : 사용자가 입력한 값과 정답값을 비교해서 결과를 int[] result로 반환한다.
- printMessage() : int[] result를 사용해서 메세지를 출력한다.


### Domain : Baseball.java
- Randoms.pickNumberInRange() 를 사용해 랜덤값을 List<Integer>에 중복값 없이 넣는다.
- List는 final로 관리한다.

### BaseConst.java
- 의미없는 정수값들을 상수로 사용한다.

### Valid.java
- 검증로직