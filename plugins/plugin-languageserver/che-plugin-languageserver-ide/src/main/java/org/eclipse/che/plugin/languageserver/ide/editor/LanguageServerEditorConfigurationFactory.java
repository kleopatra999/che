/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.languageserver.ide.editor;

import org.eclipse.che.ide.api.editor.texteditor.TextEditor;
import org.eclipse.lsp4j.ServerCapabilities;

/** @author Evgen Vidolob */
public interface LanguageServerEditorConfigurationFactory {

  LanguageServerEditorConfiguration build(TextEditor editor, ServerCapabilities capabilities);
}
