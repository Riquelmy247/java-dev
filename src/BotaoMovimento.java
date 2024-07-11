import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BotaoMovimento extends JFrame implements ActionListener, MouseListener {
    private JButton moveButton;
    private int buttonX, buttonY;
    private int missCount;

    public BotaoMovimento() {
        super("Jogo de botão em movimento");

        moveButton = new JButton("Click!");
        moveButton.addMouseListener(this);

        buttonX = 50;
        buttonY = 50;
        missCount = 0;

        setLayout(null);
        add(moveButton);
        moveButton.setBounds(buttonX, buttonY, 100, 30);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (mouseX < buttonX || mouseX > buttonX + 100 || mouseY < buttonY || mouseY > buttonY + 30) {
            missCount++;
            if (missCount >= 3) {
                buttonX = (int) (Math.random() * (getWidth() - 100));
                buttonY = (int) (Math.random() * (getHeight() - 30));
                moveButton.setLocation(buttonX, buttonY);
                missCount = 0;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] args) {
        new BotaoMovimento();
    }
}
