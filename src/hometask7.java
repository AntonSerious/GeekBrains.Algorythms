import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class hometask7 {

    private static class Graph{
        private class Vertex{
            char label;
            boolean wasVisited;
            Vertex parent;

            public Vertex(char label){
                this.label = label;
                this.wasVisited = false;
            }

            @Override
            public String toString(){
                return String.format("V=%c", label);
            }
        }

        private final int MAX_VERTICES = 16;
        private Vertex[] vertexList;
        private int[][] adjacencyMatrix;
        private int currentSize;

        public Graph(){
            vertexList = new Vertex[MAX_VERTICES];
            adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
            currentSize = 0;
        }

        public void addVertex(char label){
            vertexList[currentSize++] = new Vertex(label);
        }

        public void addEdge(int start, int end){
            adjacencyMatrix[start][end] = 1; // change 1 to weight
            adjacencyMatrix[end][start] = 1; // delete this for direct graph
        }
        public void displayVertex(int v){
            System.out.print(vertexList[v] + " ");
        }
        private int getUnvisitedVertex(int current){
            for (int i = 0; i < currentSize; i++) {
                if(adjacencyMatrix[current][i] ==1 && !vertexList[i].wasVisited){
                    return i;
                }
            }
            return -1;
        }

        public void depthTraverse(){
            Stack<Integer> stack = new Stack();
            vertexList[0].wasVisited = true;
            displayVertex(0);
            stack.push(0);
            while(!stack.empty()){
                int v = getUnvisitedVertex(stack.peek());
                if(v == -1){
                    stack.pop();
                } else{
                    vertexList[v].wasVisited = true;
                    displayVertex(v);
                    stack.push(v);
                }
            }
            resetFlags();
        }
        public void widthTraverse(){
            Queue<Integer> queue = new LinkedList<>();
            vertexList[0].wasVisited = true;
            queue.add(0);
            while(!queue.isEmpty()){
                int current = queue.remove();
                displayVertex(current);
                int next;
                while((next = getUnvisitedVertex(current)) != -1){
                    vertexList[next].wasVisited = true;
                    queue.add(next);
                }
            }
            resetFlags();
        }
        private void resetFlags(){
            for (int i = 0; i < currentSize; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        //----------------hometask

        Stack shortWay(int start, int end) {            //граф не взвешен
            Stack<Integer> result = new Stack();

            Queue<Integer> queue = new LinkedList<>();


            if (start < 0 || end > MAX_VERTICES || start == end) {
                return null;
            }
            vertexList[start].wasVisited = true;
            queue.add(start);
            while (!queue.isEmpty()) {                  // ищем узел, помечаем родителей
                int vCur = queue.remove();
                int vNxt;
                while ((vNxt = getUnvisitedVertex(vCur)) != -1) {
                    vertexList[vNxt].parent = vertexList[vCur];
                    vertexList[vNxt].wasVisited = true;
                    if (vNxt == end){
                        break;
                    }
                    queue.add(vNxt);
                }
                if (vNxt == end) break;
            }
            if (!vertexList[end].wasVisited) return null;

            result.push(end);
            int current = end;
            while (vertexList[current].parent != null)        // идём обратно к старту по родителям
                for (int i = 0; i < vertexList.length; i++)
                    if(vertexList[current].parent == vertexList[i]) {
                        result.push(i);
                        current = i;
                        break;
                    }

            for (int i = 0; i < currentSize; i++) {
                vertexList[i].wasVisited = false;
                vertexList[i].parent = null;
            }
            return result;
        }

//        public Queue<Integer> findWaysWidthTraverse(int start, int end){ //
//
//            Queue<Integer> queue = new LinkedList<>();
//            vertexList[start].wasVisited = true;
//            queue.add(start);
//            boolean traverseIsDone = false;
//
//            while(!queue.isEmpty()){
//                int current = queue.remove();
//                displayVertex(current);
//                if(current == end){
//                    traverseIsDone = true;
//                    break;
//                }
//                int next;
//                while((next = getUnvisitedVertex(current)) != -1){
//                    vertexList[next].wasVisited = true;
//                    queue.add(next);
//                }
//            }
//            resetFlags();
//            return queue;
//        }
//
//        private ArrayList<ArrayList<Integer>> waysFounded(int start, int end){
//
//
//        }
//
//        public void findTheShortestWay(int start, int end){
//
//        }
    }



    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');
        g.addVertex('i');
        g.addVertex('j');
        //g.addVertex('f');
        g.addEdge(0,1);
        g.addEdge(0,9);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(5,8);
        g.addEdge(6,8);
        g.addEdge(6,9);
        g.addEdge(7,9);

        g.depthTraverse();
        System.out.println();
        g.widthTraverse();
        System.out.println();
        Stack shortWay = g.shortWay(0, 9);
        if (shortWay != null)
            while (!shortWay.isEmpty()) {

                System.out.print( shortWay.pop());
                System.out.print((shortWay.isEmpty() ? "" : " -> "));
            }


    }

}
