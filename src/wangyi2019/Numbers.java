package wangyi2019;

import java.util.Scanner;

/**
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * <p>
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * <p>
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 */

public class Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;

        for (int b = k + 1; b <= n; b++) {
            for (int point = k; point < b; point++) {
                //a的范围在point-n中 间隔为b
                if (n - point >= 0) {
                    int tempCount = (n - point) / b + 1;
                    count += tempCount;
                }
            }
        }
        System.out.println(count);
    }
}
