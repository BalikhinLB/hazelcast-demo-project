package com.lb.hazelcast.demo;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.UUID;

@Slf4j
@Component
public class SimpleScheduler {

    final private HazelcastInstance hazelcastInstance;
    private IMap<String,String> cacheMap;

    public SimpleScheduler(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @PostConstruct
    public void setup() {
        cacheMap = hazelcastInstance.getMap("CACHE_FOR_ALL");
        cacheMap.addLocalEntryListener(new CustomEntryListener(hazelcastInstance));
    }



    @Scheduled(fixedDelay = 5000)
    public void startJob(){
        cacheMap.put(hazelcastInstance.getName(), String.format("New Job now:%s", LocalTime.now()));
    }
}
