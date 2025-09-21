public class TrapeziumPattern {
    public static void main(String[] args) {
        int N = 3;
        int size = 2 * N - 1;

        for (int i = 1; i <= size; i++) {
            if (i == 1 || i == size) {
                // first & last row
                for (int j = 1; j <= N - 1; j++) System.out.print("*");
                System.out.print(".");
                for (int j = 1; j <= N - 1; j++) System.out.print("*");
            } 
            else if (i == N) {
                // middle row
                for (int j = 1; j <= size; j++) System.out.print(".");
            } 
            else {
                // other rows
                System.out.print("*");
                for (int j = 1; j <= size - 2; j++) System.out.print(".");
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
