package com.mfarukkose.secretwrite.models;

import org.springframework.data.annotation.Id;

public class Counter {

    @Id
    private String id;

    private long seq;

    public Counter(String id, long seq) {
        this.id = id;
        this.seq = seq;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
