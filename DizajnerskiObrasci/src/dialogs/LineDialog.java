package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Line;
import shapes.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtStartPointX;
	private JTextField txtStartPointY;
	
	private JTextField txtEndPointX;
	private JTextField txtEndPointY;
	
	private JLabel lblStartPointX;
	private JLabel lblStartPointY;
	
	private JLabel lblEndPointX;
	private JLabel lblEndPointY;
	
	private boolean ok;
	private Color color;
	
	public static void main(String[] args) {
		try {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LineDialog() {
		setTitle("Line");
		setBounds(100, 100, 501, 493);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblStartPoint = new JLabel("Start point");
		lblStartPoint.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 21));
		
		lblStartPointX = new JLabel("X coordinate:");
		lblStartPointX.setFont(new Font("Calibri", Font.ITALIC, 20));
		
		lblStartPointY = new JLabel("Y coordinate:");
		lblStartPointY.setFont(new Font("Calibri", Font.ITALIC, 20));
		
		JLabel lblEndPoint = new JLabel("End point");
		lblEndPoint.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 21));
		
		lblEndPointX = new JLabel("X coordinate:");
		lblEndPointX.setFont(new Font("Calibri", Font.ITALIC, 20));
		
		lblEndPointY = new JLabel("Y coordinate:");
		lblEndPointY.setFont(new Font("Calibri", Font.ITALIC, 20));

		txtStartPointX = new JTextField();
		txtStartPointX.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtStartPointX.setColumns(10);

		txtStartPointX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		txtStartPointY = new JTextField();
		txtStartPointY.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtStartPointY.setColumns(10);

		txtStartPointY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		
		txtEndPointX = new JTextField();
		txtEndPointX.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtEndPointX.setColumns(10);

		txtEndPointX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		txtEndPointY = new JTextField();
		txtEndPointY.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtEndPointY.setColumns(10);

		txtEndPointY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		JButton btnColor = new JButton("Color");
		btnColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color = JColorChooser.showDialog(null, "Choose a color of your line", color);
				if (color == null) color = Color.BLACK;
				btnColor.setBackground(color);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblStartPointY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblStartPointX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEndPointX, Alignment.LEADING)
						.addComponent(lblEndPointY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEndPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStartPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStartPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEndPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(140)
					.addComponent(lblStartPoint)
					.addContainerGap(378, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(144)
					.addComponent(lblEndPoint, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(343))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					.addComponent(btnColor)
					.addGap(140))
		);
		
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(25)
						.addComponent(lblStartPoint)
						.addGap(28)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblStartPointX)
							.addComponent(txtStartPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblStartPointY)
							.addComponent(txtStartPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addComponent(lblEndPoint, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtEndPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEndPointX))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEndPointY)
							.addComponent(txtEndPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
						.addComponent(btnColor)
						.addContainerGap())
			);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Calibri", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							Line l = new Line();
							l.setStartPoint(new Point(Integer.parseInt(getTxtStartPointX()),
									Integer.parseInt(getTxtStartPointY())));
							l.setEndPoint(new Point(Integer.parseInt(getTxtEndPointX()),
									Integer.parseInt(getTxtEndPointY())));
							setOk(true);
							dispose();
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka.Unete vrednosti moraju biti brojevi!", "Greka",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public String getTxtStartPointX() {
		return txtStartPointX.getText();
	}

	public void setTxtStartPointX(String txtStartPointX) {
		this.txtStartPointX.setText(txtStartPointX);
	}

	public String getTxtStartPointY() {
		return txtStartPointY.getText();
	}

	public void setTxtStartPointY(String txtStartPointY) {
		this.txtStartPointY.setText(txtStartPointY);
	}

	public String getTxtEndPointX() {
		return txtEndPointX.getText();
	}

	public void setTxtEndPointX(String txtEndPointX) {
		this.txtEndPointX.setText(txtEndPointX);
	}

	public String getTxtEndPointY() {
		return txtEndPointY.getText();
	}

	public void setTxtEndPointY(String txtEndPointY) {
		this.txtEndPointY.setText(txtEndPointY);
		;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Color getCol() {
		return color;
	}

	public void setCol(Color col) {
		this.color = col;
	}

	public void setTxtEndPointXEdt(boolean b) {
		this.txtEndPointX.setEditable(b);

	}

	public void setTxtEndPointYEdt(boolean b) {
		this.txtEndPointY.setEditable(b);
	}

	public void setTxtStartPointXEdt(boolean b) {
		this.txtStartPointX.setEditable(b);
	}

	public void setTxtStartPointYEdt(boolean b) {
		this.txtStartPointY.setEditable(b);
	}			
}
