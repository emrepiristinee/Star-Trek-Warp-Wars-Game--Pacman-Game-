package project2;

import java.awt.event.KeyListener;
import enigma.core.Enigma;
import java.awt.event.KeyEvent;

public class Player {
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)
	public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	public KeyListener klis;
	static int cursorX = 1, cursorY = 1;
	public static char send = ' ';
	public static StarTrek st = new StarTrek();
	public static boolean GameEnd = false;

	void CursorMovement(char[][] map, ClassNumber[] numbers) {
		displayBackPack(S1ForBackPack);
		cn.getTextWindow().setCursorPosition(cursorX, cursorY);
		System.out.print("P");
		while (true) {
			KeyListener klis = new KeyListener() {
				public void keyTyped(KeyEvent e) {
				}

				public void keyPressed(KeyEvent e) {
					if (keypr == 0) {
						keypr = 1;
						rkey = e.getKeyCode();
					}
				}

				public void keyReleased(KeyEvent e) {
				}
			};
			cn.getTextWindow().addKeyListener(klis);
			if (keypr == 1) {
				if (cursorY != 1 && rkey == KeyEvent.VK_UP && map[cursorX][cursorY - 1] != '#') { // up
					if (map[cursorX][cursorY - 1] == '1' || map[cursorX][cursorY - 1] == '2'
							|| map[cursorX][cursorY - 1] == '3' || map[cursorX][cursorY - 1] == '4'
							|| map[cursorX][cursorY - 1] == '5') {
						send = (char) map[cursorX][cursorY - 1];
						cursorY--;
						AddBackPack(send, numbers);
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX, cursorY + 1);
						System.out.print(" ");
						map[cursorX][cursorY + 1] = ' ';
						rkey = 0;
						break;
					} else if (map[cursorX][cursorY - 1] == ' ') {
						cursorY--;
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX, cursorY + 1);
						System.out.print(" ");
						map[cursorX][cursorY + 1] = ' ';
						if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
								|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
								|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // down
								|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // up
							DeleteBackPack(S1ForBackPack);
							rkey = 0;
							break;
						}
						rkey = 0;
						break;
					} else if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
							|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
							|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // up
							|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // down
						DeleteBackPack(S1ForBackPack);
						rkey = 0;
						break;
					}
				}

				if (cursorY != 22 && rkey == KeyEvent.VK_DOWN && map[cursorX][cursorY + 1] != '#') { // down
					if (map[cursorX][cursorY + 1] == '1' || map[cursorX][cursorY + 1] == '2'
							|| map[cursorX][cursorY + 1] == '3' || map[cursorX][cursorY + 1] == '4'
							|| map[cursorX][cursorY + 1] == '5') {
						send = (char) map[cursorX][cursorY + 1];
						cursorY++;
						AddBackPack(send, numbers);
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX, cursorY - 1);
						System.out.print(" ");
						map[cursorX][cursorY - 1] = ' ';
						rkey = 0;
						break;
					} else if (map[cursorX][cursorY + 1] == ' ') {
						cursorY++;
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX, cursorY - 1);
						System.out.print(" ");
						map[cursorX][cursorY - 1] = ' ';
						if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
								|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
								|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // up
								|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // down
							DeleteBackPack(S1ForBackPack);
							rkey = 0;
							break;
						}
						rkey = 0;
						break;
					} else if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
							|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
							|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // up
							|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // down
						DeleteBackPack(S1ForBackPack);
						rkey = 0;
						break;
					}
				}

				if (cursorX != 1 && rkey == KeyEvent.VK_LEFT && map[cursorX - 1][cursorY] != '#') { // left
					if (map[cursorX - 1][cursorY] == '1' || map[cursorX - 1][cursorY] == '2'
							|| map[cursorX - 1][cursorY] == '3' || map[cursorX - 1][cursorY] == '4'
							|| map[cursorX - 1][cursorY] == '5') {
						send = (char) map[cursorX - 1][cursorY];
						cursorX--;
						AddBackPack(send, numbers);
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX + 1, cursorY);
						System.out.print(" ");
						map[cursorX + 1][cursorY] = ' ';
						rkey = 0;
						break;
					} else if (map[cursorX - 1][cursorY] == ' ') {
						cursorX--;
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX + 1, cursorY);
						System.out.print(" ");
						map[cursorX + 1][cursorY] = ' ';
						if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
								|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
								|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // down
								|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // up
							DeleteBackPack(S1ForBackPack);
							rkey = 0;
							break;
						}
						rkey = 0;
						break;
					} else if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
							|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
							|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // up
							|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // down
						DeleteBackPack(S1ForBackPack);
						rkey = 0;
						break;
					}

				}
				if (cursorX != 54 && rkey == KeyEvent.VK_RIGHT && map[cursorX + 1][cursorY] != '#') { // right
					if (map[cursorX + 1][cursorY] == '1' || map[cursorX + 1][cursorY] == '2'
							|| map[cursorX + 1][cursorY] == '3' || map[cursorX + 1][cursorY] == '4'
							|| map[cursorX + 1][cursorY] == '5') {
						send = (char) map[cursorX + 1][cursorY];
						cursorX++;
						AddBackPack(send, numbers);
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX - 1, cursorY);
						System.out.print(" ");
						map[cursorX - 1][cursorY] = ' ';
						rkey = 0;
						break;
					} else if (map[cursorX + 1][cursorY] == ' ') {
						cursorX++;
						cn.getTextWindow().setCursorPosition(cursorX, cursorY);
						System.out.print("P");
						map[cursorX][cursorY] = 'P';
						cn.getTextWindow().setCursorPosition(cursorX - 1, cursorY);
						System.out.print(" ");
						map[cursorX - 1][cursorY] = ' ';
						if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
								|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
								|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // down
								|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // up
							DeleteBackPack(S1ForBackPack);
							rkey = 0;
							break;
						}
						rkey = 0;
						break;
					} else if (map[cursorX + 1][cursorY] == 'C' || map[cursorX - 1][cursorY] == 'C' // left, right
							|| map[cursorX][cursorY - 1] == 'C' || map[cursorX][cursorY + 1] == 'C' // down, up
							|| map[cursorX + 1][cursorY + 1] == 'C' || map[cursorX - 1][cursorY + 1] == 'C' // down
							|| map[cursorX + 1][cursorY - 1] == 'C' || map[cursorX - 1][cursorY - 1] == 'C') { // up
						DeleteBackPack(S1ForBackPack);
						rkey = 0;
						break;
					}

				}

				if (cursorY != 1 && rkey == KeyEvent.VK_W) {// up
					rkey = 0;
					WASDforBackPack(S1ForBackPack, map, 1);
					break;
				}
				if (cursorX != 1 && rkey == KeyEvent.VK_A) {// left
					rkey = 0;
					WASDforBackPack(S1ForBackPack, map, 2);
					break;
				}
				if (cursorY != 22 && rkey == KeyEvent.VK_S) { // down
					rkey = 0;
					WASDforBackPack(S1ForBackPack, map, 3);
					break;
				}
				if (cursorX != 54 && rkey == KeyEvent.VK_D) { // right
					rkey = 0;
					WASDforBackPack(S1ForBackPack, map, 4);
					break;
				}
				keypr = 0;
				rkey = 0;
			}
			rkey = 0;
			keypr = 0;
			break;
		}

	}

	public static void AddBackPack(char gelen, ClassNumber[] numbers) {
		// If it is 1, the score is increasing, if not, it takes the necessary actions
		int counter = 0;

		if (gelen == '1') {
			score = score + 1;
		}

		else {
			switch (gelen) {
			case '2': {
				if (S1ForBackPack.isEmpty()) {
					score = score + 5;
					S1ForBackPack.push(gelen);
				} else {
					score = score + 5;

					if (S1ForBackPack.peek().equals(gelen)) {
						S1ForBackPack.pop();
						energy = energy + 30;
					} else {
						if (S1ForBackPack.peek().equals('*') || S1ForBackPack.peek().equals('=')) {
							S1ForBackPack.push(gelen);
						} else {
							S1ForBackPack.pop();
						}
					}
				}

			}
				break;

			case '3': {
				if (S1ForBackPack.isEmpty()) {
					score = score + 15;
					S1ForBackPack.push(gelen);
				} else {
					score = score + 15;

					if (S1ForBackPack.peek().equals(gelen)) {
						S1ForBackPack.pop();
						S1ForBackPack.push('=');
					}

					else {
						if (S1ForBackPack.peek().equals('*') || S1ForBackPack.peek().equals('=')) {
							S1ForBackPack.push(gelen);
						} else {
							S1ForBackPack.pop();
						}
					}
				}

			}

				break;

			case '4': {
				while (true) {
					if (numbers[counter] != null && numbers[counter].x == cursorX && numbers[counter].y == cursorY) {
						numbers[counter] = null;
						break;
					}
					counter++;
				}

				if (S1ForBackPack.isEmpty()) {
					score = score + 50;
					S1ForBackPack.push(gelen);
				}

				else {
					score = score + 50;

					if (S1ForBackPack.peek().equals(gelen)) {
						S1ForBackPack.pop();
						energy = energy + 240;
					}

					else {
						if (S1ForBackPack.peek().equals('*') || S1ForBackPack.peek().equals('=')) {
							S1ForBackPack.push(gelen);
						}

						else {
							S1ForBackPack.pop();
						}
					}
				}

			}
				break;

			case '5': {
				while (true) {
					if (numbers[counter] != null && numbers[counter].x == cursorX && numbers[counter].y == cursorY) {
						numbers[counter] = null;
						break;
					}
					counter++;
				}
				if (S1ForBackPack.isEmpty()) {
					score = score + 150;
					S1ForBackPack.push(gelen);
				} else {
					score = score + 150;

					if (S1ForBackPack.peek().equals(gelen)) {
						S1ForBackPack.pop();
						S1ForBackPack.push('*');
					}

					else {
						if (S1ForBackPack.peek().equals('*') || S1ForBackPack.peek().equals('=')) {
							S1ForBackPack.push(gelen);
						} else {
							S1ForBackPack.pop();
						}
					}
				}
			}
				break;
			}
		}
		displayBackPack(S1ForBackPack);
	}

	public static void displayBackPack(Stack S1ForBackPack) {

		char peek = ' ';

		if (S1ForBackPack.isEmpty()) {
			peek = ' ';
			st.magenta();
			cn.getTextWindow().setCursorPosition(56, 5);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 6);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 7);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 8);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 9);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 10);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 11);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 12);
			System.out.print("| " + peek + " |");
			cn.getTextWindow().setCursorPosition(56, 13);
			System.out.print("+---+");
			cn.getTextWindow().setCursorPosition(56, 14);
			st.white();
			System.out.println("P.Backpack");
		}

		else {
			Stack tempStack = new Stack(S1ForBackPack.size());
			int size = S1ForBackPack.size();
			for (int i = 0; i < size; i++) {
				tempStack.push(S1ForBackPack.pop());
			}
			size = tempStack.size();
			for (int i = 0; i < size; i++) {
				S1ForBackPack.push(tempStack.pop());
				peek = (char) S1ForBackPack.peek();
				cn.getTextWindow().setCursorPosition(58, (12 - i) - 1);
				System.out.println(" ");
				cn.getTextWindow().setCursorPosition(58, 12 - i);
				st.orange();
				System.out.println(peek);

			}
		}

	}

	public static void DeleteBackPack(Stack S1ForBackPack) {
		for (int i = 0; i < 2; i++) {
			if (S1ForBackPack.isEmpty()) {
				break;
			} else {
				S1ForBackPack.pop();
				if (S1ForBackPack.isEmpty()) {
					break;
				}
			}
		}
	}

	public static void WASDforBackPack(Stack S1ForBackPack, char[][] map, int key) {
		char peek = ' ';
		if ((char) S1ForBackPack.peek() == '=' || (char) S1ForBackPack.peek() == '*') {
			switch (key) {
			case 1: // W up
			{
				if (map[cursorX][cursorY - 1] == ' ') {
					peek = (char) S1ForBackPack.pop();
					map[cursorX][cursorY - 1] = peek;
					cn.getTextWindow().setCursorPosition(cursorX, cursorY - 1);
					System.out.print(peek);
				} else {
					break;
				}
			}
				break;
			case 2: // D left
			{
				if (map[cursorX - 1][cursorY] == ' ') {
					peek = (char) S1ForBackPack.pop();
					map[cursorX - 1][cursorY] = peek;
					cn.getTextWindow().setCursorPosition(cursorX - 1, cursorY);
					System.out.print(peek);
				} else {
					break;
				}
			}
				break;
			case 3: // S down
			{
				if (map[cursorX][cursorY + 1] == ' ') {
					peek = (char) S1ForBackPack.pop();
					map[cursorX][cursorY + 1] = peek;
					cn.getTextWindow().setCursorPosition(cursorX, cursorY + 1);
					System.out.print(peek);
				} else {
					break;
				}
			}
				break;
			case 4: // A right
			{
				if (map[cursorX + 1][cursorY] == ' ') {
					peek = (char) S1ForBackPack.pop();
					map[cursorX + 1][cursorY] = peek;
					cn.getTextWindow().setCursorPosition(cursorX + 1, cursorY);
					System.out.print(peek);
				} else {
					break;
				}
			}
				break;

			default:
				break;
			}
		} else {

		}
	}

	static Stack S1ForBackPack = new Stack(8);
	public static int score = 0;
	static int energy = 50;
	static int life = 5;

}