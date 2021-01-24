import java.lang.reflect.Array;
import java.util.LinkedList;

public class Deque {
    private int capacity;
    private int[] deque;
    private int rightHead;
    private int leftHead;

    public Deque(int capacity){
        this.capacity = capacity;
        this.deque = new int[capacity*3 + 1];
        this.rightHead = (int) (capacity * 1.5);
        this.leftHead = (int) (capacity * 1.5) + 1;
    }

    public boolean isFull(){
        return rightHead - leftHead == capacity-1;
    }
    public boolean isEmpty(){
        return rightHead < leftHead;
    }

    public boolean rightPush(int i){
        if (isFull()) return false;
        deque[++rightHead] = i;
        return true;
    }
    public boolean leftPush(int i){
        if (isFull()) return false;
        deque[--leftHead] = i;

        return true;
    }

    public int rightPop() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Stack is empty");

        if (rightHead <= capacity){
            System.arraycopy(this.deque, this.leftHead, this.deque, (int) (this.capacity * 1.5), this.rightHead - this.leftHead); //если заполняемость массива начнет сдвигаться влево, то этим действием все значения вернутся снова на середину
        }
        return deque[rightHead--];
    }

    public int leftPop() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        if (leftHead >= capacity){
            System.arraycopy(this.deque, this.leftHead, this.deque, (int) (this.capacity * 1.5), this.rightHead - this.leftHead);
        }
        return deque[leftHead--];
    }
    public int rightPeek() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return deque[rightHead];
    }
    public int leftPeek() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return deque[leftHead];
    }
}
