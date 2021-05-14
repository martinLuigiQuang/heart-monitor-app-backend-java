package heart_monitor.heartmonitorappbackendjava.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "heartdatasets")
public class HeartData {

    @Id private String _id;
    private String date;
    private Data heartData;

    public HeartData(String date, Data heartData) {
        this.date = date;
        this.heartData = heartData;
    }

    public String getId() {
        return _id;
    }

    public String getDate() {
        return date;
    }

    public Data getHeartData() {
        return heartData;
    }

    public static class Data {
        private String systolicPressure;
        private String diastolicPressure;
        private String heartRate;
        private String bloodSugar;
        private String bloodSugarUnit;

        public Data() {

        }

        public String getSystolicPressure() {
            return systolicPressure;
        }

        public String getDiastolicPressure() {
            return diastolicPressure;
        }

        public String getHeartRate() {
            return heartRate;
        }

        public String getBloodSugar() {
            return bloodSugar;
        }

        public String getBloodSugarUnit() {
            return bloodSugarUnit;
        }
    }

}
