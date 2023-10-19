## 숫자 야구

#### 구현할 기능 목록
- 랜덤한 수 생성
    - 참고 사항
    
        - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
        - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    - 사용 예시
 
    
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    
-  게임 시작 출력

-  사용자 입력 및 입력값 대조

-  대조 결과에 따라 사용자 재입력 또는 결과 출력