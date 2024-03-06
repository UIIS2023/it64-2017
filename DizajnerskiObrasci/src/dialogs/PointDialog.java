package dialogs;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import shapes.Point;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PointDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtX;
	private JTextField txtY;
	
	private JLabel lblX;
	private JLabel lblY;
	
	private boolean ok;
	private Color color;

	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public PointDialog() {
	
		setTitle("Point");
		setBounds(100, 100, 482, 426);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Calibri", Font.BOLD, 20));

		lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Calibri", Font.BOLD, 20));
		
		txtX = new JTextField();
		txtX.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtX.setColumns(10);

		
		txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		
		txtY = new JTextField();
		txtY.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtY.setColumns(10);

		txtY.addKeyListener(new KeyAdapter() {
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
				color = JColorChooser.showDialog(null, "Choose a color of your point", color);
				if (color == null) color = Color.BLACK;
				btnColor.setBackground(color);
			}
		});
		//contentPanel.add(btnColor);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblY, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addComponent(lblX, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtY, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(txtX, 200, 200, 200))
					.addContainerGap(230, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(372, Short.MAX_VALUE)
					.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(98)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblX)
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblY)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(43)
						.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(38))
			);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Calibri", Font.PLAIN, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							Point p = new Point();
							p.setX(Integer.parseInt(getTxtX()));
							p.setY(Integer.parseInt(getTxtY()));
							setOk(true);
							dispose();
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Uneti podaci moraju biti brojcani.", "Greska",
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
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ok = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public String getTxtX() {
		return this.txtX.getText();
	}
	
	public JTextField getTxtXX() {
		return this.txtX;
	}

	public void setTxtX(String txtX) {
		this.txtX.setText(txtX);
	}

	public String getTxtY() {
		return txtY.getText();
	}

	public void setTxtY(String txtY) {
		this.txtY.setText(txtY);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setTxtYEdt(boolean b) {
		this.txtY.setEditable(b);
	}

	public void setTxtXEdt(boolean b) {
		this.txtX.setEditable(b);
	}
		
}
