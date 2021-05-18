package game;

import java.util.Random;
import java.util.Scanner;

public class game {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил искуственный интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {

        if (map[1][1] == DOT_EMPTY) {
            map[1][1] = DOT_O;
            System.out.println("Компьютер сделал ход в точку " + (3) + " " + (3));
        } else {
            Random random = new Random();
            int x;
            int y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер сделал ход в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }

    public static void humanTurn() {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean checkWin(char symb) {
        return (checkRowToWin(symb) || checkColToWin(symb) || checkDiagonalToWin(symb));
    }

    public static boolean checkRowToWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    counter++;
                }
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkColToWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    counter++;
                }
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalToWin(char symb) {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                counter++;
            }
        }
        if (counter == DOTS_TO_WIN) {
            return true;
        }

        counter = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if (map[i][j] == symb) {
                counter++;
            }
        }
        if (counter == DOTS_TO_WIN) {
            return true;
        }
        return false;
    }
}
