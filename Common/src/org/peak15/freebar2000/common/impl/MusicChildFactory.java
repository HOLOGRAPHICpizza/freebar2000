package org.peak15.freebar2000.common.impl;

import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.peak15.freebar2000.common.Music;
import org.peak15.freebar2000.common.MusicNode;

public class MusicChildFactory extends ChildFactory<Music> {
	
	private final Music music;
	
	public MusicChildFactory(Music music) {
		this.music = music;
	}
	
	/**
	 * Call after changes to the music object.
	 */
	public void refresh() {
		super.refresh(false);
	}

	@Override
	protected boolean createKeys(List<Music> list) {
		// we need to populate that list, from WHATEVER
		//TODO: Check thread interrupted, and abort generation
		
		list.addAll(music.getList());

		return true;
	}
	
	@Override
	protected Node createNodeForKey(Music music) {
		return MusicNode.makeNode(music);
	}
}
