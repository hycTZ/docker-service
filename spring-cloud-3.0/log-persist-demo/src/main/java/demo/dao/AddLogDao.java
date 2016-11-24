package demo.dao;

import demo.model.AddLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lh on 2016/10/26.
 */
@Repository
public interface AddLogDao extends MongoRepository<AddLog, String> {
}
