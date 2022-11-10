//Ödevde belirli zorunluluk olmadığı için notepad tarzı yaptım
package guı;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import javax.swing.undo.UndoManager;



public class GUI implements ActionListener {
      //Ekranda karşımıza gelecek sayfanın başlangıç özelliklerni ekledim
      JFrame pencere;
      JTextArea yazi;
      JScrollPane scroll;
      
      JMenuBar menu;
      JMenu menuduzenle,menurenk,menuyazi;
      
      JMenuItem iKaydet,iGeri,iIleri;    
      JMenuItem iITALIC,iBOLD; 
      JMenuItem iRenk1,iRenk2,iRenk3;
      
      ozellik duzenle = new ozellik(this);
      ozellik1 yazistil =new ozellik1(this);
      ozellik2 renk = new ozellik2(this);
      
      UndoManager um = new UndoManager();
    public static void main(String[] args) {
      new GUI();
      
    }
    public GUI(){
        //Fonksiyonların tanımı ve kullanımı içindir
        olusturpencere();
        olusturyazi();
        olusturmenu();
        duzenlemenu();
        olusturyazistil();
        olusturrenk();
        yazistil.secilen="NORMAL";
        yazistil.olusturfont();
        renk.renkdegis("SİYAH");
        pencere.setVisible(true);
    }
    public void olusturpencere(){
       //Açılan penceredki boyutunu ayarladım
        pencere = new JFrame("ODEV");
        pencere.setSize(800,600);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void olusturyazi(){
       //Text areanın oluştuğu ve undo redonun özelliklerini yazıp tanımladım fonksiyon ve classlar sayesinde hepsi basit şekilde oldu
        yazi= new JTextArea();
        pencere.add(yazi);
        
        yazi.getDocument().addUndoableEditListener(
                new UndoableEditListener(){
          public void undoableEditHappened(UndoableEditEvent e){
              um.addEdit(e.getEdit());
              
          }
        });
        yazi.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()==26)
                {
                    um.undo();
                }
                if (e.getKeyChar()==25)
                {
                    um.redo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        
        
        scroll = new JScrollPane(yazi,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        pencere.add(scroll);
    
    }
   //Bundan sonraki mantık hep benzer olur Sadece özelliklerini kullanacağımız seçeneklere action eklendi
    public void olusturmenu(){
        menu = new JMenuBar();
        pencere.setJMenuBar(menu);
        
        menuduzenle = new JMenu("Duzenle");
        menu.add(menuduzenle);
        
        menuyazi = new JMenu("Yazi Stili");
        menu.add(menuyazi);
        
        
        menurenk = new JMenu("Renk");
        menu.add(menurenk);
        

        
    }
    public void duzenlemenu(){
        iKaydet = new JMenuItem("Kaydet");
        iKaydet.addActionListener(this);
        iKaydet.setActionCommand("Kaydet");
        menuduzenle.add(iKaydet);
 
        iGeri = new JMenuItem("Undo");
        iGeri.addActionListener(this);
        iGeri.setActionCommand("Undo");
        menuduzenle.add(iGeri);
        
        iIleri = new JMenuItem("Redo");
        iIleri.addActionListener(this);
        iIleri.setActionCommand("Redo");
        menuduzenle.add(iIleri);
        
    }
    public void olusturyazistil(){
        iITALIC = new JMenuItem("ITALIC");
        iITALIC.addActionListener(this);
        iITALIC.setActionCommand("ITALIC");
        menuyazi.add(iITALIC);
        
        iBOLD = new JMenuItem("BOLD");
        iBOLD.addActionListener(this);
        iBOLD.setActionCommand("BOLD");
        menuyazi.add(iBOLD);
    }
    public void olusturrenk(){
        iRenk1 = new JMenuItem("ORIGINAL");
        iRenk1.addActionListener(this);
        iRenk1.setActionCommand("ORIGINAL");
        menurenk.add(iRenk1);
        
        iRenk2 = new JMenuItem("KIRMIZI");
        iRenk2.addActionListener(this);
        iRenk2.setActionCommand("KIRMIZI");
        menurenk.add(iRenk2);

        iRenk3 = new JMenuItem("MAVI");
        iRenk3.addActionListener(this);
        iRenk3.setActionCommand("MAVI");
        menurenk.add(iRenk3);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //Seçenekleri seçerek hangisini kullanmak istediğini seçer
        switch(command){
            case "Kaydet":duzenle.Kaydet();break;
            case "Undo":duzenle.undo();break;
            case "Redo":duzenle.redo();break;
            case "ITALIC":yazistil.duzenlefont(command);break; 
            case "BOLD":yazistil.duzenlefont(command);break;
            case "ORIGINAL":renk.renkdegis(command);break;
            case "KIRMIZI":renk.renkdegis(command);break;
            case "MAVI":renk.renkdegis(command);break;
            
        }
    }
}
