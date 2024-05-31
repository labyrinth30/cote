package algorithm.lab_hw_0530;

import java.util.Arrays;
import java.util.Scanner;

public class Main_201911016 { // '학번'을 실제 학번으로 변경하세요.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 이름 변경

        int n = sc.nextInt(); // 동전 액면 갯수
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins); // 동전 액면 정렬

        if (!isMultiple(coins)) {
            System.out.println("그리디 알고리즘은 최적해를 보장하지 않습니다");
        } else {
            int amount = sc.nextInt(); // 거스름돈 액수
            int[] result = change(coins, amount);
            if (result == null) {
                System.out.println("원하는 거스름돈 액수를 맞출 수 없습니다.");
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    if (result[i] > 0) {
                        System.out.println(coins[i] + " x " + result[i]);
                    }
                }
            }
        }
        sc.close();
    }

    private static boolean isMultiple(int[] coins) {
        for (int i = coins.length - 1; i > 0; i--) {
            if (coins[i] % coins[i - 1] != 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] change(int[] coins, int amount) {
        int[] result = new int[coins.length];
        for (int i = coins.length - 1; i >= 0; i--) {
            result[i] = amount / coins[i];
            amount %= coins[i];
        }
        if (amount > 0) {
            return null; // 거스름돈 액수를 맞출 수 없는 경우
        }
        return result;
    }
}
