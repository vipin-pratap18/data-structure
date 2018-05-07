package com.ds.strings;

public class StringOperations {

    public boolean checkPalindrome(String str){
        char[] ch = str.toCharArray();
        int len = ch.length;
        for(int i=0, j= len-1; i<len/2; i++, j--){
            if(ch[i] != ch[j])
                return false;
        }
        return true;
    }

    public int getMedian(int ar1[], int ar2[], int n)
    {
        int m1; /* For median of ar1 */
        int m2; /* For median of ar2 */

	    /* return -1  for invalid input */
        if (n <= 0)
            return -1;

        if (n == 1)
            return (ar1[0] + ar2[0])/2;

        if (n == 2)
            return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;

        m1 = median(ar1, n); /* get the median of the first array */
        m2 = median(ar2, n); /* get the median of the second array */

	    /* If medians are equal then return either m1 or m2 */
        if (m1 == m2)
            return m1;

	     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
        if (m1 < m2)
        {
            if (n % 2 == 0)
                return getMedian(getSubArray(ar1[m1], n/2 - 1, ar1), ar2, (n - n/2 +1));
            else
                return getMedian(getSubArray(ar1[m1] , n/2, ar1), ar2, (n - n/2));
        }

	    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
        else
        {
            if (n % 2 == 0)
                return getMedian(getSubArray(ar2[m2] , n/2 - 1, ar2), ar1, n - n/2 + 1);
            else
                return getMedian(getSubArray(ar2[m2] , n/2, ar2), ar1, n - n/2);
        }
    }

    /* Function to get median of a sorted array */
    public int median(int arr[], int n)
    {
        if (n%2 == 0)
            return (arr[n/2] + arr[n/2-1])/2;
        else
            return arr[n/2];
    }


    /* Utility functions */
    public int max(int x, int y)
    {
        return x > y? x : y;
    }

    public int min(int x, int y)
    {
        return x > y? y : x;
    }

    public int[] getSubArray(int begin, int end,  int[] array){

        int[] sub = new int[end];
        for(int i=begin, j=0; i < end; i++, j++){
            sub[j] = array[i];
        }

        return sub;
    }

    public String palindrome(String s)
    {

        char[] input = s.toCharArray();

        int start = 0;
        int end = input.length - 1;

        if (isPalindrome(input, start, end))
            return "";
        else
        {
            start++;
            while (start < end)
            {
                if (isPalindrome(input, start, end))
                {
                    break;
                }
                start++;

            }
            char[] toReturn = new char[start];
            for (int i = 0; i < toReturn.length; i++)
            {
                toReturn[i] = input[--start];
                //start--;
            }
            return new String(toReturn);

        }

    }

    public boolean isPalindrome(char[] input, int start, int end)
    {
        boolean isPalindrome = true;
        while (start < end)
        {
            if (input[start] != input[end])
            {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;

    }


    public static int returnOccupiedWhiteCellCount(String[] board){
        int w = 0;

        int length = board.length;
        for(int i=0; i<length; i++){
            for(int j=0; j<length-i; j++){
                if(board[i].charAt(j) == 'F'){
                    if((i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0))
                        w++;
                }
            }
        }
        return w;
    }
}
