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
package org.jboss.tools.fuse.sap.qe.reddeer.component;

import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.APPLICATION_RELEASE;
import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.DESTINATION;
import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.IDOC_TYPE;
import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.IDOC_TYPE_EXTENSION;
import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.QUEUE;
import static org.jboss.tools.fuse.sap.qe.reddeer.component.SAPLabels.SYSTEM_RELEASE;

import org.jboss.tools.fuse.qe.reddeer.component.AbstractURICamelComponent;

/**
 * 
 * @author apodhrad
 *
 */
public class SAPQIDocDestination extends AbstractURICamelComponent {

	public SAPQIDocDestination() {
		super("sap-qidoc-destination");
		addProperty(DESTINATION, "destination");
		addProperty(QUEUE, "queue");
		addProperty(IDOC_TYPE, "idocType");
		addProperty(IDOC_TYPE_EXTENSION, "idocTypeExtension");
		addProperty(SYSTEM_RELEASE, "systemRelease");
		addProperty(APPLICATION_RELEASE, "applicationRelease");
	}

	@Override
	public String getPaletteEntry() {
		return "SAP Queued IDoc Destination";
	}

}
