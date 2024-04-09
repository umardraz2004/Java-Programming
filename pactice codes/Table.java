public class Table {
    public static void main(String[] args) {
        System.out.println("Using backslash t");
        System.out.println("Integer Square Cube");
        System.out.println("0\t0\t0");
        System.out.println("1\t1\t1");
        System.out.println("2\t4\t8");
        System.out.println("3\t9\t27");
        System.out.println("4\t16\t64");
        System.out.println("5\t25\t125");
        System.out.println("6\t36\t216");
        System.out.println("7\t49\t343");
        System.out.println("8\t64\t512");
        System.out.println("9\t81\t729");
        System.out.println("10\t100\t1000");
        System.out.println("Using Arithmetic operators");
        System.out.println("Integer Square Cube");
        for(int i = 0; i<=10; i++) {
            System.out.println(i + "\t" + (i*i) + "\t" + i*i*i);
        }
    }
}
