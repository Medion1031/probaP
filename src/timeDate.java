import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import static org.junit.Assert.assertEquals;

public class timeDate {
     static LocalDateTime CalculateDueDate(LocalDateTime submitDate, int duration) {
         try {
             if (submitDate.get(ChronoField.HOUR_OF_DAY) < 8 ||
                 (submitDate.get(ChronoField.HOUR_OF_DAY) >= 17) ||
                 submitDate.get(ChronoField.DAY_OF_WEEK) > 5 ||
                duration < 0) {
                 throw new Exception();
             }
             if(submitDate.get(ChronoField.HOUR_OF_DAY) == 17 && submitDate.get(ChronoField.MINUTE_OF_HOUR) == 0) {
                 throw new Exception();
             }
         } catch (Exception ex) {
             System.out.println("you are out of the working time range!");
             return null;
         }

         LocalDateTime result = submitDate;
         int durationInDays = duration / 8,
             simpleDuration = duration - durationInDays * 8,
             calculatedRawHours = submitDate.get(ChronoField.HOUR_OF_DAY) + simpleDuration;

         result = result.plusDays(durationInDays);
         result = result.plusHours(simpleDuration);

         //15 ora van a munkaido vege es kezdete kozott
         if (calculatedRawHours > 17) {
             result = result.plusHours(15);
         } else if (calculatedRawHours == 17 && submitDate.get(ChronoField.MINUTE_OF_HOUR) > 0){
             result = result.plusHours(15);
         }

         if(result.get(ChronoField.DAY_OF_WEEK) > 5) result = result.plusDays(8 - result.get(ChronoField.DAY_OF_WEEK));

        return result;
    }
}

