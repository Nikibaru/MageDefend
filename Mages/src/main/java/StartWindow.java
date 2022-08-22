/*
Это стартовое окно. На первом этапе кроме "новая игра" и "выход" ничего нет.
В дальнейшем можно добавить "загрузка" и "настройки".
 */

import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartWindow {
    static Logger logger = Main.logger;
    static int appWidth = Main.appWidth;
    static int appHeight = Main.appHeight;
    static Dimension dimension = Main.dimension;


    // Лейбл с именем
    static class gameName extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            logger.info("Инициализирован класс gameName - создание лейбла с именем на стартовом окне");
            Graphics2D graphics2D = (Graphics2D) g;

            // Настройки шрифта
            int fontSize = 50;
            Font font = new Font("Arial",Font.BOLD,fontSize);
            graphics2D.setFont(font);

            // Настройки имени
            String name = "Битва магов";
            int namePixelLength = graphics2D.getFontMetrics().stringWidth(name);
            graphics2D.drawString(name,appWidth/2-namePixelLength/2,fontSize);

        }
    }

    // Сам фрейм стартового окна
    static JFrame getStartWindow(){
        System.out.println("INFO: Инициализирован класс getStartWindow - создание фрейма стартового окна");
        JFrame startWindow = new JFrame();
        startWindow.setVisible(true);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Выставляем размер игрового окна
        startWindow.setBounds(dimension.width/2 - appWidth/2, dimension.height/2 - appHeight/2, appWidth, appHeight);
        return startWindow;
    }


}
