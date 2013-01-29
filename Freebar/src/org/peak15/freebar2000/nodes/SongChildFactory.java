package org.peak15.freebar2000.nodes;

import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;
import org.peak15.freebar2000.types.Song;

public class SongChildFactory extends ChildFactory<Song> {

	public SongChildFactory() {
		//
	}

	@Override
	protected boolean createKeys(List<Song> list) {
		list.add(new Song("test1"));
		list.add(new Song("test2"));
		list.add(new Song("test3"));

		return true;
	}
	
	@Override
	protected Node createNodeForKey(Song key) {
		Node result = new AbstractNode(
			Children.create(new SongChildFactory(), true), 
			Lookups.singleton(key));
		result.setDisplayName(key.getName());
		
		return result;
	}
}
