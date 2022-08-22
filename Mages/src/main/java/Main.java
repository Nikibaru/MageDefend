import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Main {
    // Для логирования (в консоль и в файл)
    public static final Logger logger = LogManager.getLogger();

    // Для получения размеров экрана
    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
    public static Dimension dimension = toolkit.getScreenSize();

    // Глобальный размер приложения
    public static int appWidth = (int) (dimension.width * 0.8) ;
    public static int appHeight = (int) (dimension.height * 0.8) ;


    // Размер ячейки по Х, по Y; Количество ячеек по X, по Y
    public int[] cell_structure = {100,100,10,10};

    public static void main(String[] args) {
        logger.info("Размеры экрана " + dimension.width + "x" + dimension.height);
        logger.info("Размеры приложения " + appWidth + "x" + appHeight);
        JFrame startWindow = StartWindow.getStartWindow();
        JFrame newGameWindow = newGameClass.getNewGameWindow();

        // Стартовое окно
        startWindow.add(new StartWindow.gameName());
        JPanel jpanel = new JPanel();
        startWindow.add(jpanel);
        JButton newGameButton = new JButton("Новая игра");
        jpanel.add(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("INFO: Нажата кнопка 'Новая игра'");
                newGameWindow.setVisible(true);
                startWindow.setVisible(false);
            }
        });

        // Окно настроек новой игры


    }
}