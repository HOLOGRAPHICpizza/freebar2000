package org.peak15.freebar2000.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.peak15.freebar2000.nodes.MusicNode;
import org.peak15.freebar2000.types.Music;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//org.peak15.freebar2000.ui//MusicBrowser//EN",
	autostore = false)
@TopComponent.Description(
    preferredID = "MusicBrowserTopComponent",
	persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.peak15.freebar2000.ui.MusicBrowserTopComponent")
@ActionReference(path = "Menu/Window", position = -100)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_MusicBrowserAction",
	preferredID = "MusicBrowserTopComponent")
public final class MusicBrowserTopComponent extends TopComponent implements ExplorerManager.Provider {
	
	private final ExplorerManager mgr = new ExplorerManager();
	private final Music library;
	private final MusicNode root;
	
	public MusicBrowserTopComponent() {
		initComponents();
		
		// connect lookup of selected node
		associateLookup(ExplorerUtils.createLookup(mgr, getActionMap()));
		
		setName(NbBundle.getMessage(MusicBrowserTopComponent.class, "CTL_MusicBrowserTopComponent"));
		setToolTipText(NbBundle.getMessage(MusicBrowserTopComponent.class, "HINT_MusicBrowserTopComponent"));
		
		setLayout(new BorderLayout());
		add(new BeanTreeView(), BorderLayout.CENTER);
		
		// add root node
		List<Music> vavaList = new ArrayList<Music>();
		vavaList.add(new Music("What"));
		vavaList.add(new Music("Empathy"));
		
		List<Music> bassList = new ArrayList<Music>();
		bassList.add(new Music("VAVA VOOM", vavaList));
		bassList.add(new Music("MOTW"));
		
		List<Music> all = new ArrayList<Music>();
		all.add(new Music("Bassnectar", bassList));
		all.add(new Music("Human"));
		
		library = new Music("All Music", all);
		root = MusicNode.makeNode(library);
		
		mgr.setRootContext(root);
	}

	@Override
	public ExplorerManager getExplorerManager() {
		return mgr;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
	@Override
	public void componentOpened() {
		// TODO add custom code on component opening
	}

	@Override
	public void componentClosed() {
		// TODO add custom code on component closing
	}

	void writeProperties(java.util.Properties p) {
		// better to version settings since initial version as advocated at
		// http://wiki.apidesign.org/wiki/PropertyFiles
		p.setProperty("version", "1.0");
		// TODO store your settings
	}

	void readProperties(java.util.Properties p) {
		String version = p.getProperty("version");
		// TODO read your settings according to their version
	}
}
