package algorithm.lab_hw_0307;

import java.util.Scanner;

public class lab0_1 {
    /**
     * 사용자가 원하는 개수의 정수값들을 입력받아 평균값을 구하고, 그 정수값들 중에서 평균갑보다 큰 것이 총 몇 개인지 구하세요
     *
     * - 입력: 정수 개수(n), n개의 정수
     * - 출력: 평균값, 평균값보다 큰 정수 개수
     *
     * - 실행 예:
     *  lab0_1: 이윤하
     *  10
     *  1 2 3 4 5 6 7 8 9 10
     *  5.5
     *  5
     */
    public static void main(String[] args) {
        System.out.println("lab0_1: 이윤하");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 입력받은 수만큼의 크기를 가진 배열 생성
        int[] arr = new int[n];

        int sum = 0; // 초기화

        // 입력받은 수만큼의 정수값을 배열에 저장하고 합을 구함
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 평균값 구하고 출력
        double avg =  (double) sum / n;
        System.out.println(avg);

        int cnt = 0; // 초기화

        // 평균값보다 큰 정수의 개수를 구함
        for (int i = 0; i < n; i++) {
            if (arr[i] > avg) {
                cnt++;
            }
        }
        // 출력
        System.out.println(cnt);
        sc.close();
    }
}
