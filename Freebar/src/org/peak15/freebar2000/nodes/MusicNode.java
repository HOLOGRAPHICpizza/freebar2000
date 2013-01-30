package org.peak15.freebar2000.nodes;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.peak15.freebar2000.types.Music;
import org.peak15.freebar2000.ui.PlaylistTopComponent;

/**
 * A music node can be a single song or a collection.
 */
public final class MusicNode extends AbstractNode {
	
	private final Music music;
	private final MusicChildFactory childFactory;
	
	/**
	 * Create node modeled on given music object
	 * 
	 * @param music data model, may modify.
	 * @return the newly created node
	 */
	public static MusicNode makeNode(Music music) {
		Children children;
		MusicChildFactory childFactory = null;
		if(music.getType() == Music.Type.SONG) {
			children = Children.LEAF;
		}
		else {
			childFactory = new MusicChildFactory(music);
			children = Children.create(childFactory, true);
		}
		
		return new MusicNode(music, children, childFactory);
	}
	
	/**
	 * Call after changes to the music object.
	 */
	public void refresh() {
		childFactory.refresh();
	}
	
    private MusicNode(Music music, Children children, MusicChildFactory childFactory) {
        super(children);
		this.childFactory = childFactory;
		this.music = music;
		setName(music.getName());
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
			PlaylistTopComponent playlist = PlaylistTopComponent.getFocusedInstance();
			if(playlist != null) {
				playlist.addMusic(music);
			}
		}
	}
}