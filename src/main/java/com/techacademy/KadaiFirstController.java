package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        try {
            // 日付文字列をDateオブジェクトに変換
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date specifiedDate = sdf.parse(date);

            // Calendarオブジェクトに指定日付をセット
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(specifiedDate);

            // 曜日を取得して返す
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
            return daysOfWeek[dayOfWeek - 1];
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
    @GetMapping("/plus/{num1}/{num2}")
    public int calcPlus(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/minus/{num1}/{num2}")
    public int calcMinus(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping("/times/{num1}/{num2}")
    public int calcTimes(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/{num2}")
    public int calcDivide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return num1 / num2;
    }
}
