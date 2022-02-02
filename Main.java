import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int factorial(int n) { // ищем факториал
        return (n > 0) ? n * factorial(n - 1) : 1;
    }

    static boolean isPalindrome(List<Integer> list) { // можно ли список сделать палиндромным
        boolean result = false;
        int oddCount = 0;
        LinkedList<Integer> nums = new LinkedList<>(list);
        Collections.sort(nums);
        for (int i = 1; i < nums.size(); ) {
            if (oddCount == 2) break;
            if (nums.get(0).equals(nums.get(i))) {
                nums.remove(0);
                nums.remove(0);
            } else if (nums.size() == 2 && !nums.get(0).equals(nums.get(1))) {
                oddCount++;
                break;
            } else {
                oddCount++;
                nums.remove(0);
            }
        }
        if (oddCount <= 1 && nums.size() <= 1) result = true;
        return result;
    }

    public static void selectionSort(int[] array) { // Сортировка выбором
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int right = left+1; right < array.length; right++) {
                if (array[right] < array[minIndex]) {
                    minIndex = right;
                }
            }
            if (minIndex != left) {
                int temp = array[left];
                array[left] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        for (int x: array) System.out.print(x + " ");
    }

    public static void main(String[] args) {
        int[] nums = {6,2,12,9,3,21,4,17,54,2,145,7};
        selectionSort(nums);

        System.out.println();

        System.out.println(factorial(1));
        System.out.println(factorial(3));
        System.out.println(factorial(6));
        System.out.println(factorial(9));

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        System.out.println(isPalindrome(numbers)); // true
        numbers.clear();

        numbers.add(2);
        numbers.add(4);
        numbers.add(4);
        numbers.add(2);

        System.out.println(isPalindrome(numbers));  // true
        numbers.clear();


        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(isPalindrome(numbers)); // false
        numbers.clear();

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        // 1, 2, 3 true
        // 2, 4, 4, 2 true
        // 1, 2, 3 false
        // 1, 2, 4, 3, 5, 6, 7, 4, 5, 3, 2, 1 false
        // 1, 2, 4, 3, 5, 6, 5, 3, 2, 1 true
        // 1, 7, 4, 3, 5, 6, 7, 4, 5, 3, 2, 6 false

        System.out.println(isPalindrome(numbers)); // false
        numbers.clear();

        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        System.out.println(isPalindrome(numbers));  // true
        numbers.clear();

        numbers.add(1);
        numbers.add(7);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);

        System.out.println(isPalindrome(numbers));  // false

    }
}
