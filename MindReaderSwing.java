import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.Timer;

public class MindReaderSwing extends JFrame {

    private JLabel label;
    private JProgressBar progressBar;
    private String[] messages = {"Analyzing", "Processing", "Reading your mind", "Almost there!"};

    public MindReaderSwing() {
        setTitle("Mind Reader 3000");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        label = new JLabel("Think of a number between 1 and 10", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label, BorderLayout.NORTH);

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        //color for the progress bar
        progressBar.setForeground(new Color(102, 205, 170));  // Cool turquoise
        add(progressBar, BorderLayout.CENTER);

        JButton button = new JButton("Reveal My Number");
        //colors for the button
        button.setBackground(new Color(70, 130, 180));  // Cool steel blue
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> startAnimation());
        add(button, BorderLayout.SOUTH);
    }

    private void startAnimation() {
        new Thread(() -> {
            Random random = new Random();

            // Smaller input dialog
            UIManager.put("OptionPane.minimumSize", new Dimension(200, 100));
            int userNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number you're thinking of (1-10):"));

            //animation and color changes
            for (int i = 0; i < 4; i++) {
                label.setText(messages[i]);
                animateProgressBar(30);
                changeLabelColor();
            }

            try {
                label.setText("Hmmm... Let me think...");
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            //countdown
            for (int i = 3; i > 0; i--) {
                label.setText(i + "...");
                label.setForeground(new Color(255, random.nextInt(256), random.nextInt(256))); // Random colors
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            label.setText("It's " + userNumber + "!!! 🎉🎉🎉");

            // Start a timer for 5 seconds before showing the final message
            new Timer(5000, e -> {
                JOptionPane.showMessageDialog(this, "Wow! I'm really good at this mind-reading thing!");
            }).start();

        }).start();
    }

    private void animateProgressBar(int speed) {
        try {
            for (int j = 0; j <= 100; j += 10) {
                progressBar.setValue(j);
                progressBar.setForeground(new Color(102, 205, 170 - j));  // Dynamic color changes
                Thread.sleep(speed);
            }
            for (int j = 100; j >= 0; j -= 10) {
                progressBar.setValue(j);
                progressBar.setForeground(new Color(102, 205, 170 - j));  // Dynamic color changes
                Thread.sleep(speed);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    private void changeLabelColor() {
        new Thread(() -> {
            try {
                for (int i = 0; i < 255; i += 15) {
                    label.setForeground(new Color(i, 255 - i, 255));
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MindReaderSwing frame = new MindReaderSwing();
            frame.setVisible(true);
        });
    }
}
 