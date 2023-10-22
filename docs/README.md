## 🎯 기능목록


### 입력기능
- 사용자의 입력을 받음 [v]
- 사용자의 입력이 요구사항에 맞는지 검사 [v]
  

### 출력기능
- 게임 진행에 대한 메시지 출력 [v]


### 숫자야구 기능
- 사용자 입력에 대한 볼, 스트라이크, 낫싱 연산
- 게임 종료 후 사용자의 입력에 따라 재시작 혹은 종료
- 사용자가 잘못된 입력값을 입력 시 IllegalArgumentExcepti가on 발생 후 게임 종료

내가 고민한것
- 기능들을 어떻게 분리하여 class를 제작할지
  - 입력만을 담당하는 InputManager, 출력만을 담당하는 OutPutManager, 게임 진행을 담당하는 ?로 구성
  
- 게임에서 자주 출력되는 메시지들을 어떻게 관리하다 할까 properties 파일로 추출록
  - 모든 메시지에 대한 출력 메서드를 만들까하다가 하나의 command 기반의 메서드로 구현, 이게 좋은 방법인지는 추후 판단이 필요함  

- InputManager의 Scanner Buffer 단순히 출력만 해주는 역할이기에 static final로 선언하고 싶었음
  - 위처럼 선언하기 위해서는 thread safe해야하는데 Scanner은 thread safe하지 않기에 buffer를 선택 