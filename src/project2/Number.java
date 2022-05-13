package project2;

import java.util.Random;

public class Number {
    int x, y;
    char c;

    Number(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    void move(char[][] map) {
        Random rnd = new Random();
        boolean flag = true;
        while (flag) {
            int random = rnd.nextInt(4);
            switch (random) {
                case 0:
                    if (map[x + 1][y] == ' ') {
                        this.x++;
                        flag = false;
                    }
                    break;
                case 1:
                    if (map[x - 1][y] == ' ') {
                        this.x--;
                        flag = false;
                    }
                    break;
                case 2:
                    if (map[x][y + 1] == ' ') {
                        this.y++;
                        flag = false;
                    }
                    break;
                case 3:
                    if (map[x][y - 1] == ' ') {
                        this.y--;
                        flag = false;
                    }
                    break;
            }
        }
    }
}