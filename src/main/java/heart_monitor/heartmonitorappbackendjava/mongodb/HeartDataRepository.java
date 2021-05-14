package heart_monitor.heartmonitorappbackendjava.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartDataRepository extends MongoRepository<HeartData, String> {
    List<HeartData> findByDateStartingWith(String date);
}
