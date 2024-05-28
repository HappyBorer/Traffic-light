import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        super("Traffic light");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setBounds(100, 80, 500, 500);
        MyPanel myPanel = new MyPanel();
        setContentPane(myPanel);
        //pack();
        setVisible(true);

    }


}
