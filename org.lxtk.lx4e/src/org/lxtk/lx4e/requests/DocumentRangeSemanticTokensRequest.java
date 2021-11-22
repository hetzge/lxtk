/*******************************************************************************
 * Copyright (c) 2021 1C-Soft LLC.
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
package org.lxtk.lx4e.requests;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.SemanticTokens;
import org.eclipse.lsp4j.SemanticTokensRangeParams;
import org.lxtk.DocumentSemanticTokensProvider;

/**
 * Requests information about semantic tokens in the given text document.
 */
public class DocumentRangeSemanticTokensRequest
    extends LanguageFeatureRequestWithWorkDoneAndPartialResultProgress<
        DocumentSemanticTokensProvider, SemanticTokensRangeParams, SemanticTokens>
{
    @Override
    protected CompletableFuture<SemanticTokens> send(DocumentSemanticTokensProvider provider,
        SemanticTokensRangeParams params)
    {
        setTitle(MessageFormat.format(Messages.DocumentRangeSemanticTokensRequest_title, params));
        return provider.getDocumentRangeSemanticTokens(params);
    }
}
