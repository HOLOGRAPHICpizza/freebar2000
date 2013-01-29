/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.peak15.freebar2000.ui;

import java.util.Collection;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.peak15.freebar2000.types.Music;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//org.peak15.freebar2000.ui//Viewer//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "ViewerTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "properties", openAtStartup = true)
@ActionID(category = "Window", id = "org.peak15.freebar2000.ui.ViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_ViewerAction",
preferredID = "ViewerTopComponent")
@Messages({
	"CTL_ViewerAction=Viewer",
	"CTL_ViewerTopComponent=Viewer Window",
	"HINT_ViewerTopComponent=This is a Viewer window"
})
public final class ViewerTopComponent extends TopComponent implements LookupListener {
	
	private Lookup.Result<Music> result = null;
	
	public ViewerTopComponent() {
		initComponents();
		setName(Bundle.CTL_ViewerTopComponent());
		setToolTipText(Bundle.HINT_ViewerTopComponent());

	}
	
	@Override
    public void componentOpened() {
        result = Utilities.actionsGlobalContext().lookupResult(Music.class);
        result.addLookupListener(this);
    }
    
    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
    }
	
	@Override
	public void resultChanged(LookupEvent le) {
		Collection<? extends Music> list = result.allInstances();
		StringBuilder sb = new StringBuilder();
		sb.append("taco,");
		for(Music m : list) {
			sb.append(m.getName()).append(',');
		}
		jLabel1.setText(sb.toString());
		setDisplayName(sb.toString());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ViewerTopComponent.class, "ViewerTopComponent.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

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
