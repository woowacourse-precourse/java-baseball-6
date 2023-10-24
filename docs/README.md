# 숫자 야구 게임 기능 구현 리스트

### 랜덤한 컴퓨터 세 자리 수 생성
- 컴퓨터가 생성한 세 자리 수를 보관할 자료구조 ArrayList<Integer> 생성
- camp.nextstep.edu.missionutils.Randoms.pickNumberInRange 메서드를 사용하여 숫자 하나씩 생성하여 list의 크기가 3이고, 중복된 값이 없을 때까지 list에 추가.

### 유저가 세 자리 숫자 입력
- 유저가 입력한 세 자리 수를 보관할 자료구조 ArrayList<Integer> 생성
- String이 리턴값인 camp.nextstep.edu.missionutils.Console.readLine 메서드를 사용하여 값 입력받음.

### 유저가 잘못 입력했거나, 정답을 맞춘 후 종료하기 누르기 전까지 반복
- while문을 이용하여 boolean exit를 초기값을 false로 설정하고 while(!exit)을 통해 계속 입력을 반복

### 입력값 검증 and int형으로 형변환
- 유저가 입력한 값이 String 값이 아니면 NumberFormatException으로 나오는 예외를 IllegalArgumentException로 바꾸어 예외를 던짐.
- parse한 값이 111보다 작거나 999보다 크면 예외 던짐(IllegalArgumentException.class)

### 컴퓨터가 생성한 List와 사용자가 입력한 List 비교 후 result 배열에 값 보관 
- 컴퓨터가 생성한 3자리 수 List와 사용자가 입력한 List를 자릿수별 각각 비교하여 자릿수 && 숫자가 모두 맞으면 result[0] 스트라이크 ++
- 숫자는 맞지만 자릿수가 맞지 않으면 result[1] 볼 ++

### 출력
- result[0]이 3이 아니라면 result[1] + 볼 + result[0] + 스트라이크 형식으로 출력.
- result[0]과 result[1]의 값이 모두 0이면 자릿수도, 숫자도 모두 안맞는 것이기 때문에 낫싱 반환.
- result[0] 값이 3이면 3스트라이크로, 게임 종료. GameSet 메시지 띄우고 retry물어봄.
- retry에서 1을 입력했다면 다시 초기단계로 돌아가서 게임 재진행. 2를 입력 시 게임 종료.
  - 입력값이 2라면 exit를 false로 변경 후(종료) camp.nextstep.edu.missionutils.Console.close 메서드를 사용하여 Scanner를 종료하고 게임 종료. 
  - 입력값이 1 or 2가 아니라면 IllegalArgumentException.class 예외 던짐.
