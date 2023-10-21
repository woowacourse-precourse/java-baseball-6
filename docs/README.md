자바 JDK 17버전인지확인

라이브러리 사용적용사항
1. camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
2. Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
3. 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

자바 기본요구사항
1. 블럭들여쓰기 스페이스 4
2. 열제한 120자/ 문자는 유니코드
3. 들여쓰기 줄바꿈시 원래줄에서 +8
4. 시작점은 Application의 main모드에서 모든테스트 성공해야함
5. System.exit();호출 안됨!!! (X)

게임 플레이어 돌아가는 사항
1. 게임플레이어는 컴퓨터가 생각하는 서로 다른 3개의 숫자입력, 컴퓨터가 입력한 숫자에 결과출력 3개 숫자
   입력 :서로 다른 3자리의 수, 게임끝나고 재시작/종료 1또는2로 선택
   출력: 하나도 없으면 낫싱
         볼,스트라이크 숫자로 표시
         하나도 맞는거 없다 낫싱표시
     
3. 과정반복 3개 숫자 모두 맞히면 종료
4. 게임 종료후 게임다시 시작, 완전히 종료
5. 사용자가 잘못된 값 입력 IllegalArgumentException후 종료


