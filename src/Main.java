import java.util.*;

class Answer {
    // 서로 다른 3자리 숫자 생성
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        // 1부터 9까지의 숫자를 리스트에 추가
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        // 리스트를 랜덤하게 섞고 앞에서 3개의 숫자를 뽑아서 정답으로 설정
        Collections.shuffle(numbers);

        // 3자리 숫자 반환
        return numbers.subList(0, 3);
    }

    // 사용자 입력 받기
    public static List<Integer> input() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("세자리 숫자를 입력하세요 (중복 없는 숫자로 구성) : ");

        while (true) {
            String inputStr = sc.nextLine();

            // 입력값이 숫자가 아닌 경우 오류 처리
            if (!inputStr.matches("\\d{3}")) {
                System.out.println("올바른 3자리 숫자를 입력하세요.");
                continue;
            }

            // 입력값을 중복 없는 숫자로 확인
            Set<Character> digitsSet = new HashSet<>();
            for (char digit : inputStr.toCharArray()) {
                digitsSet.add(digit);
            }

            if (digitsSet.size() != 3) {
                System.out.println("중복되지 않는 세 자리 숫자를 입력하세요.");
                continue;
            }

            for (char c : inputStr.toCharArray()) {
                numbers.add(Character.getNumericValue(c));
            }

            return numbers;  // 올바른 입력일 때 리스트 반환
        }
    }

    // 입력값과 정답 비교하여 결과 출력
    public static void compareNumbers(List<Integer> answer, List<Integer> userInput) {
        int strikes = 0;
        int balls = 0;

        // 스트라이크와 볼 계산
        for (int i = 0; i < answer.size(); i++) {
            if (userInput.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(userInput.get(i))) {
                balls++;
            }
        }

        // 결과 출력
        if (strikes == 3) {
            System.out.println("정답입니다! 3 스트라이크로 게임이 종료됩니다.");
            System.exit(0);  // 게임 종료
        } else {
            System.out.println(strikes + " 스트라이크, " + balls + " 볼");
            if (strikes == 0 && balls == 0) {
                System.out.println("아웃!");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        // 정답 생성
        List<Integer> answer = Answer.generateNumbers();
        System.out.println("게임이 시작되었습니다!");

        // 게임 반복
        while (true) {
            // 사용자 입력
            List<Integer> userInput = Answer.input();

            // 입력값과 정답 비교
            Answer.compareNumbers(answer, userInput);
        }
    }
}
