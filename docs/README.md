# 구현 기능

### ApplicationContainer
- 애플리케이션 전체의 실행에 필요한 인스턴스들을 관리해주는 역할을 한다.
- ApplicationContainer 가 관리하는 인스턴스들은 호출 시점에 한 번만 생성되고 이후 재사용된다(singleton 패턴 적용).

### Controller
- Console 을 통해 받은 입력을 바탕으로 Service 를 호출하여 처리하고 처리된 결과를 Console 을 통해 플레이어에게 전달해주는 역할을 한다.

### Service
- 게임 생성, 초기화, 사용자 입력값 유효성 검사, 숫자 비교 결과 생성 등 숫자 야구 게임 내의 주요 비즈니스 로직을 담당한다.

### Domain
- Game : 현재 진행 중인 게임의 정보를 저장한다.

### Factory
- Game 인스턴스는 한 번 생성된 후 계속 초기화하여 재사용되므로 GameFactory 를 통해 한 번만 생성할 수 있도록 한다.

### Util
- RandomNumberGenerator : 지정한 자릿수와 최소, 최댓값을 가진 난수를 List 형식으로 반환한다.
- NumbersMatcher : 컴퓨터가 생성한 난수와 사용자가 입력한 숫자를 비교해준다.
- MatchResultParser : 볼, 스트라이크의 갯수를 분석하여 알맞은 String 결과를 생성해준다.
- inputValidator : 사용자로부터 입력받은 String 의 유효성 검사를 실행한다.

### Console
- 사용자로부터 값을 입력받거나 처리 결과를 출력해준다.