package test;
import JFree.DiscountCalculator;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;
import org.junit.Test;
import java.time.MonthDay;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class YearTest {
    test.Year year;

    private void arrange() {
        year = new test.Year();
    }
    @Test
    public void testYearDefaultCtor() {
        arrange();
        assertEquals(2025, year.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYearRangeShouldBeInvalid() throws Exception{
        Year year = new Year(1850);
        assertEquals(1850,year.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYearRangeGreaterThan9999() throws Exception{
        Year year = new Year(10234);

        assertEquals(10234,year.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYearRangeLessThanNegative9999() throws Exception{
        Year year = new Year(-10234);

        assertEquals(-10234,year.getYear());
    }

    @Test
    public void testYearRangeEqualTo9999() throws Exception{
        Year year = new Year(9999);

        assertEquals(9999,year.getYear());
    }

    @Test
    public void testYearTimeCtor(){
        // Arrange
        Date date = new Date();
        Year year = new Year();
        int expectedYear = year.getYear();
        long expectedTime = date.getTime();

        // Assert
        assertEquals(expectedYear,year.getYear());
        assertEquals(expectedTime,date.getTime());
    }

    @Test
    public void testYearTimeAndTimeZoneCtor(){
        // Arrange
        Year year = new Year();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int expectedYear = year.getYear();
        Date expectedTime = calendar.getTime();
        TimeZone expectedTimeZone = calendar.getTimeZone();

        // Assert
        assertEquals(expectedYear,year.getYear());
        assertEquals(expectedTime,calendar.getTime());
        assertEquals(expectedTimeZone,calendar.getTimeZone());
    }

    @Test
    public void testYearTimeAndCalendarCtor(){
        // Arrange
        Year year = new Year();
        Calendar calendar = Calendar.getInstance();
        int expectedYear = year.getYear();
        Date expectedTime = calendar.getTime();

        // Assert
        assertEquals(expectedYear,year.getYear());
        assertEquals(expectedTime,calendar.getTime());
    }

    @Test
    public void testGetYear(){
        Year year = new Year();
        year.getYear();
        assertEquals(2025,year.getYear());
    }

    @Test
    public void testGetFirstMilliSecond(){
        Year year = new Year();
        long expected = year.getFirstMillisecond();
        long actual = year.getFirstMillisecond();
        assertEquals(expected,actual);


    }

    @Test
    public void testGetLastMillisecond(){
        Year year = new Year();
        long expected = year.getLastMillisecond();
        long actual = year.getLastMillisecond();
        assertEquals(expected,actual);
    }

    @Test
    public void testPreviousShouldBeInvalid(){

        // Arrange
        Year year = new Year(1900);
        // Act
        RegularTimePeriod actual = year.previous();
        // Assert
        assertEquals(null,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreviousIsInvalid(){

        // Arrange
        Year year = new Year(-12741);

        // Act
        RegularTimePeriod actual = year.previous();

        // Assert
        assertEquals(null,actual);
    }

    @Test
    public void testPreviousIsValid() {
        // Arrange
        Year year = new Year(1905);

        // Act
        RegularTimePeriod actual = year.previous();

        // Assert
        assertEquals(1904, ((Year) actual).getYear());
    }

    @Test
    public void testNextIsInvalid(){

        // Arrange
        Year year = new Year(9999);

        // Act
        RegularTimePeriod actual = year.next();

        // Assert
        assertEquals(null,actual);
    }

    @Test
    public void testNextShouldBeInvalid(){

        // Arrange
        Year year = new Year(-4399);

        // Act
        RegularTimePeriod actual = year.next();

        // Assert
        assertEquals(null,actual);
    }

    @Test
    public void testNextIsValid(){

        // Arrange
        Year year = new Year(5374);

        // Act
        RegularTimePeriod actual = year.next();

        // Assert
        assertEquals(5375, ((Year) actual).getYear());
    }

    @Test
    public void testGetSerialIndex(){
        Year year = new Year();
        long expected = 2025;
        long actual = year.getSerialIndex();
        assertEquals(expected,actual);

    }

    @Test(timeout = 100)
    public void testGetFirstMillisecondOfCalendar(){
        // Arrange
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1905, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND,0);
        Year year = new Year();

        // Act

        Calendar expectedCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expectedCalendar.set(1905, Calendar.JANUARY, 1, 0, 0, 0);
        long expected = expectedCalendar.getTimeInMillis();
        long actual = year.getFirstMillisecond(calendar);

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testGetLastMillisecondOfCalendar(){
        // Arrange
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1905, Calendar.DECEMBER, 31, 23, 59, 59);
        calendar.set(Calendar.MILLISECOND,999);
        Year year = new Year();

        // Act
        Calendar expectedCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        expectedCalendar.set(1905, Calendar.DECEMBER, 31, 23, 59, 59);
        expectedCalendar.set(Calendar.MILLISECOND,999);
        long expected = expectedCalendar.getTimeInMillis();
        long actual = year.getLastMillisecond(calendar);

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsIsTrue(){
        Year year1 = new Year(1933);
        Year year2 = new Year(1933);
        assertEquals(year1,year2);

    }

    @Test
    public void testEqualsIsFalse(){
        Year year1 = new Year(1933);
        Year year2 = new Year(1915);
        assertNotEquals(year1,year2);

    }

    @Test
    public void testHashCodeIsValid(){
        Year year = new Year(1973);
        int expected = 2602;
        int actual = year.hashCode();
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareToWhenYearIsBefore(){
        Year y = new Year(1932);
        Year o1 = new Year();
        int expected = -93;
        int actual = y.compareTo(o1);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareToWhenYearIsSame(){
        Year y = new Year(2025);
        Year o1 = new Year();
        int expected = 0;
        int actual = y.compareTo(o1);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareToWhenYearIsAfter(){
        Year y = new Year(2055);
        Year o1 = new Year();
        int expected = 30;
        int actual = y.compareTo(o1);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareToWhenO1OfTypeInt(){
        Year y = new Year(2055);
        int o1 = y.getYear();
        int expected = 1;
        int actual = y.compareTo(o1);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareToWhenO1OfTypeRegularTimePeriod(){
        Year y = new Year(2055);
        RegularTimePeriod o1 = new Year(2055);
        int expected = 0;
        int actual = y.compareTo(o1);
        assertEquals(expected,actual);
    }

    @Test
    public void testToString(){
        Year year = new Year(1920);
        String string = "1920";
        String yearString = year.toString();
        assertEquals(string,yearString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseYearCannotBeParsed(){
        String invalidString = "w2e1";
        Year year = Year.parseYear(invalidString);
        assertEquals(null,year);
    }

    @Test
    public void testParseYearIsValid(){
        String validString = "1999";
        Year year = Year.parseYear(validString);
        int expected = 1999;

        assertEquals(expected,year.getYear());
    }

    @Test
    public void testParseYearShouldBeInValid(){
        String invalidString = "823";
        Year year = Year.parseYear(invalidString);

        assertEquals(null,year.getYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseYearIsOutOfRange(){
        String invalidString = "-11023";
        Year year = Year.parseYear(invalidString);

        assertNull(year.getYear());
    }
}
