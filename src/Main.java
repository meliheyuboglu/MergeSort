public class Main {

    public static void main(String[] args) {
        int[] a = {1,5,6,7,2,3,9};

        int[] c = mergesort(a);

        for (int i: c) {
            System.out.println(i + " ");
        }
    }

    public static int[] mergesort(int[] A) {


        int n = A.length;
        if(n < 2) {
            return A;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for(int i = 0 ; i < mid ; i++){
            left[i] = A[i];
        }
        for(int j = mid ; j < n ; j++){
            right[j-mid] = A[j];
        }
        left = mergesort(left);
        right = mergesort(right);
        return merge(left,right);


    }

    public static int[] merge(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        int[] sortedlist = new int[n1+n2];
        int i = 0 , k = 0 , j = 0;
        while(i < n1 && j < n2){
            if(A[i] <= B[j]){
                sortedlist[k] = A[i];
                i++;
            }
            else{
                sortedlist[k] = B[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            sortedlist[k] = A[i];
            i++;
            k++;
        }
        while(j < n2){
            sortedlist[k] = B[j];
            j++;
            k++;
        }
        return sortedlist;
    }
}
