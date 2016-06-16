/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataviewer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Nicolas
 */
public class DataViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel masterPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JLabel inputPanelText = new JLabel("Input Value");
        JTextArea inputText = new JTextArea(10, 10);
        String[] dataTypes = new String[]{"byte","short","int","long","float","double","boolean"};
        final JComboBox dataTypeBox = new JComboBox(dataTypes);
        JPanel outputPanel = new JPanel();
        final LabeledDataField asciiOutput = new LabeledDataField("asciiOutput");
        final LabeledDataField hexOutput = new LabeledDataField("hexOutput");
        final LabeledDataField decOutput = new LabeledDataField("decOutput");
        final LabeledDataField binOutput = new LabeledDataField("binOutput");
        
        inputText.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    String asciiText = asciiOutput.get();
                    String hexText = hexOutput.get();
                    String decText = decOutput.get();
                    String binText = binOutput.get();
                    Scanner scanner = new Scanner(e.getDocument().getText(0, e.getDocument().getLength()));
                    switch(dataTypeBox.getSelectedIndex()){
                        case 0:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextByte()){
                                byte b = scanner.nextByte();
                                asciiText += (b + " \n");
                                hexText += (Integer.toHexString((b)) + " \n");
                                decText += (b + " \n");
                                binText += (Integer.toBinaryString(b) + " \n");
                            }
                        break;
                        case 1:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextShort()){
                                short b = scanner.nextShort();
                                asciiText += (b + " \n");
                                hexText += (Integer.toHexString((b)) + " \n");
                                decText += (b + " \n");
                                binText += (Integer.toBinaryString(b) + " \n");
                            }
                        break;
                        case 2:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextInt()){
                                int b = scanner.nextInt();
                                asciiText += (b + " \n");
                                hexText += (Integer.toHexString((b)) + " \n");
                                decText += (b + " \n");
                                binText += (Integer.toBinaryString(b) + " \n");
                            }
                        break;
                        case 3:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextLong()){
                                long b = scanner.nextLong();
                                asciiText += (b + " \n");
                                hexText += (Long.toHexString((b)) + " \n");
                                decText += (b + " \n");
                                binText += (Long.toBinaryString(b) + " \n");
                            }
                        break;
                        case 4:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextFloat()){
                                float b = scanner.nextFloat();
                                asciiText += (b + " \n");
                                hexText += (Integer.toHexString(Float.floatToRawIntBits(b)) + " \n");
                                decText += (Float.floatToRawIntBits(b) + " \n");
                                binText += (Integer.toBinaryString(Float.floatToRawIntBits(b)) + " \n");
                            }
                        break;
                        case 5:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextDouble()){
                                double b = scanner.nextDouble();
                                asciiText += (b + " \n");
                                hexText += (Long.toHexString(Double.doubleToRawLongBits(b)) + " \n");
                                decText += (Double.doubleToRawLongBits(b) + " \n");
                                binText += (Long.toBinaryString(Double.doubleToRawLongBits(b)) + " \n");
                            }
                        break;
                        case 6:
                            asciiText = "";
                            hexText = "";
                            decText = "";
                            binText = "";
                            while(scanner.hasNextBoolean()){
                                int b = scanner.nextBoolean() ? 1 : 0;
                                asciiText += (b + " \n");
                                hexText += (Integer.toHexString((b)) + " \n");
                                decText += (b + " \n");
                                binText += (Integer.toBinaryString(b) + " \n");
                            }
                        break;
                    }
                    asciiOutput.put(asciiText);
                    hexOutput.put(hexText);
                    decOutput.put(decText);
                    binOutput.put(binText);
                }catch(Exception ex){
                    System.err.println(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        masterPanel.add(inputPanel, BorderLayout.WEST);
        masterPanel.add(outputPanel, BorderLayout.EAST);
        
        inputPanel.setPreferredSize(new Dimension(200, 200));
        inputPanel.add(inputPanelText);
        inputPanel.add(dataTypeBox);
        inputPanel.add(inputText);
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        outputPanel.add(asciiOutput);
        outputPanel.add(hexOutput);
        outputPanel.add(decOutput);
        outputPanel.add(binOutput);
        outputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        frame.add(masterPanel);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    
}
