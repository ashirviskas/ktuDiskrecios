/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eile;

/* TextDemo.java requires no other files. */
 
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.*;
 
public class TextDemo extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextField textFVienliciu;
    protected JTextField textFDviliciu;
    protected JTextArea textArea;
    protected JTextArea textAVienliciu;
    protected JTextArea textADviliciu;
    protected JButton calculate;
    
    private final static String newline = "\n";
    long sprendimu = 0;
    public TextDemo() {
        super(new GridBagLayout());
        textFVienliciu = new JTextField(20);
        textFDviliciu = new JTextField(20);
        //textField = new JTextField(200);
        textFDviliciu.addActionListener(this);
        //Descriptions
        textAVienliciu = new JTextArea(1, 10); //Displays description for Vienliciai
        textADviliciu = new JTextArea(1, 10); //same /\
        textArea = new JTextArea(50, 10);
        textArea.setEditable(false);
        textAVienliciu.setEditable(false);
        textADviliciu.setEditable(false);
        calculate = new JButton("Skaičiuoti");
        calculate.addActionListener(this);
        calculate.setMnemonic(KeyEvent.VK_C);
        //calculate.setActionCommand();
        
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        JScrollPane scrollPaneV = new JScrollPane(textAVienliciu);
        JScrollPane scrollPaneD = new JScrollPane(textADviliciu);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        add(scrollPaneV, c);
        add(textFVienliciu, c);
        // c.fill = GridBagConstraints.HORIZONTAL;
        add(scrollPaneD, c);
        add(textFDviliciu, c);
        //c.fill = GridBagConstraints.HORIZONTAL;
        //add(textField, c);
        add(calculate, c);
        //c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        textAVienliciu.setText("Įveskite, kiek klientų yra vienličių: ");
        textADviliciu.setText("Įveskite, kiek klientų yra dviličių (<vienličių): ");
        
        
        
    }
 
    public void actionPerformed(ActionEvent evt) {
        textArea.setText("");
        sprendimu = 0;
        //String text = textField.getText();
        //textArea.append(text + newline);
        int eile[];
        int vienliciu = Integer.parseInt(textFVienliciu.getText());
        int dviliciu = Integer.parseInt(textFDviliciu.getText());
        eile = new int[vienliciu+dviliciu];
        eile(vienliciu,dviliciu,0,eile,0, evt);
        textArea.append("Sprendimų: "+sprendimu);

        //textField.selectAll();
        

        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
  
 

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add contents to the window.
        frame.add(new TextDemo());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
 
    public void eile(int vienliciai, int dviliciai, int kasojvienlitu, int eile[], int esamas, ActionEvent evt )
    {
        if (vienliciai+dviliciai==0)
        {
            textArea.append("Sprendimas: "+ ++sprendimu + " "+ Arrays.toString(eile) + newline);
            sprendimu++;
            return;
        }
        if (((vienliciai+kasojvienlitu) < dviliciai))
        {
            return;
        }
        if (vienliciai > 0){
            int naujaeile[] = eile;
            naujaeile[esamas]=1;
            eile(vienliciai-1, dviliciai, kasojvienlitu+1, eile, esamas+1, evt);
        }
        if (kasojvienlitu>0&&dviliciai>0)
        {
            int naujaeile[] = eile;
            naujaeile[esamas]=2;
            eile(vienliciai, dviliciai-1, kasojvienlitu-1, eile, esamas+1, evt);
        }
        else{
            return;
        }
        return;
        }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //int eile[] = {0, 0, 0, 0, 0};
        //new Eile().eile(3,2,0,eile,0);
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}
