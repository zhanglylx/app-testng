package com.ZLYUtils;


import com.cxb.cxb_drives.AppAssert;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class ZLYURIUtils {
    public static URI getUrlBuild(URIBuilder uriBuilder) {
        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            AppAssert.fail(e);
        }
        return null;
    }

    public static URIBuilder getUriBuilder(URIBuilder uriBuilder) {
        try {
            return new URIBuilder(uriBuilder.build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static URIBuilder getUriBuilder(String url) {
        try {
            return new URIBuilder(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
