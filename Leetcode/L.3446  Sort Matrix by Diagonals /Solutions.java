import java.util.*;
class Solutions {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for (int i = 0; i < n; i++) sortDiagonal(grid, i, 0, false);
        for (int j = 1; j < n; j++) sortDiagonal(grid, 0, j, true);
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();

        int i = row, j = col;
        while (i < n && j < n) {
            diagonal.add(grid[i][j]);
            i++;
            j++;
        }
        
        if (increasing) {
            Collections.sort(diagonal);
        } else {
            Collections.sort(diagonal, Collections.reverseOrder());
        }
        
        i = row;
        j = col;
        int idx = 0;
        while (i < n && j < n) {
            grid[i][j] = diagonal.get(idx++);
            i++;
            j++;
        }
    }
    public void printmatrix(int arr[][])
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=ob.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=ob.nextInt();
            }
        }
        Solutions obj=new Solutions();
        arr= obj.sortMatrix(arr);
        obj.printmatrix(arr);
    }
}