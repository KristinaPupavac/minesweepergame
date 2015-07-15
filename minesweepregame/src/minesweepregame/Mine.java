package minesweepregame;


/**
 * 
 * @author KrisTina
 *
 */
public class Mine {

	public static int numberOfBombs = (int) (Math.random() * 5) + 10;

	/**
	 * The method generates a random number of mines in random locations in the
	 * matrix
	 * 
	 * @return bombs - 2D array with bombs on random position
	 */
	public static int[][] fillMines() {
		int bombs[][] = new int[10][10];

		for (int i = 0; i < numberOfBombs; i++) {
			int randx = (int) (Math.random() * (10));
			int randy = (int) (Math.random() * (10));
			bombs[randx][randy] = -1;

		}
		return bombs;
	}

	/**
	 * The metod account number of mines around the position
	 * 
	 * @param bombs
	 *            - 2D array with bombs on random position
	 * @return arraymine - 2D array with bombs and number of bombs arond
	 *         position
	 */
	public static int[][] minesTable(int[][] bombs) {
		int[][] arrayMine = new int[bombs.length][bombs.length];
		for (int i = 0; i < bombs.length; i++) {
			for (int j = 0; j < bombs[i].length; j++) {

				if (bombs[i][j] == -1) {

					try {
						if (arrayMine[i][j - 1] != -1) {
							arrayMine[i][j - 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i][j + 1] != -1) {
							arrayMine[i][j + 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i + 1][j - 1] != -1) {
							arrayMine[i + 1][j - 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i - 1][j + 1] != -1) {
							arrayMine[i - 1][j + 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i - 1][j] != -1) {
							arrayMine[i - 1][j]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i + 1][j] != -1) {
							arrayMine[i + 1][j]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i + 1][j + 1] != -1) {
							arrayMine[i + 1][j + 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					try {
						if (arrayMine[i - 1][j - 1] != -1) {
							arrayMine[i - 1][j - 1]++;
						}
					} catch (ArrayIndexOutOfBoundsException ex) {

					}
					arrayMine[i][j] = -1;
				}

			}
		}

		return arrayMine;
	}
}
