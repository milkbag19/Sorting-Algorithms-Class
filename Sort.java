import java.util.*;

public class Sort {
//Bubble Sort
public int[] bubble(int[] list){
    int temp = 0; //this will be the temporary variable used to swap our numbers.
    for(int i = 0;i<list.length-1;i++){ //Loop through all elements in the array

        if(list[i]>list[i+1]){//check if the current element in the array is bigger than the one ahead of it.  If so, run the code below and swap them.
            temp = list[i+1];
            list[i+1] = list[i];
            list[i] = temp;
            i = -1; //return to the top of the array
        }

    }
    return list;//the sorting has completed and now will return the array.

}
///////////////

    /*Selection Sort
    How does it work?
    Selection sort works by having two pointers in a list.
    The first pointer gives a reference point to the second scanner and tells the computer which number to switch with the smallest found number.
    the Second pointer then scans all elements that are below the current element and checks each of them to the current smallest found number.
    Once the second scanner reaches the end of the list, it then swaps the current element with the smallest element.
    This is done until the first pointer reaches the end of the code and it then returns the sorted array.
    */
public int[] selection (int[] list){
    int tempScan = 0; //a variable to store the second pointer scanning through the list.  This is scanning for the smallest number.
    int tempSmallestIndex = 0; //this tracks the index of the smallest element found so far.
    for(int i = 0; i<list.length-1;i++){//loop for the first scanner to compare the second scanner with.
        int tempCurrent = list[i]; //set a temp variable to the current element.
        int tempCurrentSmallest = tempCurrent; //resetting the smallest number variable.
        for(int j = i;j<list.length;j++){ //the loop for the second scanner which looks for the smallest number.
            tempScan = list[j];//Moving the pointer forward

            if(tempScan<tempCurrentSmallest){//checking if the second pointer is smaller than the current smallest.  If so, then set the current smallest to a variable and save the index as well.
                tempCurrentSmallest = tempScan;
                tempSmallestIndex = j;
            }
        }
        if(tempCurrentSmallest<tempCurrent){//once the second pointer has reached the end of its loop, the program checks if the current smallest is smaller than the current element.  If so, swap them.
            list[tempSmallestIndex] =  tempCurrent;
            list[i] = tempCurrentSmallest;
        }
    }
    return list;//once the first pointer has reached the end of its loop, the array will be sorted and will then return the sorted array.
}
    /*///////////////////////////////////////////////////////////////////////////////
    quick sort
    this method of sorting can be many times faster than bubble or selection sort in its best cases.  Although, if the pivot is chosen to be the first element each time, it will practically be the same speed as the other two.
    This would be a worst case scenario.
    The way this works is that it chooses a pivot randomly in the array.  it then has two pointers on either side of the array that slowly go towards the center.
    if both the pointers meet the criteria of one side being larger and the other being smaller than the pivot, it swaps them.
    once the two pointers reach each other, the array is split in two, and quick sort is applied again to both parts.  this is done until the array is completely sorted.


     *////////////////////////////////////////////////////////////////////////////////


    public Vector<Integer> lists;
    private int split( int numToLeft, int numToRight, int pivot){
        while(numToLeft <= numToRight){ //looping until the two pointers meet or go past eachother

            while(lists.get(numToLeft)<pivot){ //moves through the array until it finds a value less than the pivot
                numToLeft++;
            }
            while(lists.get(numToRight)>pivot){ // moves through the array until it finds a value greater than the pivot
                numToRight--;
            }
            if(numToLeft<=numToRight){ //now that the two pointers have their correct positions, they will swap numbers and move on.
                int temp = 0;
                temp = lists.get(numToRight);
                lists.set(numToRight, lists.get(numToLeft));
                lists.set(numToLeft, temp);
                numToLeft++;
                numToRight--;
            }
        }
        return numToLeft; //returning where the split will be
    }



    public void quickSort(Vector<Integer> list){
        lists = list;
        quickSort(0, list.size()-1);
    }




    public void quickSort(int numToLeft, int numToRight){

        if(numToLeft>=numToRight){
            return;
        }
            int pivot = lists.get((numToLeft+numToRight)/2);
            int index = split(numToLeft, numToRight, pivot);

            quickSort(numToLeft, index-1);  //using quick sort on the left side of the pivot
            quickSort(index, numToRight); //quick sorting the left side of the pivot

            return;
    }

