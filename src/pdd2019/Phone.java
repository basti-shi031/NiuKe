package pdd2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
输入描述:
第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
数据范围：
2 <= K <= N <= 10000*/
public class Phone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Map<Character, Integer> maps = new HashMap<>();
        String s = scanner.next();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
        }
    }

}
