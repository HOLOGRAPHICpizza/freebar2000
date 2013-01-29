package org.peak15.freebar2000.nodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;
import org.peak15.freebar2000.types.Music;
import org.peak15.freebar2000.types.Song;

/**
 * A music node can be a single song or a collection.
 */
public class MusicNode extends AbstractNode {

	/**
	 * Node for a music object
	 * 
	 * @param music
	 */
    public MusicNode(Music music) {
        super(Children.LEAF, Lookups.singleton(song));
        setDisplayName(song.getName());
    }
	
	/**
	 * All Music node
	 */
    public MusicNode() {
        super(Children.create(new MusicChildFactory(), true));
        setDisplayName("All Music");
    }
}