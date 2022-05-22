package com.kneerecoveryhelper.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

  public Integer getWeekDifferencesInDates(Date firstDate, Date secondDate) {
    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

    return Math.toIntExact(
        TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 7 + 1);
  }

}
