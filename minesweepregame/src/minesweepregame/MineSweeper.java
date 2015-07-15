package minesweepregame;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author KrisTina
 *
 */
public class MineSweeper extends JFrame {
	private static final long serialVersionUID = 1248435587414935159L;
	private ImageIcon img = new ImageIcon("src/bomb3.png");
	private static ImageIcon img1 = new ImageIcon("src/booom.png");
	private static JButton[][] buttons = new JButton[10][10];
	public static int[][] mine = Mine.minesTable(Mine.fillMines());
	public static JMenuBar bar = new JMenuBar();
	public static JMenu menu1 = new JMenu("Game");
	public static JMenu menu2 = new JMenu("GIT");
	public static JMenuItem item1 = new JMenuItem("New");
	public static JMenuItem item2 = new JMenuItem("Exit");
	public static JMenuItem item3 = new JMenuItem("GitKristina");

	public static JPanel panel = new JPanel();
	public static JPanel panel1 = new JPanel();

	/**
	 * Constructor and game logic
	 */
	public MineSweeper() {
		setLayout(new BorderLayout());
		bar.add(menu1);
		bar.add(menu2);
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);


		add(bar, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new GridLayout(0, 2));
		panel.setLayout(new GridLayout(10, 10, 3, 3));

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton(img);
				panel.add(buttons[i][j]);
				buttons[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < buttons.length; i++) {
							for (int j = 0; j < buttons.length; j++) {
								if (e.getSource() == buttons[i][j]) {
									if (mine[i][j] == 0) {
										repaint();
										open(i, j);
									} else if (mine[i][j] == 1
											|| mine[i][j] == 2
											|| mine[i][j] == 3
											|| mine[i][j] == 4) {
										buttons[i][j].setText(mine[i][j] + "");
										buttons[i][j].setOpaque(true);
										buttons[i][j].setBorderPainted(false);
										buttons[i][j].setForeground(Color.CYAN);
										buttons[i][j].setFont(new Font("Serif",
												Font.BOLD, 25));
										buttons[i][j].setEnabled(false);
										open(i, j);
									} else if (mine[i][j] == -1) {
										buttons[i][j].setOpaque(true);
										buttons[i][j].setBorderPainted(false);
										buttons[i][j]
												.setBackground(Color.WHITE);
										buttons[i][j].setIcon(img1);
										buttons[i][j].setEnabled(true);
										openAll();
										repaint();
										int dialog = JOptionPane
												.showConfirmDialog(null,
														"You LOSE! Do you want to play again?");

										if (dialog == JOptionPane.YES_OPTION) {
											panel = new JPanel();
											repaint();

											mine = Mine.minesTable(Mine
													.fillMines());

											new MineSweeper();
										} else if (dialog == JOptionPane.NO_OPTION) {
											System.exit(0);
										} else if (dialog == JOptionPane.CANCEL_OPTION) {
											System.exit(0);
										}
									}

								}
							}

						}
						isWin();
					}

				});
			}
		}

		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel = new JPanel();
				dispose();
				repaint();
				mine = Mine.minesTable(Mine.fillMines());
				new MineSweeper();

			}

		});

		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/KristinaPupavac/homeworks/tree/minesweeper/minesweeper"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setTitle("MineSweeper");
		setVisible(true);
	}

	/**
	 * Recursion function for opening fields
	 * 
	 * @param x
	 *            - coordinate of 2d array position and button position
	 * @param y
	 *            - coordinate of 2d array position and button position
	 */
	public static void open(int x, int y) {
		if (x < 0 || x >= mine.length || y < 0 || y >= mine.length) {
			return;
		}
		if (mine[x][y] == 1) {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setBackground(new Color(233, 14, 102));
		}
		if (mine[x][y] == 2) {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setBackground(new Color(255, 4, 221));
			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
		}
		if (mine[x][y] == 3) {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setBackground(new Color(137, 6, 50));
			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
		}
		if (mine[x][y] == 4) {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setBackground(new Color(228, 15, 29));
			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
		}

		if (mine[x][y] == 0 && buttons[x][y].isEnabled() != false) {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setText("0");
			buttons[x][y].setBackground(new Color(250, 209, 225));
			buttons[x][y].setEnabled(false);
			open(x + 1, y);
			open(x - 1, y);
			open(x, y + 1);
			open(x, y - 1);
			open(x - 1, y - 1);
			open(x + 1, y - 1);
			open(x - 1, y + 1);
			open(x - 1, y + 1);
		} else {
			buttons[x][y].setOpaque(true);
			buttons[x][y].setBorderPainted(false);

			buttons[x][y].setForeground(Color.CYAN);
			buttons[x][y].setFont(new Font("Serif", Font.BOLD, 25));
			buttons[x][y].setText("" + mine[x][y]);
			buttons[x][y].setEnabled(false);
		}
		return;
	}

	/**
	 * The method account is number of bombs equal number of not clicked fields,
	 * if is, the player wins, and asking player "Do you want to play again?"
	 */
	public void isWin() {
		int counter = 0;
		for (int i = 0; i < mine.length; i++)
			for (int j = 0; j < mine[i].length; j++) {
				if (buttons[i][j].isEnabled() != false) {
					counter++;
				}
			}

		if (counter == Mine.numberOfBombs) {
			openAll();
			repaint();
			int c = JOptionPane.showConfirmDialog(null,
					"You WIN! Do you want to play again?");
			if (c == JOptionPane.YES_OPTION) {
				panel = new JPanel();
				dispose();
				repaint();
				mine = Mine.minesTable(Mine.fillMines());
				new MineSweeper();
			} else if (c == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if (c == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * The method open all fields, and put image of bomb on 2D array position -1.
	 * Fields that are not clicked are gray.
	 */
	public static void openAll() {
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine[i].length; j++) {
				if (mine[i][j] == -1) {
					buttons[i][j].setOpaque(true);
					buttons[i][j].setBorderPainted(false);
					buttons[i][j].setBackground(Color.WHITE);
					buttons[i][j].setIcon(img1);
					buttons[i][j].setEnabled(true);
				} else {
					buttons[i][j].setFont(new Font("Serif", Font.BOLD, 25));
					buttons[i][j].setForeground(Color.CYAN);
					buttons[i][j].setText(mine[i][j] + "");
					buttons[i][j].setEnabled(false);
				}
			}
		}
	}
}
