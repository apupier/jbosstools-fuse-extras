/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.fuse.sap.qe.reddeer.view;

import org.jboss.reddeer.common.wait.WaitWhile;
import org.jboss.reddeer.core.condition.ShellWithTextIsAvailable;
import org.jboss.reddeer.swt.impl.button.OkButton;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.swt.impl.tree.DefaultTreeItem;
import org.jboss.reddeer.workbench.impl.view.WorkbenchView;
import org.jboss.tools.fuse.sap.qe.reddeer.dialog.SAPTestDestinationDialog;
import org.jboss.tools.fuse.sap.qe.reddeer.dialog.SAPTestServerDialog;

public class SAPConnectionView extends WorkbenchView {

	public static final String TITLE = "SAP Connections";

	public SAPConnectionView() {
		super(TITLE);
	}

	public void selectDestination() {
		open();
		new DefaultTreeItem("SAP Connection Configuration", "Destination Data Store").select();
	}

	public void selectDestination(String name) {
		open();
		new DefaultTreeItem("SAP Connection Configuration", "Destination Data Store", name).select();
	}

	public void newDestination(String name) {
		selectDestination();
		new ContextMenu("New Destination").select();
		new DefaultShell("Create Destination");
		new LabeledText("Please provide a destination name").setText(name);
		new OkButton().click();
		new WaitWhile(new ShellWithTextIsAvailable("Create Destination"));
	}

	public void deleteDestination(String name) {
		selectDestination(name);
		new ContextMenu("Delete").select();
	}

	public SAPTestDestinationDialog openDestinationTest(String name) {
		selectDestination(name);
		new ContextMenu("Test").select();
		return new SAPTestDestinationDialog().activate();
	}

	public SAPDestinationProperties openDestinationProperties(String name) {
		selectDestination(name);
		SAPDestinationProperties sapDestinationProperties = new SAPDestinationProperties();
		sapDestinationProperties.open();
		return sapDestinationProperties;
	}

	public void selectServer() {
		open();
		new DefaultTreeItem("SAP Connection Configuration", "Server Data Store").select();
	}

	public void selectServer(String name) {
		open();
		new DefaultTreeItem("SAP Connection Configuration", "Server Data Store", name).select();
	}

	public void newServer(String name) {
		selectServer();
		new ContextMenu("New Server").select();
		new DefaultShell("Create Server");
		new LabeledText("Please provide a server name").setText(name);
		new OkButton().click();
		new WaitWhile(new ShellWithTextIsAvailable("Create Server"));
	}

	public void deleteServer(String name) {
		selectServer(name);
		new ContextMenu("Delete").select();
	}

	public SAPTestServerDialog openServerTest(String name) {
		selectServer(name);
		new ContextMenu("Test").select();
		return new SAPTestServerDialog().activate();
	}

	public SAPServerProperties openServerProperties(String name) {
		selectServer(name);
		SAPServerProperties sapServerProperties = new SAPServerProperties();
		sapServerProperties.open();
		return sapServerProperties;
	}

}
