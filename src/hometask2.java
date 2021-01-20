public class hometask2 {
    public static void main(String[] args) {
        CustomArray arr = new CustomArray(7,3,3,4,5,1,7,1,0);
//        System.out.println(arr);
//        arr.delete();
//        arr.delete();
//        System.out.println(arr);
//        arr.delete(2);
//        System.out.println(arr);
//        arr.deleteAll(1);
//        System.out.println(arr);
//        //arr.deleteAll();
//        arr.insert(0,6);
//        System.out.println(arr);
        arr.sortBubble();
        System.out.println(arr);
        System.out.println(arr.hasValue(5));

    }
}
