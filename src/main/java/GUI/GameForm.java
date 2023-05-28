/*
 * Created by JFormDesigner on Sun May 28 01:36:53 CST 2023
 */

package GUI;

import java.awt.event.*;

import Map.GMap;
import Map.IMap;
import Map.MyPairs;
import Timer.Timer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class GameForm extends JFrame {
    public static IMap m;
    private MyThread thread;

    private class MyThread extends Thread {
        public volatile boolean Stop;//作为标志位来作为线程进行的条件。

        @Override
        public void run() {
            // 网格变化的代码
            while (!Stop) {
                m.CellUpdate();
                m.Update();
                Change();
                try {
                    Thread.sleep(Timer.getDeltaTime());
                } catch (InterruptedException e) {
                    thread.interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public GameForm() {
        thread = new MyThread();
        thread.Stop = false;
        initComponents();

        this.setSize(24 * m.getSize(), 32 * m.getSize());
    }

    private void start(ActionEvent e) {
        // TODO add your code here
        if (!thread.isAlive()) {
            Thread.interrupted();
            thread = new MyThread();
            thread.Stop = false;
            thread.start();
        } else {
            thread.Stop = true;
        }
    }

    private void RandomSet(ActionEvent e) {
        // TODO add your code here
        m.RandomSet();
        Change();
    }

    private void Change() {
        SwingUtilities.invokeLater(() -> {
            JPanel[][] panels = new JPanel[m.getSize()][m.getSize()];
            contentPanel.removeAll();
            contentPanel.setLayout(new GridLayout(m.getSize(), m.getSize()));
            for (int i = 0; i < m.getSize(); i++) {
                for (int j = 0; j < m.getSize(); j++) {
                    panels[i][j] = new JPanel();
                    panels[i][j].setBackground(GMap.game_map[i][j] ? Color.black : Color.white);
                    int finalI = i;
                    int finalJ = j;
                    panels[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (!GMap.game_map[finalI][finalJ])
                                GMap.aliveList.add(new MyPairs(finalI, finalJ));
                            else
                                GMap.aliveList.remove(new MyPairs(finalI, finalJ));
                            GMap.game_map[finalI][finalJ] = !GMap.game_map[finalI][finalJ];
                            panels[finalI][finalJ].setBackground(GMap.game_map[finalI][finalJ] ? Color.black : Color.white);
                        }
                    });
                    contentPanel.add(panels[i][j]);
                }
            }
            contentPanel.revalidate();
            contentPanel.repaint();
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();
        button1 = new JButton();
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
                contentPanel.setLayout(new GridLayout());
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{263, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0};

                //---- button1 ----
                button1.setText("\u968f\u673a\u751f\u6210");
                button1.addActionListener(e -> RandomSet(e));
                buttonBar.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u5f00\u59cb/\u6682\u505c");
                okButton.addActionListener(e -> start(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        contentPanel.setLayout(new GridLayout(m.getSize(), m.getSize()));
        // 创建二维数组的JPanel
        JPanel[][] panels = new JPanel[m.getSize()][m.getSize()];
        for (int i = 0; i < m.getSize(); i++) {
            for (int j = 0; j < m.getSize(); j++) {
                panels[i][j] = new JPanel();
                // 设置初始颜色
                panels[i][j].setBackground(GMap.game_map[i][j] ? Color.black : Color.white);
                // 添加点击事件，用于改变颜色
                int finalI = i;
                int finalJ = j;
                panels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (!GMap.game_map[finalI][finalJ])
                            GMap.aliveList.add(new MyPairs(finalI, finalJ));
                        else
                            GMap.aliveList.remove(new MyPairs(finalI, finalJ));
                        GMap.game_map[finalI][finalJ] = !GMap.game_map[finalI][finalJ];
                        panels[finalI][finalJ].setBackground(GMap.game_map[finalI][finalJ] ? Color.black : Color.white);
                    }
                });
                contentPanel.add(panels[i][j]);
            }
        }

        // 显示界面
        pack();

        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel buttonBar;
    private JButton button1;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
