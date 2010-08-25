/*
 * $Id$
 * $URL$
 * 
 * ====================================================================
 * Ikasan Enterprise Integration Platform
 * Copyright (c) 2003-2008 Mizuho International plc. and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the 
 * Free Software Foundation Europe e.V. Talstrasse 110, 40217 Dusseldorf, Germany 
 * or see the FSF site: http://www.fsfeurope.org/.
 * ====================================================================
 */
package org.ikasan.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Retrospective JUnit test class for DateUtils,
 * 
 * TODO Method names were generated by Eclipse IDE and are therefore perhaps not
 * ideal test names.
 * 
 * @author Ikasan Development Team
 */
public class DateUtilsTest extends TestCase
{
    /** Instance of the DateUtils class */
    private DateUtils du = null;
    /** The current time in millisec */
    private long dateMillis = System.currentTimeMillis();
    /** The new date time format */
    private String newFormat = "dd-MM-yyyy HH:mm:ss.SSS";
    /** The new time zone id */
    private String newTzId = "GMT";
    
    @Override
    protected void setUp() throws Exception
    {
        du = new DateUtils(dateMillis);
        newFormat = "dd-MM-yyyy HH:mm:ss.SSS";
        newTzId = "GMT";
    }

    /**
     * Test the Date and TimeZone Constructor
     */
    @Test
    public void testDateUtilsDateTimeZone()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the Date and String Constructor
     */
    @Test
    public void testDateUtilsDateString()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the Date Constructor
     */
    @Test
    public void testDateUtilsDate()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the Long and TimeZone Constructor
     */
    @Test
    public void testDateUtilsLongTimeZone()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the Long and String Constructor
     */
    @Test
    public void testDateUtilsLongString()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the Long Constructor
     */
    @Test
    public void testDateUtilsLong()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test the default Constructor
     */
    @Test
    public void testDateUtils()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the time from the calendar
     */
    @Test
    public void testGetTimeInCalendar()
    {
        TimeZone timeZone = TimeZone.getTimeZone("BST");
        Date date = new Date();
        du = new DateUtils(date, timeZone);
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.setTime(date);
        assertEquals(calendar, du.getTimeInCalendar());
    }

    /**
     * Test setting the time
     */
    @Test
    public void testSetTimeInDate()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the time from the date
     */
    @Test
    public void testGetTimeInDate()
    {
        // System.out.println("Result =[" + du.getTimeInDate() + "]");
    }

    /**
     * Test setting the time in milliseconds
     */
    @Test
    public void testSetTimeInMillis()
    {
        du.setTimeInMillis(dateMillis);
        long dateInMillis = du.getTimeInMillis();
        assertEquals(dateMillis, dateInMillis);
    }

    /**
     * Test getting the time in milliseconds
     */
    @Test
    public void testGetTimeInMillis()
    {
        du.setTimeInMillis(dateMillis);
        long dateInMillis = du.getTimeInMillis();
        assertEquals(dateMillis, dateInMillis);
    }

    /**
     * Test getting the time in a particular format
     */
    @Test
    public void testGetTimeInFormatStringDateFormatTimeZone()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the time in a particular format
     */
    @Test
    public void testGetTimeInFormatStringStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the time in a particular format
     */
    @Test
    public void testGetTimeInFormatStringStringString()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the time in a particular format
     * (Format and TimeZone Id)
     */
    @Test
    public void testGetTimeInFormatStringString()
    {
        String expectedResult = "08-10-2008 13:50:40.078";
        String result = du.getTimeInFormatString(newFormat, newTzId);
        // TODO, some clever regular expression work here
    }

