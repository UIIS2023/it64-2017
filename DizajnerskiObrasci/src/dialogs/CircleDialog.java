package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import shapes.Circle;
import shapes.Point;

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


public class CircleDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtRadius;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	
	private JLabel lblRadius;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	
	private boolean ok;
	
	private Color innerColor;
	private Color edgeColor;
	
	private JButton btnInnerColor;
	private JButton btnEdgeColor;
	
	public static void main(String[] args) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public CircleDialog() {
		setTitle("Circle");
		setBounds(100, 100, 568, 391);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Calibri", Font.BOLD, 20));
		txtRadius = new JTextField();
		txtRadius.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtRadius.setColumns(10);
		txtRadius.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		lblXCoordinate = new JLabel("X coordinate");
		lblXCoordinate.setFont(new Font("Calibri", Font.BOLD, 20));

		JLabel lblCentar = new JLabel("Center");
		lblCentar.setFont(new Font("Calibri", Font.BOLD | Font.BOLD, 20));

		lblYCoordinate = new JLabel("Y coordinate");
		lblYCoordinate.setFont(new Font("Calibri", Font.BOLD, 20));

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


		btnInnerColor = new JButton("Inner color");
		btnInnerColor.setFont(new Font("Calibri", Font.BOLD, 15));
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				innerColor = JColorChooser.showDialog(null, "Choose a color for the inside of the circle:",
						innerColor);
				if (innerColor == null) innerColor = Color.WHITE;
				btnInnerColor.setBackground(innerColor);
			}
		});

		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.setFont(new Font("Calibri", Font.BOLD, 15));
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose a color for the border of the circle:",
						edgeColor);
				if (edgeColor == null) edgeColor = Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRadius)
						.addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXCoordinate, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCentar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtXCoordinate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(txtYCoordinate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(txtRadius, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEdgeColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(46, Short.MAX_VALUE))))
		);
		
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(52)
								.addComponent(lblCentar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblXCoordinate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGap(40)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblRadius)
									.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnInnerColor)
								.addGap(13)))
						.addComponent(btnEdgeColor))
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
							Circle c = new Circle();
							c.setCenter(new Point(Integer.parseInt(getTxtXCoordinate()), Integer.parseInt(getTxtYCoordinate())));
							c.setRadius(Integer.parseInt(getTxtRadius()));
							setOk(true);
							dispose();
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos podataka. Unete vrednosti moraju biti brojevi.", "Greška",
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
		public String getTxtRadius() {
			return txtRadius.getText();
		}

		public void setTxtRadius(String txtRadius) {
			this.txtRadius.setText(txtRadius);
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

		public void setTxtKoordXEdt(boolean b) {
			this.txtXCoordinate.setEditable(b);
		}

		public void setTxtKoordYEdt(boolean b) {
			this.txtYCoordinate.setEditable(b);
		}

}
	