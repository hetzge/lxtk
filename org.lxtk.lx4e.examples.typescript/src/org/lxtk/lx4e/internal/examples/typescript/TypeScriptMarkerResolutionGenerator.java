/*******************************************************************************
 * Copyright (c) 2019 1C-Soft LLC.
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Vladimir Piskarev (1C) - initial API and implementation
 *******************************************************************************/
package org.lxtk.lx4e.internal.examples.typescript;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.lxtk.CommandService;
import org.lxtk.LanguageOperationTarget;
import org.lxtk.lx4e.examples.typescript.TypeScriptCore;
import org.lxtk.lx4e.refactoring.WorkspaceEditChangeFactory;
import org.lxtk.lx4e.ui.codeaction.AbstractMarkerResolutionGenerator;

/**
 * TODO JavaDoc
 */
public class TypeScriptMarkerResolutionGenerator
    extends AbstractMarkerResolutionGenerator
{
    @Override
    protected LanguageOperationTarget getLanguageOperationTarget(IMarker marker)
    {
        IResource resource = marker.getResource();
        if (!(resource instanceof IFile))
            return null;
        if (!MarkerUtilities.isMarkerType(marker,
            TypeScriptLanguageClient.MARKER_TYPE))
            return null;
        return TypeScriptOperationTargetProvider.getOperationTarget(
            (IFile)resource);
    }

    @Override
    protected CommandService getCommandService()
    {
        return TypeScriptCore.CMD_SERVICE;
    }

    @Override
    protected WorkspaceEditChangeFactory getWorkspaceEditChangeFactory()
    {
        return TypeScriptWorkspaceEditChangeFactory.INSTANCE;
    }
}
