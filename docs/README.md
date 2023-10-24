구현할 기능 목록 및 주의 사항
1. 1~9까지의 난수는 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
2. 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
   3. Domain, Service, View, Controller로 나누어 개발
        3.1 Domain
           - 객체의 정보를 담는 역할
             @Game : 볼, 스트라이크, 3개의 난수를 저장할 변수 선언
             @User : 정답과 비교할 사용자 입력 값을 저장

        3.2 Service
           - 컨트롤러의 역할이 커지면 복잡, 유지보수가 어렵기 때문에 같이 사용, 서비스는 비즈니스 로직을 처리하고 컨트롤러에 필요한 데이터 및 동작을 제공하는 역할
             @GameService : 게임의 규칙에 맞게 설정할 부분을 설정하고, 정답에 따라 볼, 카운트를 카운팅한다.
             @Parser : 입력 문자열이 제한을 초과하면 종료, 입력 문자열을 숫자로 변경
             @RamdomNumber : 난수 생성 (주의 사항 확인)
      
        3.3 View
            - 사용자에게 보여지는 화면(UI), 기본적으로 모델과 컨트롤러와의 종속성 없이 구현

        3.4 Controller
            - MVC 패턴의 핵심으로, 모든 사용자 요청의 중심 -> 어떤 작업 수행 시 특정 뷰로 요청이 가는 것이 아닌 컨트롤러에서 우선적으로 요청 처리, 특정 뷰를 지정해야 하므로 뷰와 종속 관계 발생
