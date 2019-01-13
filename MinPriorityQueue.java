public class MinPriorityQueue{
    private static int [] heap;
    private static int capacity;
    private static int size;

    MinPriorityQueue(int c){
        this.capacity = c;
        this.size = 0;
        this.heap = new int [c+1];  //heap is 1 indexed
    }

    public void insert(int key){
        if(this.isFull())
           return;
        this.heap[this.size + 1] = key;  //heap is 1 indexed..
        int k = this.size + 1;
        while(k>1){
            if(this.heap[k] < this.heap[k/2]){ //checking if child is lesser than parent..then..swap else just k = k/2;
                int temp = this.heap[k];
                this.heap[k] = this.heap[k/2];
                this.heap[k/2] = temp;
            }
           k = k/2;
        }
       this.size++;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public boolean isFull(){
        return (this.size == this.capacity);
    }

    public int peek(){
        if(this.isEmpty()) throw new NoSuchElementException("Underflow");
        return this.heap[1];
    }

    public void heapSort(){
        for(int i=1;i<this.capacity;i++)
            this.delete();
    }

    public void print(){
        for(int i=1;i<=this.capacity;i++)
            System.out.println(this.heap[i]);
    }

    private void sink(){
        int k = 1;
        while(2*k <= this.size){
            int j = 2*k;
            if(j < this.size && this.heap[j] > this.heap[j+1])
               j++;
            if(this.heap[j] < this.heap[k]){
                int temp = this.heap[k];
                this.heap[k] = this.heap[j];
                this.heap[j] = temp;
            }
            k = j;
        }
    }

    public int delete(){
        int min = this.heap[1];
        this.heap[1] = this.heap[this.size];
        this.heap[this.size] = min;
        this.size--;
        this.sink();
        return min;
    }

    public static void main(String []args){
        MinPriorityQueue p = new MinPriorityQueue(6);
        p.insert(4);
        p.insert(6);
        p.insert(3);
        p.insert(2);
        p.insert(9);
        p.insert(1);
        System.out.println("After insertion");
        p.print();
        p.heapSort();
        System.out.println("After sorting");
        p.print();
    }
}
