package org.peak15.freebar2000.nodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;
import org.peak15.freebar2000.types.Song;

public class SongNode extends AbstractNode {

    /*public SongNode(Song song) {
        super (Children.create(new SongChildFactory(), true), Lookups.singleton(song));
        setDisplayName ("Event " + song.getIndex());
    }*/

    public SongNode() {
        super(null);
        //super (Children.create(new SongChildFactory(), true));
        //setDisplayName ("Root");
    }
}