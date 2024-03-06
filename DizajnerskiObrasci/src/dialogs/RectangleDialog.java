package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shapes.Point;
import shapes.Rectangle;

public class RectangleDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private Rectangle rectangle = null;
	
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	
	private JTextField txtHeight;
	private JTextField txtWidth;
	
	private boolean ok;
	
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	
	private JLabel lblHeight;
	private JLabel lblWidth;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private JButton btnInnerColor;
	private JButton btnEdgeColor;
	
	private Color innerColor;
	private Color edgeColor;
	
	
	public static void main(String[] args) {
		try {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RectangleDialog() {
		setTitle("Rectangle");
		setBounds(100, 100, 802, 508);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblXCoordinate = new JLabel("X coordinate of upper left point:");
			lblXCoordinate.setFont(new Font("Calibri", Font.ITALIC, 20));
			lblXCoordinate.setHorizontalTextPosition(SwingConstants.LEFT);
			lblXCoordinate.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			txtXCoordinate = new JTextField();
			txtXCoordinate.setFont(new Font("Calibri", Font.PLAIN, 20));
			txtXCoordinate.setColumns(10);
		}
		
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
		{
			lblYCoordinate = new JLabel("Y coordinate of upper left point:");
			lblYCoordinate.setFont(new Font("Calibri", Font.ITALIC, 20));
		}
		{
			txtYCoordinate = new JTextField();
			txtYCoordinate.setFont(new Font("Calibri", Font.PLAIN, 20));
			txtYCoordinate.setColumns(10);
		}

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
		{
			lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Calibri", Font.ITALIC, 20));
		}
		{
			txtHeight = new JTextField();
			txtHeight.setFont(new Font("Calibri", Font.PLAIN, 20));
			txtHeight.setColumns(10);
		}

		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		{
			lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Calibri", Font.ITALIC, 20));

		}
		{
			txtWidth = new JTextField();
			txtWidth.setFont(new Font("Calibri", Font.PLAIN, 20));
			txtWidth.setText("");
			txtWidth.setColumns(10);
		}

		txtWidth.addKeyListener(new KeyAdapter() {
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
				innerColor = JColorChooser.showDialog(null, "Choose an inside color of your rectangle:", innerColor);
				if (innerColor == null) innerColor = Color.BLACK;
				btnInnerColor.setBackground(innerColor);
			}
		});
		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose an outside color of your rectangle:", edgeColor);
				if (edgeColor == null) edgeColor = Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(465, Short.MAX_VALUE)
					.addComponent(btnEdgeColor)
					.addGap(28)
					.addComponent(btnInnerColor)
					.addGap(77))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblXCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(10))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
							.addGap(49)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtXCoordinate, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addComponent(txtYCoordinate, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
								.addComponent(txtWidth, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
					.addGap(233))
		);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(38)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblXCoordinate, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblYCoordinate, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHeight))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGap(49)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEdgeColor)
							.addComponent(btnInnerColor))
						.addGap(32))
			);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Calibri", Font.PLAIN, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Rectangle r = new Rectangle();
							r.setUpperLeftPoint(new Point(Integer.parseInt(getTxtXCoordinate()),
									Integer.parseInt(getTxtYCoordinate())));
							r.setWidth(Integer.parseInt(getTxtWidth()));
							r.setHeight(Integer.parseInt(getTxtHeight()));
							ok = true;
							dispose();
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Neispravan unos. Proverite da li su sva polja ispunjena brojnim vrednostima.",
									"Greka!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ok = false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(610)
							.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(3).addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addContainerGap()));
			gl_buttonPane.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addContainerGap().addGroup(gl_buttonPane
							.createParallelGroup(Alignment.BASELINE).addComponent(okButton).addComponent(cancelButton))
							.addContainerGap()));
			buttonPane.setLayout(gl_buttonPane);

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

	public String getTxtHeight() {
		return txtHeight.getText();
	}

	public void setTxtHeight(String txtHeight) {
		this.txtHeight.setText(txtHeight);
	}

	public String getTxtWidth() {
		return txtWidth.getText();
	}

	public void setTxtWidth(String txtWidth) {
		this.txtWidth.setText(txtWidth);
		
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

	public void setTxtXKoordinataEnabled(boolean b) {
		this.txtXCoordinate.setEditable(b);
	}

	public void setTxtYKoordinataEnabled(boolean b) {
		this.txtYCoordinate.setEditable(b);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

}
