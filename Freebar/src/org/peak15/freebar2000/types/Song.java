package org.peak15.freebar2000.types;

/**
 * Abstract representation of a song.
 * 
 * Immutable.
 */
public final class Song {
    private final String name;
    
    public Song(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
