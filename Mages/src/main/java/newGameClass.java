import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class newGameClass {
    static Logger logger = Main.logger;
    static int appWidth = Main.appWidth;
    static int appHeight = Main.appHeight;
    static Dimension dimension = Main.dimension;

    static JFrame getNewGameWindow(){
        logger.info("Инициализирован класс getNewGameWindow - создание фрейма начальных настроек игры");
        JFrame newGameWindow = new JFrame();
        newGameWindow.setVisible(false);
        newGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Выставляем размер игрового окна
        newGameWindow.setBounds(dimension.width/2 - appWidth/2, dimension.height/2 - appHeight/2, appWidth, appHeight);
        return newGameWindow;
    }
}
