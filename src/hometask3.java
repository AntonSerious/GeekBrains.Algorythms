import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hometask3 {
    // inverse programm

    private static class Stack{
        private int capacity;
        private char[] stack;
        private int head;

        public Stack(int size){
            this.stack = new char[size];
            this.head = -1;
        }

        public boolean isEmpty(){
            return head == -1;
        }
        public boolean isFull(){
            return head == stack.length-1; //head == stack.kength - 1;
        }

        //push
        public boolean push(char i){
            if (isFull()) return false;
            stack[++head] = i;
            return true;
        }
        //pop
        public char pop() throws RuntimeException {
            if(isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head--];
        }
        //peek
        public char peek() throws RuntimeException {
            if(isEmpty()) throw new RuntimeException("Stack is empty");
            return stack[head];
        }

    }

    //input vice-versa
    public static void main(String[] args) throws IOException {

//        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
//        String input = bf.readLine();
//        int inputLength = input.length();
//
//        Stack st = new Stack(inputLength);
//
//        for (int i = 0; i < inputLength; i++) {
//            st.push(input.charAt(i));
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < inputLength; i++) {
//            sb.append(st.pop());
//        }
//        System.out.println(sb);

//        Deque d = new Deque(4);
//        d.rightPush(1);
//        d.rightPush(2);
//        d.rightPush(3);
//        d.rightPush(4);
//
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        d.leftPush(-1);
//        d.leftPush(-2);
//        d.leftPush(-3);
//        d.leftPush(-4);
//
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        d.leftPush(-5);
//        d.leftPush(-6);
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        d.leftPush(0);
//        d.leftPush(-1);
//
//        System.out.println(d.rightPop());
//        d.leftPush(-2);
//
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());
//        System.out.println(d.rightPop());

        QueuePrioritited qp = new QueuePrioritited(3);
        qp.insert(1,"data1");

        qp.insert(3,"data3");

        qp.insert(2,"data2");
        System.out.println(qp.pop());
        System.out.println(qp.pop());
        System.out.println(qp.pop());
        System.out.println(qp.pop());


    }



}
