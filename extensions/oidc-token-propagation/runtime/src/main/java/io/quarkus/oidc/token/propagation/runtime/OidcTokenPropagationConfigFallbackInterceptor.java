package io.quarkus.oidc.token.propagation.runtime;

import java.util.function.Function;

import io.quarkus.runtime.util.StringUtil;
import io.smallrye.config.FallbackConfigSourceInterceptor;

/**
 * @deprecated maps the old config to the new config, should be removed at some point
 */
@Deprecated(forRemoval = true, since = "3.9")
public class OidcTokenPropagationConfigFallbackInterceptor extends FallbackConfigSourceInterceptor {

    private static final String OLD_PREFIX = "quarkus.oidc-token-propagation.";
    private static final String NEW_PREFIX = "quarkus.resteasy-client-oidc-token-propagation.";
    private static final Function<String, String> RENAME_FUNCTION = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return StringUtil.changePrefix(s, NEW_PREFIX, OLD_PREFIX);
        }
    };

    public OidcTokenPropagationConfigFallbackInterceptor() {
        super(RENAME_FUNCTION);
    }
}
