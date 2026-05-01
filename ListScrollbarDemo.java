import java.awt.*;
import java.awt.event.*;

public class ListScrollbarDemo extends Frame implements ItemListener, AdjustmentListener {

    List list;
    Scrollbar sb;
    Label l;

    ListScrollbarDemo() {
        // Create List
        list = new List(4); // 4 visible items
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");
        list.add("HTML");

        list.setBounds(50, 50, 100, 80);

        // Create Scrollbar
        sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 100);
        sb.setBounds(50, 150, 200, 20);

        // Create Label
        l = new Label("Select item or move scrollbar");
        l.setBounds(50, 200, 250, 30);

        // Add listeners
        list.addItemListener(this);
        sb.addAdjustmentListener(this);

        // Add components
        add(list);
        add(sb);
        add(l);

        // Frame settings
        setSize(300, 300);
        setLayout(null);
        setVisible(true);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // List event
    public void itemStateChanged(ItemEvent e) {
        l.setText("Selected: " + list.getSelectedItem());
    }

    // Scrollbar event
    public void adjustmentValueChanged(AdjustmentEvent e) {
        l.setText("Scrollbar value: " + sb.getValue());
    }

    public static void main(String[] args) {
        new ListScrollbarDemo();
    }
}