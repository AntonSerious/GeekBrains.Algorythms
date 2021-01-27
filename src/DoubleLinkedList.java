import java.util.Objects;

public class DoubleLinkedList { //двусвязный список.

    private static class Node{
        String data;
        Node next;
        Node previous;

        public Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node(data is: " + data + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(next, node.next);
        }
    }

    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty(){
        return head ==null;
    }

    public void headPush(String data){
        Node newNode = new Node(data);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
        newNode.previous = null;
    }
    public void tailPush(String data){
        Node newNode = new Node(data);

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        newNode.next = null;
    }



    public String headPop(){
        if(isEmpty()) return null;
        String temp = head.data;
        head.next.previous = null;
        head = head.next;
        return temp;
    }
    public String tailPop(){
        if(isEmpty()) return null;
        String temp = tail.data;
        tail.previous.next = null;
        tail = tail.previous;
        return temp;
    }


    public void delete(String data){
        Node n = new Node(data);
        Node current = head;
        Node previous = null;
        while(!current.equals(n)){
            if(current.next == null) return;
            else{
                previous = current;
                current = current.next;
            }
        }

        if (current == head){
            head.next.previous = null;
            head = head.next;
        } else{
            current.next.previous = previous;
            previous.next = current.next;
        }
    }
    public Node getFirst() {
        return head;
    }

    public Node getLast() {
        return tail;
    }
}
