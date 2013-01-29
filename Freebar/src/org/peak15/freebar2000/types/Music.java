package org.peak15.freebar2000.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A tree of music
 * 
 * immutable
 */
public final class Music {
	public enum MusicType {
		SONG,	// one song
		LIST	// a list of music
	}
	
	private final MusicType type;
	private final String name;
	private final List<Music> list;
	
	/**
	 * Create a SONG
	 * 
	 * @param name of the song 
	 */
	public Music(String name) {
		this.type = MusicType.SONG;
		this.name = name;
		this.list = null;
	}
	
	/**
	 * Create a LIST
	 * 
	 * @param list of music
	 */
	public Music(String name, List<Music> list) {
		this.type = MusicType.LIST;
		this.name = name;
		this.list = new ArrayList<Music>(list);
	}
	
	public MusicType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public List<Music> getList() {
		if(list == null) {
			return Collections.singletonList(this);
		}
		return Collections.unmodifiableList(list);
	}
	
	public Music append(Music music) {
		List<Music> l = new ArrayList<Music>();
		l.addAll(this.getList());
		l.addAll(music.getList());
		
		return new Music(this.name, l);
	}
}
