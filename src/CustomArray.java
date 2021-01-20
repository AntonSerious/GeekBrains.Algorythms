import java.util.Arrays;

public class CustomArray {
    private int arr[];
    private int size;
    private boolean isSorted;
    private CustomArray()
    {
        isSorted = false;

    }

    public CustomArray(int size){
        this();
        this.size = size;
        this.arr = new int[size];
    }
    public CustomArray(int... args){
        this();
        this.size = args.length;
        this.arr = args;
    }
    public CustomArray(boolean isSorted, int... args){
        this(args);
        this.isSorted = true;
    }

    public int get(int index){
        if(index >= size || index <0){
            throw new ArrayIndexOutOfBoundsException("your index is not correct");
        }
        return arr[index];
    }

    public void set(int index, int value){
        arr[index] = value;
        this.isSorted = false;
    }

    public boolean delete(){
        if(size==0) return false;
        size--;
        return true;
    }
    public boolean delete(int index){
        if(index >= size || index <0){
            throw new ArrayIndexOutOfBoundsException("your index is not correct");
        }
        System.arraycopy(arr, index+1, arr, index, size-index -1);
        size--;
        return true;
    }
    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
    public void append(int value){
        if(size >= arr.length - 1){
            int[] temp=arr;
            arr = new int[size *2];
            System.arraycopy(temp, 0, arr,0,size);
        }
        arr[size++] = value;
        isSorted = false;
    }



    public boolean isInArray(int value){
        for (int i = 0; i < this.size ; i++) {
            if(this.arr[i]==value){
                return true;
            }
        }
        return false;
    }
    public int hasValue(int value){
        if(!isSorted) throw new RuntimeException("Array is unsorted");

        int l = 0;
        int r = size;
        int m;
        while(l < r){
            m = (l + r) >> 1;
            if (value == arr[m]){
                return m;
            }else{
                if(value < arr[m]){
                    r = m;
                } else {
                    l = m+1;
                }
            }
        }
        return -1;
    }

    private void swap(int a, int b){
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }


    
    public void sortSelect(){
        for (int i = 0; i < size; i++) {
            int flag = i;
            for (int j = i+1; j < size ; j++) {
                if(arr[j] < arr[flag]){
                    flag = j;
                }
                swap(i, flag);
            }
        }
        isSorted = true;
    }
    public void sortInsert(){
        for (int i = 1; i < size ; i++) {
            int temp = arr[i];
            int in = i;
            while(i > 0 && arr[i-1]>= temp){
                arr[i] = arr[i-1];
                in--;
            }
            arr[i] = temp;
        }
        isSorted = true;
    }

    //----------------------------------Homework
    //1. Дописать методы в классе массива
    boolean deleteAll(int value){ //by value Дословно понял так - удаляет из массива все заданные значения.
        boolean flag = false;
        for (int i = 0; i < size ; i++) {
            if (arr[i] == value){
                this.delete(i);
                flag = true;
            }
        }
        return flag;
    }
    boolean deleteAll(){ // понял, как удалить все элементы массива.
        size = 0;
        return true; //непонятно тогда, когда может быть НЕ true
    }

    void insert(int index, int value){
        if(index>size){
            throw new ArrayIndexOutOfBoundsException("Index is out of array's bounds");
        }
        if(size >= arr.length - 1){
            int[] temp=arr;
            arr = new int[size *2];
            System.arraycopy(temp, 0, arr,0,index-1);
            this.set(index, value);
            System.arraycopy(temp, index, arr,index+1,size-index);

        }
        this.size++;
        System.arraycopy(arr, index, arr,index+1,size-index);
        this.set(index, value);
    }
    //2.Улучшить пузырьковую сортировку
    public void sortBubble(){  //такая сортировка делает N^2/2 итераций. Но ассимптотическая сложность все равно n^2.
        for (int o = 0; o < size-1; o++) {
            for (int i = 0; i < size - 1 - o; i++) {
                if (this.arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
        isSorted = true;
    }
    //3.Число операций для сортировки пузырьком:
    //           алгоритм, написанный на занятии: (n-1)^2
    //           улучшенный алгоритм: (n-1)^2 /2
    //                 для сортировки выбором: (n-1)^2 /2
    //                 для сортировки вставкой: тоже (n-1)^2 /2
    // ачссимптотическая сложность для всех алгоритмов o(n^2)






}

