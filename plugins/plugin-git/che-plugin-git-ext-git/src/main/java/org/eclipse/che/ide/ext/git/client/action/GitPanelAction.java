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
package org.eclipse.che.ide.ext.git.client.action;

import javax.inject.Inject;
import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.ext.git.client.panel.GitPanelPresenter;

/** @author Mykola Morhun */
public class GitPanelAction extends Action {
  private final GitPanelPresenter gitPanelPresenter;

  @Inject
  public GitPanelAction(GitPanelPresenter gitPanelPresenter) {
    this.gitPanelPresenter = gitPanelPresenter;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (gitPanelPresenter.isGitPanelOpened()) {
      gitPanelPresenter.hideGitPanel();
    } else {
      gitPanelPresenter.showGitPanel();
    }
  }
}