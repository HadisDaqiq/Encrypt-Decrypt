import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Component;

 
  
public class EncryptDecrypts{
     
    /** Creating a new instance */
    public EncryptDecrypts() {
    }
     
    public static void main(String [] rr){
        DesPanel  mainM = new DesPanel();
        mainM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainM.setVisible(true);
    }
}
class DesPanel extends JFrame{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public DesPanel(){
        this.setTitle("EncryptAndDecrypt");
        
        this.setSize(600,600);
       // setBackground(Color.green);
        this.setVisible(true);
        
  
   ButtonGroup group=new ButtonGroup();
   	group.add(Subtn);
    group.add(Tranbtn);
    group.add(Probtn);
    
    this.setVisible(true);     
        GenerateGUI();
    }
    User panel;
    public static JTextArea Text = new JTextArea(5,20);
    private    Container container=this.getContentPane();
    private    JButton btnEncrypt = new JButton("Encrypt");
    private    JButton btnDecrypt = new JButton("Decrypt");
    private   JTextArea DecryptText = new JTextArea(2,20);
    private   JTextArea EncryptText = new JTextArea(2,20);
    private   JTextArea EnterText = new JTextArea(4,40);
    JRadioButton Subtn=new JRadioButton("Substitution");
    JRadioButton Probtn=new JRadioButton("Product");
    JRadioButton Tranbtn=new JRadioButton("Transposition");
    
    
   
   
    
   
    
    private    JScrollPane EnterTextScorl=new JScrollPane(EnterText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private  JScrollPane DecryptScorl=new JScrollPane(DecryptText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private   JScrollPane StepScorl=new JScrollPane(Text,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private    JScrollPane EncryptScorl=new JScrollPane(EncryptText,
    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    private  JTextField Key = new JTextField(16);
    private  JPanel PanelKey = new JPanel();
    private  JPanel PanelEncrypt = new JPanel();
    private  JPanel PanelDecrypt = new JPanel();
    private  JPanel PanelEntertxt = new JPanel();
    private JPanel jp1=new JPanel();
    private  JLabel Key1= new JLabel("Key: ");
    
    
    private JPanel SubPanel=new JPanel();
    private JPanel TranPanel=new JPanel();
    private JPanel ProPanel=new JPanel();
   
    
    
    private void GenerateGUI(){
    	container.setLayout(new GridLayout(4,1));
    	container.setLayout(new FlowLayout());
        PanelKey.setLayout(new FlowLayout());
        PanelKey.add(Key1);
        PanelKey.add(Key);
        
       PanelEncrypt.setBorder(BorderFactory.createTitledBorder(" "));
        SubPanel.setLayout(new FlowLayout());
        TranPanel.setLayout(new FlowLayout());
        ProPanel.setLayout(new FlowLayout());
        SubPanel.add(Subtn);
        TranPanel.add(Tranbtn);
        ProPanel.add(Probtn);
         
        PanelEntertxt.setBorder(BorderFactory.createTitledBorder("Enter Text"));
        PanelEntertxt.setLayout(new FlowLayout());
        PanelEntertxt.add(EnterTextScorl);
      
        PanelDecrypt.setBorder(BorderFactory.createTitledBorder("Decrypt Text"));
        PanelDecrypt.setLayout(new FlowLayout());
        PanelDecrypt.add(DecryptScorl);
        PanelDecrypt.add(btnDecrypt);
        PanelEncrypt.setBorder(BorderFactory.createTitledBorder("Encrypt Text"));
        PanelEncrypt.setLayout(new FlowLayout());
        PanelEncrypt.add(EncryptScorl);
        PanelEncrypt.add(btnEncrypt);
       
        jp1.setBorder(BorderFactory.createTitledBorder("Result"));
        jp1.setLayout(new FlowLayout());
        jp1.add(StepScorl);
         
        container.add(PanelKey);
        container.add(PanelEncrypt);
        container.add(PanelDecrypt);
        container.add(PanelEntertxt);
        container.add(SubPanel);
        container.add(TranPanel);
        container.add(ProPanel);
        container.add(jp1);
        DoActions(); 
    }
    private void DoActions(){
        ActionHandler action = new ActionHandler();
        /**adding Actionlistener to Encrypt&Decrypt btn in order make the buttons
         * perform an action while the btns are pressed* 
         */
        btnEncrypt.addActionListener(action);
        btnDecrypt.addActionListener(action);
        Subtn.addActionListener(action);
    }
     
    private class ActionHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	/**The following "IF" Statement determines if the button is pressed then it should 
        	 * get the text from "EnterText" Jtext field.
        	 */
            if(e.getSource()==btnEncrypt){
                String firsttext=EnterText.getText();
                String keyW=Key.getText();//keywordD=keyW
                Text.append("Orginal Text : "+firsttext+'\n');
                Text.append("key : "+keyW+'\n');
                /**this takes the text from original textfield to Encrypt panel and to EncryptPanel text area.
                 *  The rule applies with the Encrypt btn*/
                panel= new User(keyW,firsttext);
                panel.Encrypt();
                panel.FillCharacMatrix();
                EncryptText.append(panel.getEncrypt());
                
                
            }
            
           // if(e.getSource()==Subtn)
            {
              
                
            
            
            	
            
            if(e.getSource()==btnDecrypt){
               panel.Decrypt();
                DecryptText.append("\n"+panel.getDecrypt());
            }
          //  if(e.getSource()==Subtn){
            //	panel.Subtit();
            //	EncryptText.append(panel.getEncrypt());
          //  }
            
                
        }
         
    }
    private String fina;


}
 
class DocumentSizeFilter extends DocumentFilter {
    int maxCharacters;
     
    public DocumentSizeFilter(int maxChars) {
        maxCharacters = maxChars;
    }
     
    
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
 
throws BadLocationException {
         
        if ((fb.getDocument().getLength() + str.length()) <= maxCharacters)
            super.insertString(fb, offs, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
     
    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
 
throws BadLocationException {
         
        if ((fb.getDocument().getLength() + str.length()- length) <= maxCharacters)
            super.replace(fb, offs, length, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
     
}}
