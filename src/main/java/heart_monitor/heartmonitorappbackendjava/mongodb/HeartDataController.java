package heart_monitor.heartmonitorappbackendjava.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartDataController {

    @Autowired
    public HeartDataRepository heartDataRepository;

    @GetMapping("/all")
    public List<HeartData> getAllHeartDatasets() {
        return heartDataRepository.findAll();
    }

    @GetMapping("/{date}")
    public List<HeartData> getHeartDatasets(@PathVariable("date") String date) {
        return heartDataRepository.findByDateStartingWith(date);
    }

    @GetMapping("/")
    public Optional<HeartData> getHeartDatasetById(@RequestParam String id) {
        Optional<HeartData> foundDataset = heartDataRepository.findById(id);
        return foundDataset;
    }

    @PostMapping("/")
    public HeartData saveHeartDataset(@RequestBody HeartData heartDataset) {
        return heartDataRepository.insert(heartDataset);
    }

    @DeleteMapping("/")
    public Optional<HeartData> deleteHeartDataset(@RequestParam String id) {
        Optional<HeartData> deletedEntry = heartDataRepository.findById(id);
        heartDataRepository.deleteById(id);
        return deletedEntry;
    }

}
