package org.peak15.freebar2000.playlist;

import java.awt.event.ActionEvent;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.peak15.freebar2000.common.MusicNode;
import org.peak15.freebar2000.common.MusicNodeAction;

@ActionRegistration(displayName="#CTL_AddToPlaylistAction")
@ActionID(category="Tools", id = "org.peak15.freebar2000.playlist.AddToPlaylistAction")
public class AddToPlaylistAction implements MusicNodeAction {
	
	MusicNode context;
	
	public AddToPlaylistAction(MusicNode context) {
		this.context = context;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PlaylistTopComponent playlist = PlaylistTopComponent.getFocusedInstance();
		if(playlist != null) {
			//TODO: grab music from global selection, or preferably from context
			//playlist.addMusic(music);
		}
	}
	
}
