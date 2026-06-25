// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Heap_opr {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add (int data) {
            arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while(arr.get(x) > arr.get(par)) {//O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                
                x=par;
                par = (x-1)/2;
            }
        }
        public int peek() {
            return arr.get(0);
        }
        public void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            if(left < arr.size() && arr.get(minIdx) < arr.get(left)) { 
                minIdx=left;
            }
            if(right<arr.size()&&arr.get(minIdx)<arr.get(right)) {
                minIdx=right;
            }
nlkk        }
        public int remove() {
            int data = arr.get(0);
            //1.Swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            //2.Remove last node
            arr.remove(arr.size()-1);
            //3.Heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(9);
        h.add(2);
        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
