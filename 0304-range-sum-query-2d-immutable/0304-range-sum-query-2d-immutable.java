

class NumMatrix {

    private int [][] sumMatrix;
    private int [][] elementMatrix;
    
    public NumMatrix(int[][] matrix) {
        this.elementMatrix=matrix;
        this.sumMatrix=new int[matrix.length+1][matrix[0].length+1];
        Sum(this.elementMatrix);

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int m=this.elementMatrix[0].length;
        int n=this.elementMatrix.length;
        
        int ans=sumMatrix[row2+1][col2+1]-sumMatrix[row2+1][col1]-sumMatrix[row1][col2+1]+sumMatrix[row1][col1];

        return ans;
    }
    
public void debug(int [][] matrix)
{
    for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
        for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
           System.out.print(matrix[i][j] + " ");
        }
        System.out.println(); //change line on console as row comes to end in the matrix.
     }
}

public void Sum(int matrix[][])
{
    int n=matrix.length;
    int m=matrix[0].length;

    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            sumMatrix[i][j]=sumMatrix[i-1][j]+sumMatrix[i][j-1]+this.elementMatrix[i-1][j-1]-sumMatrix[i-1][j-1];

        }
    }
    
}
}

