package org.peak15.freebar2000.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.peak15.freebar2000.types.Music;

public class MusicChildFactory extends ChildFactory<Music> {
	
	private final Music music;
	
	public static Children makeChildren(Music music) {
		if(music.getType() == Music.MusicType.SONG) {
			return Children.LEAF;
		}
		else {
			return Children.create(new MusicChildFactory(music), true);
		}
	}
	
	private MusicChildFactory(Music music) {
		this.music = music;
	}

	@Override
	protected boolean createKeys(List<Music> list) {
		// we need to populate that list, from WHATEVER
		
		list.addAll(music.getChildren());

		return true;
	}
	
	@Override
	protected Node createNodeForKey(Music music) {
		return new MusicNode(music);
	}
}
