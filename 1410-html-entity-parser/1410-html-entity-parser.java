class Solution {
    public String entityParser(String s) {
        
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            
            if(s.charAt(i)=='&')
            {
                // boolean flag=false;
                if(i+3<n)
                {
                    String temp=s.substring(i+1,i+4);
                    // System.out.println(temp);
                    if(temp.equals("gt;"))
                    {
                        sb.append(">");
                        i+=3;
                        continue;
                        
                    }
                    else if(temp.equals("lt;"))
                    {
                        sb.append("<");
                        i+=3;
                        continue;
                    }
                }
                if(i+4<n)
                {
                    
                    String temp=s.substring(i+1,i+5);
                    // System.out.println(temp);
                    if(temp.equals("amp;"))
                    {
                        sb.append("&");
                        i+=4;
                        continue;
                    }
                }
                if(i+5<n)
                {
                   String temp=s.substring(i+1,i+6);
                    // System.out.println(temp);
                    if(temp.equals("apos;"))
                    {
                        sb.append("'");
                        i+=5;
                        continue;
                    }
                    else if(temp.equals("quot;"))
                    {
                        sb.append('"');
                        i+=5;
                        continue;
                    } 
                }
                if(i+6<n)
                {
                    String temp=s.substring(i+1,i+7);
                    if(temp.equals("frasl;"))
                    {
                        sb.append("/");
                        i+=6;
                        continue;
                    }
                }
                
            }
                sb.append(s.charAt(i));
            
        }
        return sb.toString();
    }
}