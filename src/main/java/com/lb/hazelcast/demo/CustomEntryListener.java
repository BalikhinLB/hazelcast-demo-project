package com.lb.hazelcast.demo;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomEntryListener implements EntryAddedListener<String, String>, EntryUpdatedListener<String, String> {

    private HazelcastInstance hazelcastInstance;
    public CustomEntryListener(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public void entryAdded(EntryEvent<String, String> entryEvent) {
        if (!entryEvent.getMember().getUuid().equals(hazelcastInstance.getCluster().getLocalMember().getUuid())) {
            log.info("Inserted new value:{} from {}", entryEvent.getValue(), entryEvent.getKey());
        }
    }

    @Override
    public void entryUpdated(EntryEvent<String, String> entryEvent) {
        if (!entryEvent.getMember().getUuid().equals(hazelcastInstance.getCluster().getLocalMember().getUuid())) {
            log.info("Updated new value:{} from {}", entryEvent.getValue(), entryEvent.getKey());
        }
    }
}
