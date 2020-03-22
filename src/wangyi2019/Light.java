package wangyi2019;

/*小Q正在给一条长度为n的道路设计路灯安置方案。

为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。

小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。

小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。*/

import java.util.Scanner;

public class Light {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int size = scanner.nextInt();
            String road = scanner.next();

            int lightSize = calc(road, size);
            System.out.println(lightSize);
        }
    }

    private static int calc(String road, int size) {

        if (road.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < road.length(); i++) {
            char c = road.charAt(i);
            if (road.charAt(i) == '.') {
                count++;
                i = i + 2;
            }

        }
        return count;
    }
}
