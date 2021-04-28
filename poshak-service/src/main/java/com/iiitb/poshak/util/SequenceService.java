package com.iiitb.poshak.util;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceService {
    @Resource
    private SequenceRepository sequenceRepository;

    @Resource
    private MongoOperations mongoOperations;

    public Long getSequenceNextVal(String sequenceName) {
        Sequence sequence = mongoOperations.findAndModify(
                Query.query(where("sequenceName").is(sequenceName)),
                new Update().inc("nextval", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class
        );

        return sequence.getNextval();
    }
}
