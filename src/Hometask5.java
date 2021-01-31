public class Hometask5 {


    private static int op = 0;

    private static void put(int from, int to){
        System.out.printf("%d - > %d | ",from, to);
        if((++op % 5) == 0) System.out.println();
    }

    private static void hanoi(int from, int to, int n){
        int temp = from ^ to;
        if (n==1){
            put(from, to);
        } else {
            hanoi(from, temp, n-1);
            put(from, to);
            hanoi(temp, to, n-1);
        }
    }


    private static int[][] moves = {
            {-2, 1},{-1, 2},{1, 2},{2, 1},
            {2, -1},{1, -2},{-1, -2},{-2, -1}
    };
    private static boolean isPossible(int[][] desk, int x, int y){
        return x>= 0 && x < desk[0].length &&
                y >=0 && y < desk.length &&
                desk[y][x] ==0;

    }
    private static boolean knight(int[][] desk, int x, int y, int move){
        desk[y][x] = move;
        if (move > desk.length * desk[0].length - 1) return true;

        int nextX;
        int nextY;
        for (int i = 0; i < moves.length-1; i++) {
            nextX = x + moves[i][0];
            nextY = y + moves[i][1];
            if (isPossible(desk, nextX,nextY) && knight(desk, nextX, nextY, move +1))
            return true;
        }
        desk[y][x] = 0;
        return false;
    }
    public static void main(String[] args) {
//        hanoi(1,3,8);
//        System.out.println();
//        System.out.println(op);
//
//        int[][] desk = new int[8][8];
//        knight(desk, 0,1,1);
//        printDesk(desk);
        //System.out.println(recPow(2,4));
        System.out.println(KingsWays(19,19)); //при таком "поле" уже наблюдаются проблемы с производительностью
                                                    //а при поле 20х20 программа зависает
    }

    private static void printDesk(int[][] desk){
        for (int y = 0; y < desk.length ; y++) {
            for (int x = 0; x < desk[y].length; x++) {
                System.out.printf("%3d", desk[y][x]);
            }
            System.out.println();
        }
    }


    //----------------------HOMETASK---------------------

    //Возведение в степень

    private static int recPow(int a, int power){
        if(power == 1){
            return a;
        }
        else{
            return a * recPow(a, power -1);
        }
    }

    //Шахматный Король. Король находится в верхней левой клетке.
    // Считаем количество маршрутов в нижнюю правую клетку.
    //В качестве параметра передаем размер поля.
    private static double KingsWays(int x, int y){ // создаем функцию для подсчета кол-ва путей попадания в точку (х,y)
        if(x == 1 || y == 1){
            return 1;
        }
        return KingsWays(x-1,y) + KingsWays(x, y - 1); //по ощущениям - есть более оптимальный вариант реализации через рекурсию.
                                                            // При текущей реализации стек раздувается со скоростью 2^n. И для поля 20х20 программа зависает.
    }

    //Задача о ферзе. Не добил

//    int[][] desk = new int[8][8];
//
//    private static boolean setQueen(int[][] desk, int x, int y){
//
//        for (int i = 0; i < desk.length; i++) {
//            for (int j = 0; j < desk[0].length; j++) {
//                if(desk[i][j] == 0){
//
//                }
//            }
//        }
//
//        int nextX = findFreeX(desk);
//        int nextY = findFreeY(desk);
//
//        if(nextX != -1 && nextY != -1 && setQueen(desk, nextX, nextY )){
//            return true;
//        }
//        return
//
//
//
//
//    }
//
//    private static int findFreeX(int[][] desk){
//        for (int i = 0; i < desk.length; i++) {
//            for (int j = 0; j < desk[0].length; j++) {
//                if(desk[i][j] == 0){
//                    return j;
//                }
//            }
//        }
//        return -1;
//    }
//    private static int findFreeY(int[][] desk){
//        for (int i = 0; i < desk.length; i++) {
//            for (int j = 0; j < desk[0].length; j++) {
//                if(desk[i][j] == 0){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
}
