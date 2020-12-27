/*******************************************************************************
 * Copyright (c) 2020 1C-Soft LLC.
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
package org.lxtk;

/**
 * Represents a work done progress.
 */
public interface WorkDoneProgress
    extends Progress
{
    /**
     * Returns the state of the work done progress.
     * <p>
     * May return a new instance each time this method is invoked.
     * </p>
     *
     * @return the progress state, or <code>null</code> if the progress has not started yet
     */
    WorkDoneProgressState getState();
}