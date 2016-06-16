package dataviewer;

import java.awt.Dimension;
import javax.swing.*;

/**
 * Creates a generic text field with a label to the left of it
 * @author Nicolas
 */
public class LabeledDataField extends JPanel{
    
    private final JTextArea dataField;
    /**
     * Constructor
     * @param title label to data field
     */
    public LabeledDataField(String title){
        dataField = new JTextArea(10,10);
        this.add(new JLabel(title));
        this.add(dataField);
        this.setMaximumSize(new Dimension(this.getMaximumSize().width, this.getPreferredSize().height));
    }
    
    public void put(String data){
        this.dataField.setText(data);
    }
    
    public String get(){
        return this.dataField.getText();
    }
}
