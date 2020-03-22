package wangyi2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 */

public class Sleep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> an = new ArrayList<>();
        List<Integer> tn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            an.add(a);
        }

        int total = 0;
        int max = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            tn.add(t);
            if (t == 1) {
                total += an.get(i);
            }
        }

        if (k >= n) {
            System.out.println(total);
            return;
        }

        for (int i = 0; i < n - k + 1; i++) {
            if (last == -1) {
                last = 0;
                //第一次计算
                for (int j = 0; j < k; j++) {
                    int t = tn.get(j);
                    if (t == 0) {
                        last += an.get(j);
                    }
                }
                max = last;
            } else {
                if (tn.get(i - 1) == 0) {
                    last = last - an.get(i - 1);
                }
                if (tn.get(i + k - 1) == 0) {
                    last = last + an.get(i + k - 1);
                }

                if (last > max) {
                    max = last;
                }
            }
        }
        System.out.println(max + total);
    }
}
