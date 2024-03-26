package algorithm.lab_hw_0314;

import java.util.Scanner;

import static java.lang.System.in;

public class lab0_3 {
    public static void main(String[] args) {
        System.out.println("lab0_3: 이윤하");

        // 정렬되지 않은 배열 array, 정렬된 배열 sortedArray를 초기화
        int[] array = {120, 990, 130, 150, 20, 300, 400, 990, 40, 100, 110, 150, 60, 80, 190, 200};
        int sortedArray[] = {20, 40, 60, 80, 100, 110, 120, 130, 150, 150, 190, 200, 300, 400, 990, 990};

        // 검색할 원소를 입력받음
        Scanner scanner = new Scanner(in);
        int item = scanner.nextInt();
// 정렬되지 않은 배열 array에서 원소를 순차검색하여 위지(인덱스)를 출력
        System.out.println(sequentialSearch(array, item));
// 정렬된 배열 sortedArray에서 원소를 이진검색하여 위치(인덱스)를 출력
        System.out.println(binarySearch(sortedArray, 0, sortedArray.length-1, item));
        scanner.close();
    }

    // 정렬되지 않은 배열 array에서 원소를 순차검색하여 위치(인덱스)를 리턴; 검색 실패시 -1 리턴
    private static int sequentialSearch(int[] array, int item) {
        int res = -1;
        for(int i=0; i<array.length; i++){
            if(array[i] == item){
                res = i;
                break;
            }
        }
        return res;
    }
    // 정렬된 배열 sortedArray에서 원소를 이진검색하여 위치(인덱스)를 리턴; 검색 실패시 -1 리턴
    // 재귀알고리즘으로 구현해도 되고, 아니어도 됨. 재귀알고리즘으로 구현하지 않으려면 매개별수 from, to 필요 없음
    private static int binarySearch(int[] sortedArray, int from, int to, int item) {
        int res = -1;
        int mid = (from + to) / 2;
        if(from > to) return -1;
        if(sortedArray[mid] == item) {
            res = mid;
        } else{
            if(sortedArray[mid] > item){
                res = binarySearch(sortedArray, from, mid-1, item);
            } else{
                res = binarySearch(sortedArray, mid+1, to, item);
            }
        }
        return res;
    }

}
