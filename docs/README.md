# 기능목록
***
>* 게임 시작
>* 컴퓨터가 생성하는 1 ~ 9까지 임의의 세 자리수 만들어서 반환
>* 사용자의 입력을 받음
>* 사용자 입력이 잘못돼서 예외가 터졌을 때 처리하는 메서드
>* 컴퓨터의 수와 사용자의 수를 비교해서 결과 담음 
>* 결과 판별하고 출력
>* 다시 시작 혹은 종료


# 구현하면서 찾아본 내용
***
>* camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 메서드 내부에서  
>private static final Random defaultRandom = ThreadLocalRandom.current();  
>defaultRandom.nextInt(endInclusive - startInclusive + 1); 사용됨을 확인  
>동시성 문제를 해결하기 위해 각 쓰레드마다 생성된 인스턴스에서 각각 난수를 반환  
>따라서 Random과 같은 경합 문제가 발생하지 않아 안전하며, 성능상 이점이 있는 것으로 확인  
>pickNumberInRange()는 첫 번째 인자가 최소 정수, 두 번째 인자가 최대 정수
>* ApplicationTest 에서 java.lang.IllegalStateException: Could not initialize plugin: interface org.mockito.plugins.MockMaker (alternate: null)  
>오류가 발생 mockito-core와 byte-buddy가 최신버전이면 오류가 사라질 가능성이 있음을 확인  
>build.gradle에 최신버전으로 의존성 추가해서 해결  
>
>* 기존에 있던 테스트 "게임종료_후_재시작"에서 인자에 문제가 있어보여서 수정
>테스트코드를 다시 생각해보니 테스트코드 오류가 아닌, 랜덤 숫자를 받아올 때 하나씩 세번 받아와야 되는데 한번에 세 자리수를 받아와서 문제가 생긴것으로, 랜덤숫자 생성 구현의 방식을 변경해야 함  
>기존 README 구현 예시가 있었으나 유심히 보지않아서 문제발생....  
>요구사항과 관련된 문서를 더 자세히 보도록 노력이 필요함  
>
>* 일급컬렉션  
>    * 비즈니스에 종속적인 자료구조  
>    * 컬렉션의 불변성 보장  
>    * 상태와 행위를 한 곳에서 관리  
>    * 이름이 있는 컬렉션
>
>* 커밋 규약
>    * 기본적인 커밋 구조  
>      type: subject, body, footer  
>    * 커밋 타입  
>      feat : 새로운 기능 추가  
>      fix : 버그 수정  
>      docs : 문서 수정  
>      style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우  
>      refactor : 코드 리팩토링  
>      test : 테스트 코드, 리팩토링 테스트 코드 추가  
>      chore : 빌드 업무 수정, 패키지 매니저 수정  
>      build : 빌드 관련 파일 수정에 대한 커밋  
>      docs : 문서 수정에 대한 커밋  
>      form : 코드 형식, 정렬, 주석 등의 변경 커밋  
>      release : 버전 릴리즈 커밋  
>      init : 프로젝트 생성 후 첫 커밋  
>    * Subject  
>   제목은 50자를 넘기지 않고, 대문자로 시작하고 마침표를 붙이지 않음.  
>   과거 시제를 사용하지 않고 명령어로 작성.  
>   ex) "Fixed" -> "Fix" ,  "Added" -> "Add"  
>    * body  
>    선택사항  
>    부연설명이 필요하거나 커밋의 이유를 설명할 경우 작성  
>    72자를 넘기지 않고 제목과 구분되기 위해 한칸을 띄워 작성  
>    * footer  
>   선택사항  
>   issue tracker id를 작성할 때 사용  
>    * EX) feet: Summarize changes





