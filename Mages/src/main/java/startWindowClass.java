/*
Это стартовое окно. На первом этапе кроме "новая игра" и "выход" ничего нет.
В дальнейшем можно добавить "загрузка" и "настройки".
 */

import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startWindowClass {
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
        logger.info("Инициализирован класс getStartWindow - создание фрейма стартового окна");
        JFrame startWindow = new JFrame();
        // Настройки фрейма
        startWindow.setVisible(true);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Выставляем размер игрового окна
        startWindow.setBounds(dimension.width/2 - appWidth/2, dimension.height/2 - appHeight/2, appWidth, appHeight);

        //Добавляем на экран название и кнопки
        startWindow.setLayout(new GridLayout(2, 1, 0, 0)); // выставили сетку по окну
        startWindow.add(new startWindowClass.gameName()); // добавили название-лейбл сверху
        JPanel jPanel = new JPanel(); // панель для кнопок
        startWindow.add(jPanel); // панель для кнопок

        JButton newGameButton = new JButton("Новая игра");
        jPanel.add(newGameButton);

        JButton exitButton = new JButton("Выход");
        jPanel.add(exitButton);

        // Логика кнопки "новая игра"
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("Нажата кнопка 'Новая игра'");
                Main.currentWindow = 2;
            }
        });

        // Логика кнопки "выход"
        exitButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });


        return startWindow;
    }


}
