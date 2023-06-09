package week2;
import java.util.Arrays;
public class StringOperations {
    public int vowelCount(String st)
    {
        int count = 0;
        for(char ch : st.toCharArray()) {
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                count++;
        }
        return count;
    }
    public boolean checkAnagram(String st1,String st2)
    {
        st1 = st1.toLowerCase();
        st2 = st2.toLowerCase();
        char[] charr1 = st1.toCharArray();
        char[] charr2 = st2.toCharArray();
        Arrays.sort(charr1);
        Arrays.sort(charr2);
        String stt1 = new String(charr1);
        String stt2 = new String(charr2);
        return stt1.equals(stt2);
    }

    public String reverseString(String st){
        char[] chs = st.toCharArray();
        for(int i =0, j = chs.length -1; i<j ;i++,j--)
        {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return new String(chs);
    }
    public String reverseSentence(String st)
    {
        String[] words = st.split(" ");
        for(int i = 0;i<words.length;i++)
            words[i] = reverseString(words[i]);
        return String.join(" ",words);
    }
    public boolean checkRotation(String st1,String st2)
    {
        if (st1.length() != st2.length())
            return false;
        int n = st1.length();
        char ch;
        for(int i =0; i<n ; i++)
        {
            ch = st1.charAt(n-1);
            st1 = st1.substring(0, n-1);
            st1 = ch + st1 ;
            if(st1.equals(st2))
                return true;
        }
        return false;
    }
}
