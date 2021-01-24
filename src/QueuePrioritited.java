import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueuePrioritited {
    private int capacity;
    private String[] pQeque;
    private int tail;
    private int total = 0;
    public QueuePrioritited(int capacity){
        this.capacity = capacity;
        this.pQeque = new String[capacity];
        this.tail = -1;
        this.total = 0;
    }

    public boolean isFull(){
        return tail == capacity-1;
    }
    public boolean isEmpty(){
        return tail == -1;
    }
    public boolean insert(int i, String data){
        if (isFull()) return false;
        if (total < i){
            pQeque[total] = data;
            tail++;
            total++;
        }else {
            System.arraycopy(pQeque, i - 1, pQeque, i, capacity - (i - 1) - 1);
            pQeque[i - 1] = data;
            tail++;
            total++;
        }
        return true;
    }
    public String pop() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Stack is empty");

        String first = this.pQeque[0];
        System.arraycopy(pQeque, 1, pQeque, 0, capacity-1  );
        tail--;
        total--;
        return first;
    }
}
