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
package org.eclipse.che.keycloak.server.deploy;

import com.google.inject.servlet.ServletModule;
import javax.inject.Singleton;
import org.eclipse.che.keycloak.server.KeycloakAuthenticationFilter;
import org.eclipse.che.keycloak.server.KeycloakEnvironmentInitalizationFilter;

public class KeycloakServletModule extends ServletModule {
  @Override
  protected void configureServlets() {
    bind(KeycloakAuthenticationFilter.class).in(Singleton.class);

    // Not contains '/websocket', /docs/ (for swagger) and not ends with '/ws' or '/eventbus' or '/settings/' or '/api/system/state' or '/api/stack/[^/]+/icon/'
    filterRegex(
            "^(?!.*(/websocket/?|/docs/))(?!.*(/ws/?|/eventbus/?|/settings/?|/api/system/state/?|/api/stack/[^/]+/icon/?)$).*")
        .through(KeycloakAuthenticationFilter.class);
    filterRegex(
            "^(?!.*(/websocket/?|/docs/))(?!.*(/ws/?|/eventbus/?|/settings/?|/api/system/state/?|/api/stack/[^/]+/icon/?)$).*")
        .through(KeycloakEnvironmentInitalizationFilter.class);
  }
}
