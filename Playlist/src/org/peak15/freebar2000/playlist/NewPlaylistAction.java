package org.peak15.freebar2000.playlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.windows.TopComponent;

@ActionID(
    category = "File",
    id = "org.peak15.freebar2000.playlist.NewPlaylistAction")
@ActionRegistration(
    iconBase = "org/peak15/freebar2000/playlist/resources/document-new.png",
    displayName = "#CTL_NewPlaylistAction")
@ActionReferences({
    @ActionReference(path = "Menu/File", position = -100),
    @ActionReference(path = "Toolbars/File", position = -100),
    @ActionReference(path = "Shortcuts", name = "D-N")
})
public final class NewPlaylistAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TopComponent playlist = new PlaylistTopComponent();
        playlist.open();
        playlist.requestActive();
    }
}
