//just remembering how to use
import javax.swing.*;



    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            //the whole window itself
            JFrame frame = new JFrame("test frame");
            //shows text/pics/things that are not clickable
            JLabel lable = new JLabel();

            //a section in it
            JPanel panel = new JPanel();

            JButton b1 = new JButton("New Survey");

            panel.add(lable);
            panel.add(b1);

            frame.add(panel);
            frame.setSize(400,300);
            frame.setDefaultCloseOperation(

                JFrame.EXIT_ON_CLOSE

        );
        frame.setVisible(true);










    });
}




