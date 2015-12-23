package guiPlayer;

import java.awt.event.InputEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import objects.MP3;
import objects.MP3Player;
import utils.FileUtils;
import utils.SkinUtils;
import utils.Mp3FileFilter;

public class PlayerJFrame extends javax.swing.JFrame {

    private static final String MP3_FILE_EXTENSION = "mp3";
    private static final String MP3_FILE_DESCRIPTION = "mp3 files";
    private static final String PLAYLIST_EXTENSION = "pls";
    private static final String PLAYLIST_DESCRIPTION = "playlist files";
    private static final String EMPTY_STRING = "";
    private static final String INPUT_SONG_NAME = "";

    private DefaultListModel mp3ListModel = new DefaultListModel();
    private FileFilter mp3Filter = new Mp3FileFilter(MP3_FILE_EXTENSION, MP3_FILE_DESCRIPTION);
    private FileFilter playlistFilter = new Mp3FileFilter(PLAYLIST_EXTENSION, PLAYLIST_DESCRIPTION);
    private MP3Player player = new MP3Player();
    private int currentVolumeValue;

    /**
     * Creates new form playerJFrame
     */
    public PlayerJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPanelSearch = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jScrollPanePlaylist = new javax.swing.JScrollPane();
        jListPlaylist = new javax.swing.JList<>();
        jSliderVolume = new javax.swing.JSlider();
        jButtonPrevious = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jToggleButtonMute = new javax.swing.JToggleButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonSelectNext = new javax.swing.JButton();
        jButtonSelectPrevious = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jMenuSkin = new javax.swing.JMenu();
        jMenuItemClassic = new javax.swing.JMenuItem();
        jMenuItemNimbus = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.setMultiSelectionEnabled(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java MP3 Player");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);

        jTextFieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldSearch.addFocusListener(formListener);
        jTextFieldSearch.addActionListener(formListener);

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_search_flies.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.setToolTipText("Find Music By Keyword");
        jButtonSearch.setName(""); // NOI18N
        jButtonSearch.addActionListener(formListener);

        javax.swing.GroupLayout jPanelSearchLayout = new javax.swing.GroupLayout(jPanelSearch);
        jPanelSearch.setLayout(jPanelSearchLayout);
        jPanelSearchLayout.setHorizontalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSearchLayout.setVerticalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addContainerGap())
        );

        jListPlaylist.setModel(mp3ListModel);
        jListPlaylist.addMouseListener(formListener);
        jScrollPanePlaylist.setViewportView(jListPlaylist);

        jSliderVolume.setMaximum(200);
        jSliderVolume.setMinorTickSpacing(5);
        jSliderVolume.setSnapToTicks(true);
        jSliderVolume.setToolTipText("Volume");
        jSliderVolume.setValue(100);
        jSliderVolume.addChangeListener(formListener);
        jSliderVolume.addMouseWheelListener(formListener);

        jButtonPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_rwnd.png"))); // NOI18N
        jButtonPrevious.addActionListener(formListener);

        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_play.png"))); // NOI18N
        jButtonPlay.addActionListener(formListener);

        jButtonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_pause.png"))); // NOI18N
        jButtonPause.addActionListener(formListener);

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_stop.png"))); // NOI18N
        jButtonStop.addActionListener(formListener);

        jButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_fwrd.png"))); // NOI18N
        jButtonNext.addActionListener(formListener);

        jToggleButtonMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_sound_loud.png"))); // NOI18N
        jToggleButtonMute.setToolTipText("");
        jToggleButtonMute.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_sound_mute.png"))); // NOI18N
        jToggleButtonMute.addActionListener(formListener);

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_plus.png"))); // NOI18N
        jButtonAdd.addActionListener(formListener);

        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_minus.png"))); // NOI18N
        jButtonRemove.addActionListener(formListener);

        jButtonSelectNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_arrow_down.png"))); // NOI18N
        jButtonSelectNext.addActionListener(formListener);

        jButtonSelectPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_arrow_up.png"))); // NOI18N
        jButtonSelectPrevious.addActionListener(formListener);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jToggleButtonMute, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jButtonPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonStop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNext)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanePlaylist)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSelectNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelectPrevious)))
                        .addContainerGap())))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonSelectNext)
                    .addComponent(jButtonSelectPrevious))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jSliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButtonMute, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrevious)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonPause)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonNext))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuFile.setText("File");

        jMenuItemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_eject.png"))); // NOI18N
        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(formListener);
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_save_disk.png"))); // NOI18N
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(formListener);
        jMenuFile.add(jMenuItemSave);
        jMenuFile.add(jSeparator1);

        jMenuItemClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_power.png"))); // NOI18N
        jMenuItemClose.setText("Close");
        jMenuItemClose.addActionListener(formListener);
        jMenuFile.add(jMenuItemClose);

        jMenuBar.add(jMenuFile);

        jMenuSettings.setText("Settings");

        jMenuSkin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ic_mech_wheel.png"))); // NOI18N
        jMenuSkin.setText("Skin");

        jMenuItemClassic.setText("Classic");
        jMenuItemClassic.addActionListener(formListener);
        jMenuSkin.add(jMenuItemClassic);

        jMenuItemNimbus.setText("Nimbus");
        jMenuItemNimbus.addActionListener(formListener);
        jMenuSkin.add(jMenuItemNimbus);

        jMenuSettings.add(jMenuSkin);

        jMenuBar.add(jMenuSettings);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(jPanelSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.MouseListener, java.awt.event.MouseWheelListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jTextFieldSearch) {
                PlayerJFrame.this.jTextFieldSearchActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonSearch) {
                PlayerJFrame.this.jButtonSearchActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonPlay) {
                PlayerJFrame.this.jButtonPlayActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonPause) {
                PlayerJFrame.this.jButtonPauseActionPerformed(evt);
            }
            else if (evt.getSource() == jToggleButtonMute) {
                PlayerJFrame.this.jToggleButtonMuteActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonAdd) {
                PlayerJFrame.this.jButtonAddActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonRemove) {
                PlayerJFrame.this.jButtonRemoveActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonSelectNext) {
                PlayerJFrame.this.jButtonSelectNextActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonSelectPrevious) {
                PlayerJFrame.this.jButtonSelectPreviousActionPerformed(evt);
            }
            else if (evt.getSource() == jMenuItemOpen) {
                PlayerJFrame.this.jMenuItemOpenActionPerformed(evt);
            }
            else if (evt.getSource() == jMenuItemSave) {
                PlayerJFrame.this.jMenuItemSaveActionPerformed(evt);
            }
            else if (evt.getSource() == jMenuItemClose) {
                PlayerJFrame.this.jMenuItemCloseActionPerformed(evt);
            }
            else if (evt.getSource() == jMenuItemClassic) {
                PlayerJFrame.this.jMenuItemClassicActionPerformed(evt);
            }
            else if (evt.getSource() == jMenuItemNimbus) {
                PlayerJFrame.this.jMenuItemNimbusActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonStop) {
                PlayerJFrame.this.jButtonStopActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonPrevious) {
                PlayerJFrame.this.jButtonPreviousActionPerformed(evt);
            }
            else if (evt.getSource() == jButtonNext) {
                PlayerJFrame.this.jButtonNextActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jTextFieldSearch) {
                PlayerJFrame.this.jTextFieldSearchFocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == jTextFieldSearch) {
                PlayerJFrame.this.jTextFieldSearchFocusLost(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == jListPlaylist) {
                PlayerJFrame.this.jListPlaylistMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }

        public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            if (evt.getSource() == jSliderVolume) {
                PlayerJFrame.this.jSliderVolumeMouseWheelMoved(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == jSliderVolume) {
                PlayerJFrame.this.jSliderVolumeStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String searchStr = jTextFieldSearch.getText();

        if (searchStr == null || searchStr.trim().equals(EMPTY_STRING)) {
            return;
        }
        ArrayList<Integer> mp3FindedIndexes = new ArrayList<>();
        for (int i = 0; i < mp3ListModel.size(); i++) {
            MP3 mp3 = (MP3) mp3ListModel.getElementAt(i);
            if (mp3.getName().toUpperCase().contains(searchStr.toUpperCase())) {
                mp3FindedIndexes.add(i);
            }
        }
        int[] selectedIndexes = new int[mp3FindedIndexes.size()];
        if (selectedIndexes.length == 0) {
            JOptionPane.showMessageDialog(this, "Search by keyword:  \'" + searchStr + "\'  has no result");
            jTextFieldSearch.requestFocus();
            jTextFieldSearch.selectAll();
            return;
        }
        for (int i = 0; i < selectedIndexes.length; i++) {
            selectedIndexes[i] = mp3FindedIndexes.get(i);
        }
        jListPlaylist.setSelectedIndices(selectedIndexes);


    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {
        if (jTextFieldSearch.getText().equals(INPUT_SONG_NAME)) {
            jTextFieldSearch.setText(EMPTY_STRING);
        }
    }

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {
        if (jTextFieldSearch.getText().trim().equals(EMPTY_STRING)) {
            jTextFieldSearch.setText(INPUT_SONG_NAME);
        }
    }
    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemCloseActionPerformed

    private void jMenuItemClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClassicActionPerformed
        SkinUtils.changeSkin(this, UIManager.getSystemLookAndFeelClassName());
        jFileChooser.updateUI();
    }//GEN-LAST:event_jMenuItemClassicActionPerformed

    private void jButtonSelectNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectNextActionPerformed
        int nextIndex = jListPlaylist.getSelectedIndex() + 1;
        if (nextIndex <= jListPlaylist.getModel().getSize() - 1) {
            jListPlaylist.setSelectedIndex(nextIndex);
        }
    }//GEN-LAST:event_jButtonSelectNextActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int[] indexPlayList = jListPlaylist.getSelectedIndices();
        if (indexPlayList.length > 0) {
            ArrayList<MP3> mp3ListForRemove = new ArrayList<>();
            for (int i = 0; i < indexPlayList.length; i++) {
                MP3 mp3 = (MP3) mp3ListModel.getElementAt(indexPlayList[i]);
                mp3ListForRemove.add(mp3);
            }
            mp3ListForRemove.stream().forEach((mp3) -> {
                mp3ListModel.removeElement(mp3);
            });
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        player.pause();
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        int[] indexPlaylist = jListPlaylist.getSelectedIndices();
        if (indexPlaylist.length > 0) {
            MP3 mp3 = (MP3) mp3ListModel.getElementAt(indexPlaylist[0]);
            player.play(mp3.getPath());
            player.setVolume(jSliderVolume.getValue(), jSliderVolume.getMaximum());
            System.out.println(" Now playing: " + mp3.getPath());
        } else {
            System.out.print(" Nothing to play, please select the song ");
            JOptionPane.showMessageDialog(this, "Nothing to play, please select the song");
        }
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        FileUtils.addFileFilter(jFileChooser, mp3Filter);
        int result = jFileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = jFileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                MP3 mp3 = new MP3(file.getName(), file.getPath());
                if (!mp3ListModel.contains(mp3)) {
                    mp3ListModel.addElement(mp3);
                }
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSelectPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectPreviousActionPerformed
        int prevIndex = jListPlaylist.getSelectedIndex() - 1;
        if (prevIndex >= 0) {
            jListPlaylist.setSelectedIndex(prevIndex);
        }
    }//GEN-LAST:event_jButtonSelectPreviousActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        FileUtils.addFileFilter(jFileChooser, playlistFilter);
        int result = jFileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            if (selectedFile.exists()) {

                int resultOvveride = JOptionPane.showConfirmDialog(this, "File exists", "Overwrite?", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (resultOvveride) {
                    case JOptionPane.NO_OPTION:
                        jMenuItemSaveActionPerformed(evt);
                        return;
                    case JOptionPane.CANCEL_OPTION:
                        jFileChooser.cancelSelection();
                        return;
                }
                jFileChooser.approveSelection();
            }
            String fileExtension = FileUtils.getFileExtension(selectedFile);
            String fileNameForSave = (fileExtension != null && fileExtension.equals(PLAYLIST_EXTENSION)) ? selectedFile.getPath() : selectedFile.getPath() + "." + PLAYLIST_EXTENSION;
            FileUtils.serialize(mp3ListModel, fileNameForSave);
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        FileUtils.addFileFilter(jFileChooser, playlistFilter);
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            DefaultListModel mp3ListModel = (DefaultListModel) FileUtils.deserialize(selectedFile.getPath());
            this.mp3ListModel = mp3ListModel;
            jListPlaylist.setModel(mp3ListModel);
        }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNimbusActionPerformed
        SkinUtils.changeSkin(this, new NimbusLookAndFeel());
        jFileChooser.updateUI();

    }//GEN-LAST:event_jMenuItemNimbusActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTextFieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusGained
        if (jTextFieldSearch.getText().equals(INPUT_SONG_NAME)) {
            jTextFieldSearch.setText(EMPTY_STRING);
        }
    }//GEN-LAST:event_jTextFieldSearchFocusGained

    private void jTextFieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusLost
        if (jTextFieldSearch.getText().trim().equals(EMPTY_STRING)) {
            jTextFieldSearch.setText(INPUT_SONG_NAME);
        }
    }//GEN-LAST:event_jTextFieldSearchFocusLost

    private void jToggleButtonMuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonMuteActionPerformed
        if (jToggleButtonMute.isSelected()) {
            currentVolumeValue = jSliderVolume.getValue();
            jSliderVolume.setValue(0);
        } else {
            jSliderVolume.setValue(currentVolumeValue);
        }
    }//GEN-LAST:event_jToggleButtonMuteActionPerformed

    private void jListPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPlaylistMouseClicked
        if (evt.getModifiers() == InputEvent.BUTTON1_MASK && evt.getClickCount() == 2) {
            int[] indexPlaylist = jListPlaylist.getSelectedIndices();
            if (indexPlaylist.length > 0) {
                MP3 mp3 = (MP3) mp3ListModel.getElementAt(indexPlaylist[0]);
                player.play(mp3.getPath());
                player.setVolume(jSliderVolume.getValue(), jSliderVolume.getMaximum());
            }
        }
    }//GEN-LAST:event_jListPlaylistMouseClicked

    private void jSliderVolumeMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSliderVolumeMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jSliderVolumeMouseWheelMoved

    private void jSliderVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderVolumeStateChanged
        player.setVolume(jSliderVolume.getValue(), jSliderVolume.getMaximum());
        if (jSliderVolume.getValue() == 0) {
            jToggleButtonMute.setSelected(true);
        } else {
            jToggleButtonMute.setSelected(false);
        }
    }//GEN-LAST:event_jSliderVolumeStateChanged

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        player.stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        jButtonSelectPreviousActionPerformed(evt);
        jButtonPlayActionPerformed(evt);
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        jButtonSelectNextActionPerformed(evt);
        jButtonPlayActionPerformed(evt);
    }//GEN-LAST:event_jButtonNextActionPerformed

    /* <<<< MAIN >>>> */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PlayerJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSelectNext;
    private javax.swing.JButton jButtonSelectPrevious;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JList<String> jListPlaylist;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemClassic;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemNimbus;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JMenu jMenuSkin;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPanePlaylist;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSlider jSliderVolume;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToggleButton jToggleButtonMute;
    // End of variables declaration//GEN-END:variables
}
