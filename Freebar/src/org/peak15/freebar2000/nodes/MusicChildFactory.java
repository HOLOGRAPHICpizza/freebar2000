package org.peak15.freebar2000.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.peak15.freebar2000.types.Music;

public class MusicChildFactory extends ChildFactory<Music> {
	
	private final 
	
	/**
	 * Create a sample tree.
	 */
	public MusicChildFactory() {
		//
	}
	
	/**
	 * create a node tree from the music tree
	 * 
	 * @param music the tree
	 */
	public MusicChildFactory(Music music) {
		//
	}

	@Override
	protected boolean createKeys(List<Music> list) {
		// we need to populate that list, from WHATEVER
		
		List<Music> vavaList = new ArrayList<Music>();
		vavaList.add(new Music("What"));
		vavaList.add(new Music("Empathy"));
		
		List<Music> bassList = new ArrayList<Music>();
		bassList.add(new Music("VAVA VOOM", vavaList));
		bassList.add(new Music("MOTW"));
		
		list.add(new Music("Bassnectar", bassList));
		list.add(new Music("Human"));

		return true;
	}
	
	@Override
	protected Node createNodeForKey(Music music) {
		return new MusicNode(music);
	}
}
