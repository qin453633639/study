package com.bestbigbird;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
                .build();
        cacheManager.init();

        Cache<Long, String> preConfigured =  cacheManager.getCache("preConfigured", Long.class, String.class);
        Cache<Long, String> myCache = cacheManager.createCache("myCache",CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));

        myCache.put(1L, "da one!1");
        myCache.put(2L, "da one!2");
        myCache.put(3L, "da one!3");
        myCache.put(4L, "da one!4");
        myCache.put(5L, "da one!5");
        myCache.put(6L, "da one!6");
        myCache.put(7L, "da one!7");
        myCache.put(8L, "da one!8");
        myCache.put(9L, "da one!9");
        myCache.put(10L, "da one!10");
        myCache.put(11L, "da one!11");

        for(int i =1;i<=11;i++){
            String value = myCache.get(Integer.valueOf(i).longValue());
            System.out.println(value);
        }



        cacheManager.removeCache("preConfigured");
        cacheManager.close();



        CacheConfiguration<Long, String> usesConfiguredInCacheConfig = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Long.class, String.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
                        .heap(10, MemoryUnit.KB)
                        .offheap(10, MemoryUnit.MB)
                        .disk(20, MemoryUnit.MB, true)
                )
                .withSizeOfMaxObjectGraph(1000)
                .withSizeOfMaxObjectSize(1000, MemoryUnit.B)
                .build();
    }
}
