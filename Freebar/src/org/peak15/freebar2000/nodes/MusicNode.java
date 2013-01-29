package org.peak15.freebar2000.nodes;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import org.openide.nodes.AbstractNode;
import org.peak15.freebar2000.types.Music;

/**
 * A music node can be a single song or a collection.
 */
public final class MusicNode extends AbstractNode {
	
	private final Music music;
	
	/**
	 * Node for a music object
	 * 
	 * @param music
	 */
    public MusicNode(Music music) {
        super(MusicChildFactory.makeChildren(music));
		this.music = music;
        setDisplayName(music.getName());
    }
	
	@Override
	public Action[] getActions(boolean popup) {
		return new Action[] { new AddToPlaylistAction() };
	}
	
	private class AddToPlaylistAction extends AbstractAction {
		
		public AddToPlaylistAction() {
			putValue(NAME, "Add to Current Playlist");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Hello from " + music.getName());
			
		}
	}
}