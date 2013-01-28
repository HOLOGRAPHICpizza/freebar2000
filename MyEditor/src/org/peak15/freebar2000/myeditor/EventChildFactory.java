/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peak15.freebar2000.myeditor;

import java.util.Arrays;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;
import org.peak15.freebar2000.myapi.Event;

/**
 *
 * @author michael
 */
class EventChildFactory extends ChildFactory<Event> {

    public EventChildFactory() {}

    @Override
    protected boolean createKeys(List<Event> list) {
        Event[] objs = new Event[5];
        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Event();
        }
        list.addAll(Arrays.asList(objs));
        return true;
    }
    
    @Override
    protected Node createNodeForKey(Event key) {
        Node result = new AbstractNode(
                Children.create(new EventChildFactory(), true), 
                Lookups.singleton(key));
        result.setDisplayName(key.toString());
        return result;
    }
}
