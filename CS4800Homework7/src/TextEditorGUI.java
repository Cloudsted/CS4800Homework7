import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextEditorGUI extends JFrame {
    private JTextArea textArea;
    private JButton applyButton;
    private JComboBox<String> fontComboBox;
    private JComboBox<String> colorComboBox;
    private JComboBox<Integer> sizeComboBox;

    public TextEditorGUI() {
        super("Text Editor");

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel propertiesPanel = new JPanel();
        fontComboBox = new JComboBox<>(new String[]{"Arial", "Calibri", "Verdana"});
        colorComboBox = new JComboBox<>(new String[]{"Red", "Blue", "Black"});
        sizeComboBox = new JComboBox<>(new Integer[]{12, 14, 16});
        applyButton = new JButton("Apply Properties");

        propertiesPanel.add(new JLabel("Font:"));
        propertiesPanel.add(fontComboBox);
        propertiesPanel.add(new JLabel("Color:"));
        propertiesPanel.add(colorComboBox);
        propertiesPanel.add(new JLabel("Size:"));
        propertiesPanel.add(sizeComboBox);
        propertiesPanel.add(applyButton);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTextProperties();
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(propertiesPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void applyTextProperties() {
        String font = (String) fontComboBox.getSelectedItem();
        String color = (String) colorComboBox.getSelectedItem();
        int size = (Integer) sizeComboBox.getSelectedItem();

        CharacterProperties properties = CharacterPropertiesFactory.getProperties(font, color, size);
        textArea.setFont(new Font(properties.getFont(), Font.PLAIN, properties.getSize()));
        textArea.setForeground(properties.getColor());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TextEditorGUI();
				
			}
        });
    }
}