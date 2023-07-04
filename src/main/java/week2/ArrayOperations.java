package week2;

public class ArrayOperations {
    public void display(int arr[])
    {
        for(int i=0 ; i<arr.length ; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void minMax(int arr[])
    {
        if (arr.length == 0)
        {
            System.out.println("Array Empty");
            return;
        }
        int minTemp=Integer.MAX_VALUE,maxTemp=Integer.MIN_VALUE;
        for (int i=0 ; i<arr.length ; i++)
        {
            if(arr[i]>maxTemp)
                maxTemp = arr[i];
            if(arr[i]<minTemp)
                minTemp = arr[i];
        }
        System.out.printf("The Largest element = %d\nThe Smallest element = %d\n",maxTemp,minTemp);
    }
    public int[] reverse(int arr[])
    {
        int f = 0, l = arr.length-1,temp;
        while( f<l )
        {
            temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;
        }
        return arr;
    }
    public int[] rotate(int arr[],int r)
    {
        r %= arr.length;
        int newArr[] = new int[arr.length];
        for(int i = 0,j= r ; i< arr.length ; i++,j++ )
        {
            j %= arr.length;
            newArr[i] = arr[j];
        }
        return newArr;
    }
}
