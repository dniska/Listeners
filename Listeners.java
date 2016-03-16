package listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *  This class will give you practice writing GUI components and listeners.
 * @author Daniel Niska
 */
public class Listeners {
    
    public Listeners() {
        JFrame frame = new JFrame("Listeners Lab");
        frame.setPreferredSize(new Dimension(450, 150));
        frame.setLayout(new FlowLayout());
        
        // Stop/Go button here
        final JButton button = new JButton();
        button.setPreferredSize(new Dimension(100, 50));       
        Font font = new Font("Sans Serif", Font.BOLD, 20);        
        button.setFont(font);
        button.setBackground(Color.red); 

        button.setText("Stop");
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Stop")) {
                        button.setText("Go");
                        button.setBackground(Color.GREEN);
                }
                else {
                    button.setText("Stop");
                    button.setBackground(Color.RED);
                }
            }
        });
        frame.add(button);
        
        
        // Slider and label here
        final JSlider slider = new JSlider();
        slider.setMaximum(100);
        slider.setMinimum(0);
        frame.add(slider);
        
        final JLabel label = new JLabel();
        int initialValue = slider.getValue();
        label.setText(String.valueOf(initialValue));
        label.setPreferredSize(new Dimension(60, 50));
        label.setFont(font);
        label.setForeground(Color.blue);
        TitledBorder border = new TitledBorder("Value");
        label.setBorder(border);

        
        slider.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slider.getValue();
                label.setText(String.valueOf(currentValue));
            }
        
        });
        frame.add(label);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments -- not used
     */
    public static void main(String[] args) {
        new Listeners();
    }
}
