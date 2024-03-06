package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

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

import shapes.Donut;
import shapes.Point;

public class DonutDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtInnerRadius;
	private JTextField txtOuterRadius;
	
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblInnerRadius;
	private JLabel lblOuterRadius;
	
	private Color innerColor;
	private Color edgeColor;
	
	private JButton btnInnerColor;
	private JButton btnEdgeColor;
	private boolean ok;
	
	public static void main(String[] args) {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DonutDialog() {
		setBounds(100, 100, 521, 517);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblXCoordinate = new JLabel("X coordinate");
		lblXCoordinate.setFont(new Font("Calibri", Font.ITALIC, 20));
		lblYCoordinate = new JLabel("Y coordinate");
		lblYCoordinate.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtXCoordinate = new JTextField();
		txtXCoordinate.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtXCoordinate.setColumns(10);
		
		txtXCoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
	
		txtYCoordinate = new JTextField();
		txtYCoordinate.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtYCoordinate.setColumns(10);

		txtYCoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblInnerRadius = new JLabel("Inner radius");
		lblInnerRadius.setFont(new Font("Calibri", Font.ITALIC, 20));
		lblOuterRadius = new JLabel("Outer radius");
		lblOuterRadius.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtInnerRadius = new JTextField();
		txtInnerRadius.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtInnerRadius.setColumns(10);

		txtInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		txtOuterRadius = new JTextField();
		txtOuterRadius.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtOuterRadius.setColumns(10);

		txtOuterRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		
		btnInnerColor = new JButton("Inner color");
		btnInnerColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose a color for the inside of the circle:",
						innerColor);
				if (innerColor == null) innerColor = Color.WHITE;
				btnInnerColor.setBackground(innerColor);
			}
		});

		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose a color for the inside of the circle:",
						edgeColor);
				if (edgeColor == null) edgeColor = Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblInnerRadius, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoordinate, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addComponent(lblYCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblOuterRadius, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(233, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(160)
					.addComponent(lblCenter)
					.addContainerGap(372, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(156)
					.addComponent(lblRadius, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(415))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(301)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEdgeColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
					.addGap(157))
		);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(31)
						.addComponent(lblCenter)
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblXCoordinate)
							.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblYCoordinate)
							.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(43)
						.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblInnerRadius, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblOuterRadius, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEdgeColor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
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
					public void actionPerformed(ActionEvent e) {
						try {
							Donut d = new Donut(
									new Point(Integer.parseInt(getTxtXCoordinate()), Integer.parseInt(getTxtYCoordinate())),
									Integer.parseInt(getTxtOuterRadius()), Integer.parseInt(getTxtInnerRadius()));
							setOk(true);
							dispose();
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Unete vrednosti moraju biti brojevi!", "Greska",
									JOptionPane.WARNING_MESSAGE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Poluprecnici moraju da budu veci od nule i poluprecnik unutrasnjeg kruga mora da bude manji od poluprecnika velikog kruga!",
									"Greka", JOptionPane.WARNING_MESSAGE);
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

	public String getTxtXCoordinate() {
		return txtXCoordinate.getText();
	}

	public void setTxtXCoordinate(String txtXCoordinate) {
		this.txtXCoordinate.setText(txtXCoordinate);
	}

	public String getTxtYCoordinate() {
		return txtYCoordinate.getText();
	}

	public void setTxtYCoordinate(String txtYCoordinate) {
		this.txtYCoordinate.setText(txtYCoordinate);
	}

	public String getTxtInnerRadius() {
		return txtInnerRadius.getText();
	}

	public void setTxtInnerRadius(String txtInnerRadius) {
		this.txtInnerRadius.setText(txtInnerRadius);
	}

	public String getTxtOuterRadius() {
		return txtOuterRadius.getText();
	}

	public void setTxtOuterRadius(String txtOuterRadius) {
		this.txtOuterRadius.setText(txtOuterRadius);
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void setTxtXCoordEditable(boolean b) {
		this.txtXCoordinate.setEditable(b);
	}

	public void setTxtYCoordEditable(boolean b) {
		this.txtYCoordinate.setEditable(b);
	}

		
		
}
