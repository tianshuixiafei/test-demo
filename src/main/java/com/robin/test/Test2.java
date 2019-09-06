package com.robin.test;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.time.Instant;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        long mill = Instant.now().toEpochMilli();
        System.out.println(mill);
        System.out.println("the time is:" + new Date().getTime());
    }

    final DateTime DISTRIBUTION_TIME_SPLIT_TIME = new DateTime().withTime(15, 0, 0, 0);

    private Date calculateDistributionTimeByOrderCreateTime(Date orderCreateTime) {
        DateTime orderCreateDateTime = new DateTime(orderCreateTime);
        Date tomorrow = orderCreateDateTime.plusDays(1).toDate();
        Date theDayAfterTomorrow = orderCreateDateTime.plusDays(2).toDate();
        return orderCreateDateTime.isAfter(DISTRIBUTION_TIME_SPLIT_TIME) ? wrapDistributionTime(theDayAfterTomorrow) : wrapDistributionTime(tomorrow);
    }

    private Date wrapDistributionTime(Date distributionTime) {
        DateTime currentDistributionDateTime = new DateTime(distributionTime);
        DateTime plusOneDay = currentDistributionDateTime.plusDays(1);
        boolean isSunday = (DateTimeConstants.SUNDAY == currentDistributionDateTime.getDayOfWeek());
        return isSunday ? plusOneDay.toDate() : currentDistributionDateTime.toDate();

    }
}
