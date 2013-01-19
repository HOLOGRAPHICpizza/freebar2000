package org.peak15.freebar2000.word.editor.uppercase;

import org.openide.util.lookup.ServiceProvider;
import org.peak15.freebar2000.word.editor.api.WordFilter;

@ServiceProvider(service=WordFilter.class)
public class UppercaseFilter implements WordFilter {

    @Override
    public String process(String str) {
        return str.toUpperCase();
    }
    
}