    /*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    QuickBubbleShell works by using a sort of merge and conquer method of sorting.
    It first transforms the 1D array into a 1xn 2D array and quickly halves the height and doubles the length each recursion.
    While putting the elements into the new array, it puts them in order by comparing the first elements of two rows from the old array.
    Every time an element is put into the new array, either the bottom or top pointers move forward until it reaches the end of the row.
    Once one row reaches the end, the other row will be put into the new array one after the other.
    It does this over and over until the new array is an nx1 2D array.  it then transforms the sorted array into a 1D array and returns it.
     *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public int[] quickBubbleShell (int[] list){
        int[][] newArr = new int[list.length][1];//creates a new 2D array that is the opposite dimensions of our inputted 1D array//

        for  (int i=0 ; i< list.length; i++) {
                newArr[i][0] = list[i]; //puts all elements of inputted array into the new array.//

            }
            newArr = mergeAndSort(newArr);//calls second method to sort the array.//

            for(int i = 0;i<newArr[0].length;i++){
                list[i] = newArr[0][i];
            }//grabs the new sorted 2D array and tranforms it into a 1D array that we will now be able to return.//
        return list;
}

public int[][] mergeAndSort(int[][] list) {
    int[][] newArr = new int[list.length / 2][list[0].length * 2]; //New array is half the height if the old one, and twice the length.  We do this becuase we want our new array to approach the same dimensions of the Inputted array.//
    int bottomCount = 0;
    int newArrRowCount = 0;
    int newArrColumnCount = 0;
    int topCount = 0;
    if (newArr[0].length>1) {//checking if the height of the new array is greater than one, so that we don't attempt to sort again since it will already be sorted if that were the case.//
        try{
        for (newArrRowCount = 0; newArrRowCount < newArr.length; newArrRowCount++) {//looping through all the rows in the new array so that we may input the elements of the old array into it.//
            newArrColumnCount = 0;
            topCount = 0;
            bottomCount = 0;
            for (int j = 0; j<(list[2*newArrRowCount].length+list[2*newArrRowCount+1].length);j++){//Goes through all combined elements of the two selected rows from the old array.
                try {
                    if(topCount==list[2*newArrRowCount].length&&bottomCount<list[2*newArrRowCount+1].length){//checks if the top pointer has reached its end, and if so we will add all elements of the other row into the new array.
                        newArr[newArrRowCount][newArrColumnCount] = list[2*newArrRowCount+1][bottomCount];
                        newArrColumnCount++;
                        bottomCount++;
                    }
                    else if(bottomCount == list[2*newArrRowCount+1].length&&topCount<list[2*newArrRowCount].length){ //Same as previous if statement, but for the bottom pointer.
                        newArr[newArrRowCount][newArrColumnCount] = list[2*newArrRowCount][topCount];
                        newArrColumnCount++;
                        topCount++;
                    }
                    else if (list[2 * newArrRowCount][topCount] < list[(2 * newArrRowCount) + 1][bottomCount]) {//Checking if the current element in the top column is less than the current element in the bottom column, and if so then we add it to the new array
                        newArr[newArrRowCount][newArrColumnCount] = list[2 * newArrRowCount][topCount];
                        newArrColumnCount++;
                        topCount++;
                    } else if (list[2 * newArrRowCount][topCount] == list[(2 * newArrRowCount) + 1][bottomCount]) {//Checking if the elements in the top and bottom pointers are the same, and if so, then add both to the new array at the same time.
                        newArr[newArrRowCount][newArrColumnCount] = list[2 * newArrRowCount][topCount];
                        newArrColumnCount++;
                        newArr[newArrRowCount][newArrColumnCount] = list[(2 * newArrRowCount) + 1][bottomCount];
                        topCount++;
                        newArrColumnCount++;
                        bottomCount++;
                    } else {
                        newArr[newArrRowCount][newArrColumnCount] = list[(2 * newArrRowCount) + 1][bottomCount];//if all other statements are false, then the bottom pointer must be smaller than the top pointer, and then we must add it to the new array.
                        bottomCount++;
                        newArrColumnCount++;
                    }
                } catch (Exception e) {
                }
        }
        }
    }catch(Exception f){}
}
        if(newArrRowCount==1){//if the new array's row count is just one, then it must be sorted and we will now return the array.
            return newArr;
        }
    newArr = mergeAndSort(newArr);//Otherwise use call this method again.
    return newArr;//once the method is done the row will be one and it will be sorted since we only return without calling the method if this is the case.
}



    ///////////////////////////////////////////////////////////////////////////////



}
