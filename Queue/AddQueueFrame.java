import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddQueueFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fldInputQueue;
	private Queue queue;
	int clickCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQueueFrame frame = new AddQueueFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddQueueFrame() {
		queue = new Queue();
		clickCount = 9;

		setTitle("Queue Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInputQueue = new JLabel("Add to Queue:");
		lblInputQueue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputQueue.setBounds(50, 82, 115, 14);
		contentPane.add(lblInputQueue);

		fldInputQueue = new JTextField();
		fldInputQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		fldInputQueue.setBounds(175, 79, 196, 20);
		contentPane.add(fldInputQueue);
		fldInputQueue.setColumns(10);

		JTextArea fldNextQueue = new JTextArea();
		fldNextQueue.setEditable(false);
		fldNextQueue.setBounds(175, 174, 196, 22);
		contentPane.add(fldNextQueue);

		JButton btnAddVal = new JButton("Add Values");
		btnAddVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Adding Values to the Queue
				if (!fldInputQueue.getText().equals("")) {
					try {// Try to take the input Queue field and assign an integer
						queue.setQueueInt(Integer.parseInt(fldInputQueue.getText()));
						fldInputQueue.setText("");
					} // try
					catch (NumberFormatException e1) {
						try {// Try to take the input Queue field and assign an double
							queue.setQueueDouble(Double.parseDouble(fldInputQueue.getText()));
							fldInputQueue.setText("");
						} // try
						catch (NumberFormatException e2) {
							try {// Try to take the input Queue field and assign an String
								queue.setQueueString(fldInputQueue.getText());
								fldInputQueue.setText("");
							} // try
							catch (NumberFormatException e3) {
								JOptionPane.showMessageDialog(null, "Error occured: Value in invalid", "Invalid Value",
										JOptionPane.ERROR_MESSAGE);
								System.exit(-1);
							} // catch
						} // catch
					} // catch
				} // if (field is not empty)
			}// actionPerformed(ActionEvent e)
		});
		btnAddVal.setBounds(32, 215, 89, 23);
		contentPane.add(btnAddVal);
 
		JButton btnNextVal = new JButton("Display Next Value");
		btnNextVal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickCount--;
				// Which element is next in the Queue
				if (queue.getPointerReaderSeed() >= queue.getSeedCounter()) {
					fldNextQueue.setText("");
				} else if (queue.getQueueSeed() == 0) {
					fldNextQueue.setText(Integer.toString(queue.getQueueInt()));
					queue.incrementPointerReaderSeed();
				} else if (queue.getQueueSeed() == 1) {
					fldNextQueue.setText(Double.toString(queue.getQueueDouble()));
					queue.incrementPointerReaderSeed();
				} else if (queue.getQueueSeed() == 2) {
					fldNextQueue.setText(queue.getQueueString());
					queue.incrementPointerReaderSeed();
				} // Converts all data-types to string and sets it to the Next Queue Text Area
			}// actionPerformed(ActionEvent e)
		});
		btnNextVal.setBounds(131, 215, 170, 23);
		contentPane.add(btnNextVal);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInputQueue.setText("");
				fldNextQueue.setText("");
				queue.clearQueue();
			}
		});
		btnReset.setBounds(311, 215, 89, 23);
		contentPane.add(btnReset);
	}

}
