package solutions.sort;

public class HeapSort {

    public void sort(int[] arr) {
        Heap heap = new Heap(arr.length);
        heap.heapify(arr);
        heap.print();
        int i = 0;
        System.out.println("\nExtracting min...");
        while(! heap.isEmpty()) {
             arr[i++] = heap.extractMin();
             heap.print();
        }
    }

    public class Heap {
        int arr[];
        int tail = 0;

        public Heap(int len) {
            this.arr = new int[len];
            for(int i = 0; i < len; i++)
                this.arr[i] = Integer.MAX_VALUE;

        }
        public void heapify(int[] arr) {
            for(int i : arr) {
                insert(i);
            }
        }

        public int extractMin() {
            if(isEmpty()) return -1;

            int min = arr[0];
            arr[0] = arr[--tail];
            arr[tail] = Integer.MAX_VALUE;
            int parent = arr[0], parentIndex = 0;
            int leftChild = getLeftChild(parentIndex), rightChild = getRightChild(parentIndex);
            int leftIndex = getLeftChildIndex(parentIndex), rightIndex = getRightChildIndex(parentIndex);

            while(leftChild < parent || rightChild < parent) {
                int minSiblingIndex = leftIndex;
                if(leftChild > rightChild) {
                    minSiblingIndex = rightIndex;
                }

                int temp = arr[parentIndex];
                arr[parentIndex] = arr[minSiblingIndex];
                arr[minSiblingIndex] = temp;

                parentIndex = minSiblingIndex;
                leftChild = getLeftChild(parentIndex);
                rightChild = getRightChild(parentIndex);
                leftIndex = getLeftChildIndex(parentIndex);
                rightIndex = getRightChildIndex(parentIndex);
            }
            return min;
        }

        public void insert(int i) {
            arr[tail] = i;
            int parentIndex =  getParent(tail);
            while(parentIndex >= 0) {

                int parent = arr[parentIndex];
                int leftChildIndex = getLeftChildIndex(parentIndex), rightChildIndex = getRightChildIndex(parentIndex);
                int leftChild = Integer.MAX_VALUE, rightChild = Integer.MAX_VALUE;

                if(leftChildIndex >= 0)
                    leftChild = arr[leftChildIndex];
                if(rightChildIndex >= 0)
                    rightChild = arr[rightChildIndex];

                int min = parent, swapIndex = parentIndex;
                if(parent > leftChild) {
                    min = leftChild;
                    swapIndex = leftChildIndex;
                } if(min > rightChild) {
                    min = rightChild;
                    swapIndex = rightChildIndex;
                }

                arr[swapIndex] = parent;
                arr[parentIndex] = min;

                parentIndex = getParent(parentIndex);
            }
            tail++;
        }

        public int getParent(int childIndex) {
            if(childIndex == 0) return -1;
            int parentIndex = (childIndex - 1) / 2;
            return parentIndex;
        }

        public int getLeftChildIndex(int parentIndex) {
            int leftChildIndex = parentIndex * 2 + 1;
            if(leftChildIndex < arr.length) return leftChildIndex;
            else return -1;
        }

        public int getRightChildIndex(int parentIndex) {
            int rightChildIndex = parentIndex * 2 + 2;
            if(rightChildIndex < arr.length) return rightChildIndex;
            else return -1;
        }

        public int getLeftChild(int parentIndex) {
            int leftChildIndex = parentIndex * 2 + 1;
            if(leftChildIndex < arr.length) return arr[leftChildIndex];
            else return Integer.MAX_VALUE;
        }

        public int getRightChild(int parentIndex) {
            int rightChildIndex = parentIndex * 2 + 2;
            if(rightChildIndex < arr.length) return arr[rightChildIndex];
            else return Integer.MAX_VALUE;
        }

        public boolean isEmpty() {
            if(tail == 0) return true;
            return false;
        }

        public void print() {
            StringBuilder str = new StringBuilder();
            for(int each : arr) str.append(each).append(" ");
            System.out.println(str.toString());
        }
    }

    public static void print(int[] arr) {
        System.out.println("\nThe sorted arr: ");
        StringBuilder str = new StringBuilder();
        for(int each : arr) str.append(each).append(" ");
        System.out.println(str.toString());
    }

    public static void test() {
        HeapSort sort = new HeapSort();
        int[] arr = new int[] {3, 2, 1, 15, 5, 4, 45, 6};
        sort.sort(arr);
        print(arr);
    }
}
