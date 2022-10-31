
public class MyComparator implements Comparator<String>
{
    @Override
    public int compare(String s1, String s2)
    {
        int indexOfSpace1=s1.indexOf(" ");
        int indexOfSpace2=s2.indexOf(" ");

        String identifier1 = s1.substring(0,indexOfSpace1+1);
        String identifier2 = s2.substring(0,indexOfSpace2+1);
        String content1=    s1.substring(indexOfSpace1+1);
        String content2=    s2.substring(indexOfSpace2+1);
        
        
        char firstCharacterS1 =s1.charAt(indexOfSpace1+1);
        char firstCharacterS2 =s2.charAt(indexOfSpace2+1);

        //  char <=9 is to check a character is a digit or not
        if(firstCharacterS1<='9')
        {
            if(firstCharacterS2<='9') return 0;

            return 1;
        }

        if(firstCharacterS2<='9') 
        {
            return -1;
            // priority to first parameter that is s1
        }

        if(content1.compareTo(content2)!=0)
        {
            return content1.compareTo(content2);
        }
        else
        {
            return identifier1.compareTo(identifier2);
        }
        

    }
}


class Solution {
    
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,new MyComparator());
        return logs;
    }
}