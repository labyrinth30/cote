package algorithm.lab_hw_0530;

import java.util.Arrays;
import java.util.Scanner;

public class Main_201911016 {
    public static void main(String[] args) {
        System.out.println("hw11_1: 이윤하");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 동전 액면의 개수
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins); // 동전을 정렬함

        if (!isMultiple(coins)) System.out.println("그리디 알고리즘은 최적해를 보장하지 않습니다");

        int amount = sc.nextInt(); // 거스름돈 액수

        int[] result = change(coins, amount); // 거스름돈을 계산함
        if (result == null) System.out.println("원하는 거스름돈 액수를 맞출 수 없습니다.");

        for (int i = n - 1; i >= 0; i--) {
            // 계산 결과 출력
            if (result[i] > 0) {
                System.out.println(coins[i] + " x " + result[i]);
            }
        }
        sc.close();
    }

    private static boolean isMultiple(int[] coins) {
        for (int i = coins.length - 1; i > 0; i--) {
            // 동전을 내림차순으로 정렬했고, 가장 큰 동전부터 그 뒤의 동전이 배수인지 검사함
            if (coins[i] % coins[i - 1] != 0) { // 현재 동전이 이전 동전 액면의 배수가 아닌 경우
                return false; // 그리디 알고리즘은 최적해를 보장하지 않음 을 출력
            }
        }
        // 모든 동전 종류가 서로 배수 관계인 경우
        return true;
    }


    private static int[] change(int[] coins, int amount) {
        int[] result = new int[coins.length];
        for (int i = coins.length - 1; i >= 0; i--) {
            // 가장 큰 동전부터 거스름돈 계산
            result[i] = amount / coins[i]; // 몫은 해당 동전의 개수
            amount %= coins[i]; // 나머지는 다음 동전으로 거스름돈 계산
        }
        if (amount > 0) { // 거스름돈을 계산하고 남은 액수가 있는 경우
            return null; // 거스름돈 액수를 맞출 수 없는 경우
        }
        return result; // 계산결과 목록을 반환
    }
}
