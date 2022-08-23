import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PregameSettings {

    private String playersNumber;
    private String hexNumber;
    JTextField playersNumberField = new JTextField(1);
    JTextField hexesNumberField = new JTextField(1);

    public PregameSettings(){

    }
    public void setPregamePane(JFrame currentWindow){
        currentWindow.getContentPane().removeAll();
        currentWindow.repaint();

        JPanel panel = new JPanel();
        panel.setSize(100,200);
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        boxLayout.maximumLayoutSize(panel);

        Button startGameBtn = new Button("STARTUEM");
        startGameBtn.addActionListener(new StartGameButtonListener(currentWindow));


        panel.setLayout(boxLayout);
        panel.add(startGameBtn);
        panel.add(playersNumberField);
        panel.add(hexesNumberField);

        currentWindow.add(panel);
        currentWindow.setVisible(true);

    }

    public String getPlayersNumber(){
        return playersNumber;
    }
    public String getHexNumber(){
        return hexNumber;
    }

    class StartGameButtonListener implements ActionListener{
        JFrame currentWindow;
        public StartGameButtonListener(JFrame currentWindow){
            this.currentWindow = currentWindow;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            playersNumber = playersNumberField.getText();
            hexNumber = hexesNumberField.getText();
            currentWindow.getContentPane().removeAll();
            currentWindow.repaint();
        }
    }



}
