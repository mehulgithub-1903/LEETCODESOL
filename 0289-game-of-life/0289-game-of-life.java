class Solution {
    // new State - 0 to 1 ->2


    public void gameOfLife(int[][] board) {
    
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                checkElement(i,j,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=1;
                      
                }
                if(board[i][j]==-2)
                {
                    board[i][j]=0;
                }
            }
        }

        // return board;



    }
    public void checkElement(int i,int j,int board[][]) 
    {
        int dir[]=new int[]{1,-1,0,0,1,-1,-1,1};
        int dic[]=new int[]{0,0,-1,1,1,1,-1,-1};
        
        
            int live=0;
            int dead=0;
            for(int x=0;x<8;x++)
            {
                int nx=i+dir[x];
                int ny=j+dic[x];
                if (checkValid(nx,ny,board))
                {
                    if(board[nx][ny]==0 || board[nx][ny]==2)
                    {
                        dead++;
                    }
                    if(board[nx][ny]==1 || board[nx][ny]==-2)
                    {
                        live++;
                    }
            
                }
            }

            if(board[i][j]==1)
            {
                if(live<2 || live>3)
                {
                    board[i][j]=-2;
                }
    
            }
            else
            {
                if(live==3)
                {
                    board[i][j]=2;
                }
            }
            
        

    }
    public boolean checkValid(int i,int j,int [][] board)
    {
         int m=board.length;
        int n=board[0].length;
        if(i>=0 && i<m && j>=0 && j<n)
        {
            return true;       
        }

        return false;
    }
}