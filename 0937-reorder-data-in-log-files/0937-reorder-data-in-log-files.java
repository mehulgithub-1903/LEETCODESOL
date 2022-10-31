class Solution {
    
    public String[] reorderLogFiles(String[] logs) {
        
        Set<Character> digits=new HashSet<>();
        
        // for(char i='1';i<='9';i++) digits.add()
        
        PriorityQueue<String> pq=new PriorityQueue<>(
            ((String a,String b) ->
             
            contentOfLetterLog(a).compareTo(contentOfLetterLog(b))==0?((a.split(" ")[0]).compareTo(b.split(" ")[0])):contentOfLetterLog(a).compareTo(contentOfLetterLog(b))
            ));
        
        
        List<String> digiLogs=new ArrayList<String>();
        for(String e:logs)
        {
            if(isDigitLog(e))
            {
                digiLogs.add(e);        
            }
            else
            {
                pq.add(e);
            }
        }
        List<String> result=new ArrayList<String>();
        
        
        while(!pq.isEmpty())
        {
            result.add(pq.poll());
        }
        
        result.addAll(digiLogs);
        
        int n=logs.length;
        for(int i=0;i<n;i++) logs[i]=result.get(i);
        
        return logs;
    }
    public String contentOfLetterLog(String letterLog)
    {
        // String logs[]=letterLog.split(" ");
        // int n=logs.length;
        String content="";
        
//         for(int i=1;i<n;i++)
//         {
//             content+=logs[i];
//         }
        
        int index=letterLog.indexOf(' ');
        content=letterLog.substring(index+1);
        return content; 
    }
    public boolean isDigitLog(String log)
    {
        String arr[]=log.split(" ");
        
        if(Character.isDigit(arr[1].charAt(0)))
        {
            return true;
        }
        
        return false;
    }
}