class Solution {
    public void rotate(int[][] matrix) {

    int n=matrix.length;
    // find transverse of a matrix 
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<n;j++)
         {

             if(i<j) swap(matrix,i,j);
         }
     }


    // swap rows of the matrix
    
     for(int j=0;j<n;j++)
     {
         if(j>n-j-1) break;
         for(int i=0;i<n;i++)
         {
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][n-j-1];
            matrix[i][n-j-1]=temp;
         }
     }
    
    // return matrix;


    }
    public void swap(int [][] matrix,int i,int j)
    {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

}