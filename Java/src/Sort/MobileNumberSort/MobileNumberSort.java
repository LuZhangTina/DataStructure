package com.tina.sort;

import java.util.ArrayList;

/**
 * Created by tina on 2019/1/19.
 *
 * Sort Mobile Number by using bucket sort algorithm
 *
 * eg.
 * String[] mobileNumber1 = {"123", "122", "321", "312", "130"};
 * String[] result1 = {"122", "123", "130", "312", "321"};
 * MobileNumberSort.mobileNumberSort(mobileNumber1);
 * Assert.assertArrayEquals(result1, mobileNumber1);
 *
 * String[] mobileNumber2 = {"1234", "4122", "0321", "3120", "1300"};
 * String[] result2 = {"0321", "1234", "1300", "3120", "4122"};
 * MobileNumberSort.mobileNumberSort(mobileNumber2);
 * Assert.assertArrayEquals(result2, mobileNumber2);
 */
public class MobileNumberSort {
    public static void mobileNumberSort(String[] mobileNumberArray) {
        if (mobileNumberArray == null) {
            return;
        }

        int mobileLength = mobileNumberArray[0].length();
        for (int i = mobileLength - 1; i >= 0; i--) {
            bucketSortByPosition(mobileNumberArray, i);
        }
    }

    private static void bucketSortByPosition(String[] mobileNumberArray, int position) {
        // build 10 bucket by using Arraylist, represent number 0 to 9
        ArrayList<ArrayList> bucketArray = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            bucketArray.add(new ArrayList<String>());
        }

        // add the mobile number into related bucket based the number on the position in mobile number
        for (int i = 0; i < mobileNumberArray.length; i++) {
            String tempMobileNumber = mobileNumberArray[i];
            int bucketIndex = tempMobileNumber.charAt(position) - '0';
            ArrayList<String> theIthBucket = bucketArray.get(bucketIndex);
            theIthBucket.add(mobileNumberArray[i]);
        }

        // read all the mobile number from bucket0 to bucket9
        int k = 0;
        for (int i = 0; i < bucketArray.size(); i++) {
            ArrayList<String> theIthBucket = bucketArray.get(i);
            for (int j = 0; j < theIthBucket.size(); j++) {
                mobileNumberArray[k] = theIthBucket.get(j);
                k++;
            }
        }
    }
}
