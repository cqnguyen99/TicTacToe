import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends JFrame implements ActionListener
{
	private JButton[] btnPlay = new JButton[9];
	private JLabel lblDisplay = new JLabel("Welcome to TicTacToe!");
	private JPanel pnlMain = new JPanel(new BorderLayout());
	private JPanel pnlButtons = new JPanel(new GridLayout(3, 3));
	public TicTacToe()
	{
		for (int i = 0; i < 9; ++i)
			btnPlay[i] = new JButton("");
		addControls();
		registerListeners();		
		setTitle("TicTacToe");
		setSize(420, 450);
		getContentPane().setBackground(new java.awt.Color(255,204,51));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void addControls()
	{
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.add(pnlButtons, BorderLayout.CENTER);
		for (int i = 0; i < 9; ++i)
			pnlButtons.add(btnPlay[i]);
		lblDisplay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(lblDisplay, BorderLayout.NORTH);
	}
	public void registerListeners()
	{
		for (int i = 0; i < 9; ++i)
			btnPlay[i].addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		int turn = getTurn();
		for (int i = 0; i < 9; ++i)
			if (e.getSource() == btnPlay[i])
			{
				if (turn%2 != 0) 
				{
					btnPlay[i].setText("X");
					btnPlay[i].setFont(new Font("Times New Roman", Font.BOLD, 50));
					btnPlay[i].setForeground(new java.awt.Color(0,133,0));
				}
				else
				{
					btnPlay[i].setText("O");
					btnPlay[i].setFont(new Font("Times New Roman", Font.BOLD, 50));
					btnPlay[i].setForeground(new java.awt.Color(255,102,0));
				}
			}
		if (whoWin() == 1) 
		{
			lblDisplay.setText("Game over! X wins!");
		}
		else if (whoWin() == 2) 
		{
			lblDisplay.setText("Game over! O wins!");
		}
		else if (whoWin() == 0) 
		{
			lblDisplay.setText("Game over! Draw!");
		}
	}
	public int getTurn()
	{
		int result = 1;
		for (int i = 0; i < 9; ++i)
			if (btnPlay[i].getText() != "") ++result;
		return result;
	}
	//Return: -1 if no result, 1 if X wins, 2 if O wins, 0 if draw
	public int whoWin()
	{
		int result = -1;
		if ((btnPlay[0].getText() == "X" && btnPlay[1].getText() == "X"
			&& btnPlay[2].getText() == "X") || 
			(btnPlay[3].getText() == "X" && btnPlay[4].getText() == "X"
			&& btnPlay[5].getText() == "X") ||
			(btnPlay[6].getText() == "X" && btnPlay[7].getText() == "X"
			&& btnPlay[8].getText() == "X") ||
			(btnPlay[0].getText() == "X" && btnPlay[3].getText() == "X" 
			&& btnPlay[6].getText() == "X") || 
			(btnPlay[1].getText() == "X" && btnPlay[4].getText() == "X"
			&& btnPlay[7].getText() == "X") ||
			(btnPlay[2].getText() == "X" && btnPlay[5].getText() == "X"
			&& btnPlay[8].getText() == "X") ||
			(btnPlay[0].getText() == "X" && btnPlay[4].getText() == "X"
			&& btnPlay[8].getText() == "X") ||
			(btnPlay[2].getText() == "X" && btnPlay[4].getText() == "X" 
			&& btnPlay[6].getText() == "X")) result = 1;
		else if ((btnPlay[0].getText() == "O" && btnPlay[1].getText() == "O"
			&& btnPlay[2].getText() == "O") ||
			(btnPlay[3].getText() == "O" && btnPlay[4].getText() == "O"
			&& btnPlay[5].getText() == "O") || 
			(btnPlay[6].getText() == "O" && btnPlay[7].getText() == "O"
			&& btnPlay[8].getText() == "O") ||
			(btnPlay[0].getText() == "O" && btnPlay[3].getText() == "O" 
			&& btnPlay[6].getText() == "O") ||
			(btnPlay[1].getText() == "O" && btnPlay[4].getText() == "O"
			&& btnPlay[7].getText() == "O") ||
			(btnPlay[2].getText() == "O" && btnPlay[5].getText() == "O"
			&& btnPlay[8].getText() == "O") || 
			(btnPlay[0].getText() == "O" && btnPlay[4].getText() == "O"
			&& btnPlay[8].getText() == "O") ||
			(btnPlay[2].getText() == "O" && btnPlay[4].getText() == "O" 
			&& btnPlay[6].getText() == "O")) result = 2;
		else if (getTurn() == 10) result = 0;
		return result;
	}
	public static void main(String[] args)
	{
		TicTacToe f = new TicTacToe();			
	}
}