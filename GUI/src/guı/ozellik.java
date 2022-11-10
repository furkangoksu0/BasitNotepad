
package guı;

import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;



public class ozellik {
    GUI gui;
    String dosyaismi;
    String dosyaadres;
    
    
    public ozellik(GUI gui){
        this.gui=gui;
    }
    public void Kaydet(){
    if(dosyaismi==null)
       farkliKaydet();
        try {
            FileWriter fw = new FileWriter(dosyaadres + dosyaismi);
            fw.write(gui.yazi.getText());
            gui.pencere.setTitle(dosyaismi);
            fw.close();
        } catch (Exception e) {
            System.out.println("Hata Olustu");
        }
        }
    public void farkliKaydet(){
        FileDialog fd = new FileDialog(gui.pencere,"Kaydet", FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null){
           dosyaismi=fd.getFile();
           dosyaadres = fd.getDirectory();
           gui.pencere.setTitle(dosyaismi);
        }
       
        try {
            FileWriter fw = new FileWriter(dosyaadres + dosyaismi);
            fw.write(gui.yazi.getText());
            fw.close();
        }catch(Exception e){
            System.out.println("Hata Olustu");
        }
        
    }
    
    public void undo(){
     
    
           gui.um.undo();
    
    }
    public void redo(){
        gui.um.redo();
 }   

}
