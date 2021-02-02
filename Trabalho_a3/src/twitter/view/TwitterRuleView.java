/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import twitter.controller.Gerenciador;
import twitter.observer.Observer;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class TwitterRuleView extends JFrame implements Observer, ActionListener {
    
    //JLabel
    private JLabel jlImage, jlValue, jlTag, jlValueSample, jlTagSample;
    //JTextField
    private JTextField jtfValue, jtfTag;
    //JButton
    private JButton jbSend, jbBack;
    //Layout
    private GridBagConstraints constraints;
    private GridBagLayout layout;
    private JPanel jpPrincipal;
    //Referencia do Gerenciador
    private Gerenciador gerenciador;
    
    public TwitterRuleView(){
        
        //Chama o singleton do Gerenciador.java
        gerenciador = Gerenciador.Gerenciador();
        //Se adiciona como observador no gerenciador
        gerenciador.addObservador(this);
        
        initComponents();
        
        //Configura a view
        setTitle("TwitterRules");
        setBounds(200, 200, 400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    //Inicia os componentes da tela e os ajusta corretamente
    private void initComponents(){
        //JLabels
        jlImage = new JLabel("TwitterJersey AV");
        jlValue = new JLabel("Regra: ");
        jlTag= new JLabel("Tag: ");
        jlValueSample = new JLabel("Ex.: Memes");
        jlTagSample = new JLabel("Cachorro");
        
        ImageIcon iconLogo = new ImageIcon("Images/twitter.png");
        Image newImage = iconLogo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        iconLogo.setImage(newImage);
        jlImage.setIcon(iconLogo);
        
        //JLabels/Layout
        jlImage.setForeground(Color.white);
        jlValue.setForeground(Color.white);
        jlTag.setForeground(Color.white);
        jlValueSample.setForeground(Color.white);
        jlTagSample.setForeground(Color.white);
        
        //JTextFields
        jtfValue = new JTextField();
        jtfTag = new JTextField();
        
        //JTextFields/Layout
        jtfValue.setPreferredSize( new Dimension( 200, 24 ) ); 
        jtfTag.setPreferredSize( new Dimension( 200, 24 ) ); 
        
        //JButtons
        jbSend = new JButton();
        jbSend.setText("CADASTRAR");
        jbBack = new JButton();
        jbBack.setText("VOLTAR");
        
        //JButtons/Layout
        jbSend.setBackground(new Color(0,185,255));
        jbSend.setForeground(Color.white);
        jbBack.setBackground(new Color(0,185,255));
        jbBack.setForeground(Color.white);
        
        //JButtons/Acao
        jbSend.addActionListener(this);
        jbBack.addActionListener(this);
        
        //Inicia os componentes de layout
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        jpPrincipal = new JPanel();
        jpPrincipal.setLayout(layout);
        jpPrincipal.setBackground(new Color(0, 172, 238));
        
        //Adiciona os componentes no painel
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        jpPrincipal.add(jlImage,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 5, 5);
        jpPrincipal.add(jlValue,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        jpPrincipal.add(jtfValue,constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        jpPrincipal.add(jlValueSample,constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        jpPrincipal.add(jlTag,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        jpPrincipal.add(jtfTag,constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        jpPrincipal.add(jlTagSample,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        jpPrincipal.add(jbSend,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 5;
        jpPrincipal.add(jbBack,constraints);
        
        setLayout(new BorderLayout());
        add(jpPrincipal,BorderLayout.CENTER);     
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbSend) {
            gerenciador.criarRule(jtfValue.getText(),jtfTag.getText());
        }
        if (e.getSource() == jbBack) {
                try {
                    TwitterView view = new TwitterView();
                    view.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    @Override
    public void qntTweetsInvalido() {
        JOptionPane.showMessageDialog(rootPane, "Por favor, digite um valor entre 5 e 100","Aviso", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void AchouUsuario(boolean b) {
        if(!b){
            JOptionPane.showMessageDialog(rootPane, "Usuário não encontrado","Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void AchouTweets(boolean b) {
        if(b){
           try {
            TweetsView view = new TweetsView("Tweets");
            view.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        }else{
            JOptionPane.showMessageDialog(rootPane, "Não foram encontrados tweets deste usuário","Aviso", JOptionPane.WARNING_MESSAGE);
        }     
    }

    @Override
    public void regraAdicionada(boolean b) {
        if (b) {
            JOptionPane.showMessageDialog(rootPane, "Regra cadastrada com sucesso!","Parabéns",JOptionPane.INFORMATION_MESSAGE);
            try {
                TweetsRulesView view = new TweetsRulesView("Rules");
                view.setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Valores inválidos, verifique os campos requeridos","Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
}
