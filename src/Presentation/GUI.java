package Presentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    //metodos
    public GUI() {
        initGUI();

        this.setTitle("Mi Presentacion");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents
        title = new Title("Mi presentacion", Color.BLACK);
        myPhoto = new JButton("Este soy yo");
        myHobby = new JButton("Mis hobbys");
        myExpectations = new JButton("Mis expectativas del curso");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "Acerca de mi", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF, Font.PLAIN, 20), Color.BLACK));
        containerImage.add(imageLabel);
        //cambio
        containerImage.addKeyListener(listener);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        //myPhoto.addActionListener(listener);
        //myHobby.addActionListener(listener);
        myPhoto.addActionListener(listener);
        myHobby.addMouseListener(listener);
        myExpectations.addKeyListener(listener);
        myPhoto.addKeyListener(listener);
        myHobby.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

    private class Listener implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Press button");
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);

            if(e.getSource() == myPhoto){
                this.image = new ImageIcon(getClass().getResource("/recursos/yo.jpg"));
                imageLabel.setIcon(image);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && e.getSource() == myHobby) {
                containerImage.remove(expectativesText);
                this.image = new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                imageLabel.setIcon(image);
            }
            revalidate();
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getSource());
            System.out.println(e.getKeyChar());
            if (e.getKeyCode() == KeyEvent.VK_M) {
                imageLabel.setIcon(null);
                expectativesText.setText("Espero poder expandir mis conocimientos en programacion al maximo \n" +
                        "My email es cesar.hincapie@correounivalle.edu.co");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                containerImage.add(expectativesText);


            }
            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

    }






