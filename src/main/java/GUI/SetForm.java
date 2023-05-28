/*
 * Created by JFormDesigner on Sun May 28 01:34:26 CST 2023
 */

package GUI;

import Map.GMap;
import Timer.Timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class SetForm extends JFrame {
    public SetForm() {
        initComponents();
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        GameForm.m = new GMap();
        GameForm.m.setSize(Integer.parseInt(textField1.getText()));
        GameForm.m.Init();
        if (checkBox1.isSelected())
            GameForm.m.RandomSet();
        Timer.setDeltaTime(Integer.parseInt(textField2.getText()));
        GameForm gameForm = new GameForm();
        gameForm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u7f51\u683c\u5927\u5c0f:");
                contentPanel.add(label1);
                label1.setBounds(5, 20, 90, label1.getPreferredSize().height);

                //---- checkBox1 ----
                checkBox1.setText("\u968f\u673a\u751f\u6210\u751f\u547d");
                contentPanel.add(checkBox1);
                checkBox1.setBounds(10, 70, 180, checkBox1.getPreferredSize().height);

                //---- textField1 ----
                textField1.setText("15");
                contentPanel.add(textField1);
                textField1.setBounds(85, 15, 85, textField1.getPreferredSize().height);

                //---- label2 ----
                label2.setText("\u95f4\u9694ms:");
                contentPanel.add(label2);
                label2.setBounds(195, 20, 75, label2.getPreferredSize().height);

                //---- textField2 ----
                textField2.setText("1000");
                contentPanel.add(textField2);
                textField2.setBounds(285, 15, 75, textField2.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0};

                //---- okButton ----
                okButton.setText("\u5f00\u59cb\u751f\u6210");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JCheckBox checkBox1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
