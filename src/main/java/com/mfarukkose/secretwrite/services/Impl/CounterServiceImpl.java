package com.mfarukkose.secretwrite.services.Impl;

import com.mfarukkose.secretwrite.models.Counter;
import com.mfarukkose.secretwrite.repositories.CounterRepository;
import com.mfarukkose.secretwrite.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    @Autowired
    private CounterRepository counterRepository;

    @Override
    public long getNext(String sequenceId) {
        Counter counter = counterRepository.findCounterById(sequenceId);
        if(counter == null) {
            counter = new Counter(sequenceId, 0);
        }
        long id = counter.getSeq();
        counter.setSeq(id + 1);
        counterRepository.save(counter);
        return id;
    }
}