    /**
     * Test getting only the date from the calendar
     */
    @Test
    public void testGetOnlyDateInDate()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date expectedResult = calendar.getTime();
        Date result = du.getOnlyDateInDate();
        assertEquals(expectedResult.toString(), result.toString());
    }

    /**
     * Test getting back the date component only as millisec
     */
    @Test
    public void testGetOnlyDateInMillis()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long expectedResult = calendar.getTime().getTime();
        Date date = calendar.getTime();
        du = new DateUtils(date);
        long result = du.getOnlyDateInMillis();
        assertEquals(expectedResult, result);
    }

    /**
     * Test adding to a date 
     */
    @Test
    public void testAddIntInt()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test adding years 
     */
    @Test
    public void testAddYears()
    {
        Calendar calendar = new GregorianCalendar();
        Calendar expectedCalendar = new GregorianCalendar();
        expectedCalendar.add(Calendar.YEAR, 1);
        Date date = calendar.getTime();
        du = new DateUtils(date);
        du.addYears(1);
        // reuse variable
        expectedCalendar = du.getTimeInCalendar();
        assertEquals(expectedCalendar.get(Calendar.YEAR) - 1, calendar.get(Calendar.YEAR));
    }

    /**
     * Test adding months 
     */
    @Test
    public void testAddMonths()
    {
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        du = new DateUtils(date);
        du.addMonths(1);
        
        Calendar expectedCalendar = new GregorianCalendar();
        expectedCalendar.add(Calendar.MONTH, 1);
        // reuse variable
        expectedCalendar = du.getTimeInCalendar();
        
        int expectedMonth = expectedCalendar.get(Calendar.MONTH) - 1;
        int month = calendar.get(Calendar.MONTH);
        // Deal with the case that we are December (array index 11)
        if (month == 11)
        {
            assertEquals(11, month);
        }
        else
        {
            assertEquals(expectedMonth, month);
        }
    }

    /**
     * Test adding days 
     */
    @Test
    public void testAddDays()
    {
        Calendar calendar = new GregorianCalendar();
        Calendar expectedCalendar = new GregorianCalendar();
        expectedCalendar.add(Calendar.DAY_OF_YEAR, 1);
        Date date = calendar.getTime();
        du = new DateUtils(date);
        du.addDays(1);
        // reuse variable
        expectedCalendar = du.getTimeInCalendar();
        assertEquals(expectedCalendar.get(Calendar.DAY_OF_YEAR) - 1, calendar.get(Calendar.DAY_OF_YEAR));
    }

    /**
     * Test resetting the time to 0
     */
    @Test
    public void testResetTime()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date();
        du = new DateUtils(date);
        du.resetTime();
        dateMillis = du.getTimeInMillis();
        assertEquals(calendar.getTime().getTime(), dateMillis);
    }

    /**
     * Test getting the next day with its time set to midnight
     */
    @Test
    public void testGetNextDayMidnightInDate()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test getting the next day in millisec with its time set to midnight
     */
    @Test
    public void testGetNextDayMidnightInMillis()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test isTodayDate
     */
    @Test
    public void testIsTodayDate()
    {
        // fail("Not yet implemented");
    }

    /**
     * Test isTodayDate passing in a millisec date
     */
    @Test
    public void testIsTodayLong()
    {
        // fail("Not yet implemented");
    }

    /**
     * testIsLessThanTodayDate()
     */
    @Test
    public void testIsLessThanTodayDate()
    {
        // fail("Not yet implemented");
    }

    /**
     * testIsLessThanTodayLong()
     */
    @Test
    public void testIsLessThanTodayLong()
    {
        // fail("Not yet implemented");
    }

    /**
     * testIsGreaterThanTodayDate()
     */
    @Test
    public void testIsGreaterThanTodayDate()
    {
        // fail("Not yet implemented");
    }

/*    @Test
    public void testIsGreaterThanTodayLong()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAddStringStringIntInt()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAddDaysToAny()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAddMonthsToAny()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAddYearsToAny()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAnyToAnyLongTimeZoneStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAnyToAnyLongStringStringString()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAnyToAnyLongStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAnyToAnyLongStringString()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testAnyToAnyLongString()
    {
        // fail("Not yet implemented");
    }

    @Test
    public void testNowToAnyStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test nowToAny method
     *//*
    @Test
    public void testNowToAnyStringString()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test nowToAny method
     *//*
    @Test
    public void testNowToAnyString()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToDate method
     *//*
    @Test
    public void testAnyToDate()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToAny method
     *//*
    @Test
    public void testAnyToAnyStringStringTimeZoneStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToAny method
     *//*
    @Test
    public void testAnyToAnyStringStringStringStringString()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToAny method
     *//*
    @Test
    public void testAnyToAnyStringStringStringTimeZone()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToAny method
     *//*
    @Test
    public void testAnyToAnyStringStringStringString()
    {
        // fail("Not yet implemented");
    }

    *//**
     * Test anyToAny method
     *//*
    @Test
    public void testAnyToAnyStringStringString()
    {
        // fail("Not yet implemented");
    }
*/
}