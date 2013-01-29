package org.peak15.freebar2000.nodes;

import org.openide.nodes.AbstractNode;
import org.peak15.freebar2000.types.Music;

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
        super(MusicChildFactory.makeChildren(music));
        setDisplayName(music.getName());
    }
}