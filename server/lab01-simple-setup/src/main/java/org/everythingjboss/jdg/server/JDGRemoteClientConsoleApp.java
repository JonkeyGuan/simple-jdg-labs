package org.everythingjboss.jdg.server;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class JDGRemoteClientConsoleApp {

    private static final Logger logger = LogManager.getLogger(JDGRemoteClientConsoleApp.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration configuration = new ConfigurationBuilder().build();

        RemoteCacheManager cacheManager = new RemoteCacheManager(configuration);
        RemoteCache<String, String> remoteCache = cacheManager.getCache("localCache");
        remoteCache.clear();
        
        remoteCache.put("1", "One");
        remoteCache.put("2", "Two");

        logger.info("The size of the cache is : {}", remoteCache.size());
        cacheManager.stop();
    }
}
