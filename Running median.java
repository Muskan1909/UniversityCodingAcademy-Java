private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   //array elements that are lesser than effective median go into maxHeap
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();   //array elements that are greater than effective median go into minHeap
    
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        double median;
        double result[] = new double[a.length];
        for(int i = 0;i<a.length;i++){
            addNumber(a[i]);   ///adding numbers in heaps
            result[i] = getMedian();    //finding effective median
        }
        return result;   

    }
    private static void addNumber(int k){
        if(maxHeap.isEmpty()){    //if MAXHEAP IS EMPTY,enter element in maxheap
            maxHeap.add(k);
        }
        else if(maxHeap.size()==minHeap.size()){   //if size of maxheap and minheap is same, check if the element that needs to be inserted in heaps is lesser or greater than effective median that will always be top of the heap with greater number of elements
            if(k<maxHeap.peek()){
                maxHeap.add(k);    //if element is lesser than maxheap top, it enters in maxheap
            }
            else{
                minHeap.add(k);    //if element is greater than minheap top, it enters in minheap
                maxHeap.add(minHeap.remove());   //balance the other heap
            }
        }
       else if(maxHeap.size()>minHeap.size()){  //just the opposite
           if(k>maxHeap.peek()){
               minHeap.add(k);
           }
           else{
               maxHeap.add(k);
               minHeap.add(maxHeap.remove());
           }
       }
    }
    //minheap will always have fewer elements than maxheap
    private static double getMedian(){
        if(maxHeap.isEmpty())
            return 0;
        else if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        else
            return maxHeap.peek();
            
    }
