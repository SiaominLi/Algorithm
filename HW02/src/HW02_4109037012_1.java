
public class HW02_4109037012_1 extends FourSum {
	
//	boolean hasZero=false;
	pairSum[] arr , orderarr;
	int[] orderedArr;
	
	class pairSum {
	    int first;
	    int sec;
	    int sum;
	};
	
	public static void main(String[] args) {
		
		HW02_4109037012_1 test = new HW02_4109037012_1();		
		int[] A = {-2,-3,1,0,2,1,3};
		Stopwatch stopwatch = new Stopwatch();
		System.out.println("4Sum is zero: "+test.F_sum(A));
		double time = stopwatch.elapsedTime();
		System.out.println("elapsed time " + time);
	}
	@Override
	public int F_sum(int[] A) {
//		this.quickSort(A, 0, A.length-1);	// quickSort: O(NlogN)
		int n = A.length , count = 0 , size = (n * (n - 1)) / 2;
		arr = new pairSum[size];
		
		
		merge_sort(A); //orderedArr
		
		int i , j , k = 0;
		for (i = 0; i < n - 1; i++) {
	        for (j = i + 1; j < n; j++) {
//	    		System.out.println("sum:"+ (A[i] + A[j]));
	        	arr[k] = new pairSum();
	            arr[k].sum = orderedArr[i] + orderedArr[j];
	            arr[k].first = i;
	            arr[k].sec = j;
	            k++;
	        }
	    }
		
//		System.out.print("before pair merge:");
//        for(int p = 0; p < arr.length ; p++) {
//        	System.out.print(arr[p].sum + " ");
//        }
//        System.out.println();
        
        merge_sort_pair(arr); //orderarr
		
		int p = 0;
	    int q = size - 1;
	    while (p < size && q >= 0 && p < q) {
//	    	if( orderarr[p].sum == -2)
//	    		System.out.println("p:"+orderarr[p].sum+" q:"+orderarr[q].sum);
//	    	System.out.println(orderarr[p].first + " "+ orderarr[p].sec +" "+ orderarr[q].first +" "+ orderarr[q].sec); 
	    	
	        if ( orderarr[p].sum + orderarr[q].sum == 0 && 
	        		noCommon(orderarr[p], orderarr[q]) == 1 ) {
	        	System.out.println("Yes "+orderarr[p].first + " "+ orderarr[p].sec +" "+ orderarr[q].first +" "+ orderarr[q].sec); 
	        	count++;
//	        	System.out.println( "q: "+orderarr[q-1].sum +" "+orderarr[q].sum);
	        	if( orderarr[q-1].sum == orderarr[q].sum ) q--;
	        	else p++;
	        }
	        else if (orderarr[p].sum + orderarr[q].sum == 0) {
	        	if( orderarr[q-1].sum == orderarr[q].sum ) q--;
	        	else p++;
	        }
	        else if (orderarr[p].sum + orderarr[q].sum < 0) {
	        	p++;
	        }	        
	        
	        else {
	        	q--;
	        }
	    }
		return count;
	}
	
	
//	int cnt = 0;
	int noCommon(pairSum a, pairSum b){
		
	    if ( a.first == b.first || a.first == b.sec || a.sec == b.first || a.sec == b.sec )    		
	        return 0;
//	    System.out.println("NO"+ cnt +": "+ a.first +" "+ a.sec +" "+ b.first +" "+ b.sec); 
	    if( a.first >= a.sec || a.sec >= b.first || b.first >= b.sec )
	    	return 0;
//	    cnt++;
//	    System.out.println("Yes"+ cnt +": "+ a.first +" "+ a.sec +" "+ b.first +" "+ b.sec);  
	    return 1;
	}
	private void merge_sort(int[] arr){
//		System.out.println(arr[0].sum);
		orderedArr = new int[arr.length];
		
        for(int i = 2; i < arr.length << 1; i = i << 1) {
            for(int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
        System.out.print("A merge:");
        for(int p = 0; p < arr.length ; p++) {
        	System.out.print(arr[p] + " ");
        }
        System.out.println();
	}	
	private void merge_sort_pair(pairSum[] arr){
//		System.out.println(arr[0].sum);
		orderarr = new pairSum[arr.length];
		
        for(int i = 2; i < arr.length << 1; i = i << 1) {
            for(int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = (left + (i >> 1)) >= arr.length ? (arr.length - 1) : (left + (i >> 1));
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l].sum < arr[m].sum) {
                    	orderarr[start++] = arr[l++];
                    } else {
                    	orderarr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                	orderarr[start++] = arr[l++];
                while (m <= right)
                	orderarr[start++] = arr[m++];
                System.arraycopy(orderarr, left, arr, left, right - left + 1);
            }
        }
        System.out.print("pair merge:");
        for(int p = 0; p < arr.length ; p++) {
        	System.out.print(orderarr[p].sum + " ");
        }
        System.out.println();
	}	
	
}
