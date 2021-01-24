import java.io.IOException;

public class lesson {
    private static class Stack{
        private int capacity;
        private int[] stack;
        private int head;

        public Stack(int size){
            this.stack = new int[size];
            this.head = -1;
        }

        public boolean isEmpty(){
            return head == -1;
        }
        public boolean isFull(){
            return head == stack.length-1; //head == stack.kength - 1;
        }

        //push
        public boolean push(int i){
            if (isFull()) return false;
            stack[++head] = i;
            return true;
        }
        //pop
        public int pop() throws RuntimeException {
            if(isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head--];
        }
        //peek
        public int peek() throws RuntimeException {
            if(isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head];
        }

     }

     private static int checkBrackets(String input){
        int size = input.length();
        Stack st = new Stack(size);
         for (int i = 0; i < size ; i++) {
             char ch = input.charAt(i);

             if (ch == '[' || ch == '(' || ch == '{' || ch == '<'){
                 st.push(ch);
             } else if (ch == ']' || ch == ')' || ch == '}' || ch == '>'){
                 if (st.isEmpty()) return i;
                 char op = (char) st.pop();
                 if(!((op == '[' && ch == ']') ||
                     (op == '{' && ch == '}') ||
                     (op == '(' && ch == ')') ||
                     (op == '<' && ch == '>'))){
                     return i;
                 }
             }
             //all correct
         }
         if (!st.isEmpty()){
             return size;
         }

         return -1;
     }

     private static class Queue{
        int[] queue;
        int head;
        int tail;
        int capacity;

        public Queue(int initial){
            queue = new int[initial];
            head = 0;
            tail = -1;
            capacity = 0;
        }

        public boolean isEmpty(){
            return capacity == 0;
        }
        public boolean isFull(){
            return capacity == queue.length;
        }
        public int length(){return capacity;}

        public void insert(int i){
            if(isFull())
                throw new RuntimeException("Queue is full!");
            if(tail == queue.length - 1)
                tail = -1;
            queue[++tail] = i;
            capacity++;
        }

        public int remove(){
            if(isEmpty()) throw new RuntimeException("Queue is empty");
            int temp = queue[head++];
            head %= queue.length;
            capacity--;
            return temp;
        }


     }

    public static void main(String[] args) {
        System.out.println(checkBrackets("<>(){} ([])"));
        //Deque
        //Priority Queue

    }
}
