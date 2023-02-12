class Pair
{
    char c;
    int f;
    Pair(char c,int f){
        this.c=c;
        this.f=f;
    }

}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();

        for(char x:s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.add(new Pair(x,1));
            }

            else
            {
                if(x==st.peek().c)
                {
                    st.peek().f=st.peek().f+1;
                    if(st.peek().f==k) st.pop();
                }
                else
                {
                    st.add(new Pair(x,1));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
        {
            Pair x=st.pop();
            for(int i=0;i<x.f;i++)
            {
                ans.append(x.c);
            }
        }

        ans=ans.reverse();
        return ans.toString();
    }
}