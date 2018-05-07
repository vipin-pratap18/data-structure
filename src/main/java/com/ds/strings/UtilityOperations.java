package com.ds.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UtilityOperations {

    //Method for sorting the TreeMap based on values
    public static <K, V extends Comparable<V>> NavigableMap<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {

            @Override
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        NavigableMap<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
            //Date date = dateFormat.parse(inDate.trim());
            //System.out.println(dateFormat.format(date));
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static String previousDateString(String dateString)
            throws ParseException {
        // Create a date formatter using your format string
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Parse the given date string into a Date object.
        // Note: This can throw a ParseException.
        Date myDate = dateFormat.parse(dateString);

        // Use the Calendar class to subtract one day
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        //calendar.add(Calendar.DAY_OF_YEAR, -1);

        // Use the date formatter to produce a formatted date string
        Date previousDate = calendar.getTime();
        String result = dateFormat.format(previousDate);
        Date myNewDate = dateFormat.parse(result);

        System.out.println(myNewDate);

        return result;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static int kPairedElements( int k, int[ ] A )
    {
        Map<Long, Integer> C = new HashMap<Long, Integer>( );
        for ( int i = 0; i < A.length; i++ )
        {
            long difference = ( ( long ) k ) - A[ i ];
            int tempValue = C.containsKey( difference ) ? C.get( difference ) : 0;
            C.put( difference, tempValue + 1 );
        }

        int counter = 0;
        for ( int i = 0; i < A.length; i++ )
        {
            long value = A[ i ];
            counter += C.containsKey( value ) ? C.get( value ) : 0;
        }

        return counter;
    }


    public static void  incrementDate(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 365); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);


    }

}
