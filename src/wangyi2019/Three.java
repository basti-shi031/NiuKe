package wangyi2019;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long l = scanner.nextLong();
        long r = scanner.nextLong();

        long delta = r - l + 1;
        long count1 = delta / 3 * 2;
        long addition = delta % 3;
        if (l % 3 == 0) {
            if (addition == 0) {
                System.out.println(count1);
            } else if (addition == 1 || addition == 2) {
                System.out.println(count1 + 1);
            }
        } else if (l % 3 == 1) {
            if (addition == 0 || addition == 1) {
                System.out.println(count1);
            } else if (addition == 2) {
                System.out.println(count1 + 1);
            }
        } else {
            System.out.println(count1 + addition);
        }
    }
}
