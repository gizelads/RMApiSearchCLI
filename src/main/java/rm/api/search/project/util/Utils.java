package rm.api.search.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date toDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
