import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlocoNotas extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public BlocoNotas() {
        setTitle("Bloco de Notas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Arquivo");
        JMenuItem newMenuItem = new JMenuItem("Novo");
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Abrir");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Salvar");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        fileChooser = new JFileChooser();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Novo":
                textArea.setText("");
                break;
            case "Abrir":
                int returnVal = fileChooser.showOpenDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileReader reader = new FileReader(file);
                        textArea.read(reader, null);
                        reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case "Salvar":
                returnVal = fileChooser.showSaveDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(file);
                        textArea.write(writer);
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
        }
    }

    public static void main(String[] args) {
        new BlocoNotas();
    }
}
