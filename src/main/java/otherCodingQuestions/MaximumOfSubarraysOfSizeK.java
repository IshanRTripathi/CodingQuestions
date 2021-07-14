package main.java.otherCodingQuestions;

// Java Program to find the maximum for
// each and every contiguous subarray of size k.
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfSubarraysOfSizeK
{

    // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size k
    static void printMax(int arr[], int n, int k)
    {

        // Create a Double Ended Queue, deque
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in deque, i.e.,
        // arr[deque.front[]] to arr[deque.rear()]
        // are sorted in decreasing order
        Deque<Integer> deque = new LinkedList<Integer>();

		/* Process first k (or first window)
		elements of array */
        int i;
        for (i = 0; i < k; ++i)
        {
            System.out.println(deque);
            // For every element, the previous
            // smaller elements are useless so
            // remove them from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                // Remove from rear
                deque.removeLast();
            }

            // Add new element at rear of queue
            deque.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i)
        {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[deque.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!deque.isEmpty()) && deque.peek() <= i - k)
                deque.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!deque.isEmpty()) && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            // Add current element at the rear of deque
            deque.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[deque.peek()]);
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 9, 2, 11, 1, 3, 5, 0 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
