import java.util.LinkedList;
import java.util.Objects;

public class hometask4 {

    private static class Cat{
        int age;
        String name;

        public Cat(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Cat{ a = %d, n=%s)", age, name);
        }
    }

    private static class SingleLinkedList{
        private static class Node{
            Cat c;
            Node next;

            public Node(Cat c) {
                this.c = c;
            }

            @Override
            public String toString() {
                return "Node(c=" + c + ")";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return Objects.equals(c, node.c) &&
                        Objects.equals(next, node.next);
            }

        }

        private Node head;

        public SingleLinkedList() {
            this.head = null;
        }
        public boolean isEmpty(){
            return head ==null;
        }
        public void push(Cat c){
            Node n = new Node(c);
            n.next = head;
            head = n;
        }
        public Cat pop(){
            if(isEmpty()) return null;
            Cat temp = head.c;
            head = head.next;
            return temp;
        }

        public boolean contains(Cat c){
            Node n = new Node(c);
            Node current = head;
            while(!current.equals(n)){
                if(current.next == null) return false;
                else current = current.next;
            }
            return true;
        }
        public void delete(Cat c){
            Node n = new Node(c);
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
                head = head.next;
            } else{
                previous.next = current.next;
            }
        }
        public Node getFirst() {
            return head;
        }

        public void setFirst(Node first) {
            this.head = first;
        }
    }

    //-------------------------------------------- Iterator
    private static class Iterator{
        private SingleLinkedList.Node current;
        private SingleLinkedList.Node previous;
        private SingleLinkedList list;

        public Iterator(SingleLinkedList list){
            this.list = list;
            this.reset();
        }

        public void reset(){
            current = list.head;
            previous = null;
        }

        public boolean atEnd(){
            return current.next == null;
        }

        public void nextNode(){
            previous = current;
            current = current.next;
        }

        public SingleLinkedList.Node getCurrent(){
            return current;
        }

        public void insertAfter(Cat cat){
            SingleLinkedList.Node newNode = new SingleLinkedList.Node(cat);
            if (list.isEmpty()){
                list.setFirst(newNode);
                current = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
                nextNode();
            }
        }

        public void insertBefore(Cat cat){
            SingleLinkedList.Node newNode = new SingleLinkedList.Node(cat);
            if(previous == null){
                newNode.next = list.getFirst();
                list.setFirst(newNode);
                reset();
            }
            else{
                newNode.next = previous.next;
                previous.next = newNode;
                current = newNode;
            }
        }

        public void deleteCurrent(){
            if (previous == null){
                list.setFirst(current.next);
                reset();
            } else {
                previous.next = current.next;
                if (atEnd()){
                    reset();
                } else {
                    current = current.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList catList = new SingleLinkedList();
        catList.push(new Cat(1, "Axe"));
        catList.push(new Cat(2, "Bars"));
        catList.push(new Cat(3, "Mike"));
        catList.push(new Cat(4, "Butch"));

        Iterator iter = new Iterator(catList);
        System.out.println(iter.getCurrent());
        iter.nextNode();
        System.out.println(iter.getCurrent());
        iter.deleteCurrent();
        System.out.println(iter.getCurrent());


    }
}
