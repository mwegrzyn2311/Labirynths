package pl.agh.edu.dp.gui;

import pl.agh.edu.dp.gui.Game;
import pl.agh.edu.dp.gui.LevelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel {

    public GameOverScreen(Game game) {
        this.setLayout(new GridLayout(3,1));
        this.setPreferredSize(new Dimension(16*50, 10*50));
        addLabel("Congratulations!");
        addLabel("You've died");
        this.setBackground(new Color(86,86,86));
        JButton reset = new JButton("Reset level");
        reset.setFont(new Font("ROBOTO", Font.BOLD, 42));
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.startLevel();
            }
        });
        reset.setBorder(BorderFactory.createLineBorder(new Color(255, 190,0), 3));
        this.add(reset);
    }

    public void addLabel(String text) {
        JLabel txt = new JLabel(text, SwingConstants.CENTER);
        txt.setFont(new Font("ROBOTO", Font.BOLD, 42));
        txt.setForeground(new Color(255,255,255));
        this.add(txt);
    }
}