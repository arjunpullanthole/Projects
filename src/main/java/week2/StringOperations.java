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
        char[] chr1 = st1.toCharArray();
        char[] chr2 = st2.toCharArray();
        Arrays.sort(chr1);
        Arrays.sort(chr2);
        return Arrays.equals(chr1,chr2);
    }

    public String reverseString(String st){
        char[] chs = st.toCharArray();
        for(int i =0, j = chs.length -1; i<j ;i++,j--)
        {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return String.valueOf(chs);
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
        String st = st1.concat(st2);
        return st.contains(st2);
    }
}
