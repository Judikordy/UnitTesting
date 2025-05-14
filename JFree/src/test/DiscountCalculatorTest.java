package test;

import JFree.DiscountCalculator;
import org.jfree.data.time.Week;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DiscountCalculatorTest {

    DiscountCalculator discountCalculator;

    @Test
    public void testIsTheSpecialWeekWhenFalse() throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 22);  // March 22, 2025
        Date date = calendar.getTime();
        Week week = new Week(date);
        // Arrange

        discountCalculator = new DiscountCalculator(week);

        // Act
        boolean isSpecial = discountCalculator.isTheSpecialWeek();

        // Assert
        assertFalse(isSpecial);
    }

    @Test
    public void testIsTheSpecialWeekWhenTrue() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 23);  // June 23, 2025
        Date date = calendar.getTime();
        Week week = new Week(date);

        // Arrange
        discountCalculator = new DiscountCalculator(week);

        // Act
        boolean isSpecial = discountCalculator.isTheSpecialWeek();

        // Assert
        assertTrue(isSpecial);
    }
    // Test missing cases ( JUNE, 23 is a date in week 26 )

    @Test
    public void testGetDiscountPercentageWhenEven() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 22);  // March 22, 2025
        Date date = calendar.getTime();
        Week week = new Week(date);

        // Arrange
        discountCalculator = new DiscountCalculator(week);
        int expected = 7;

        //Act
        int actual = discountCalculator.getDiscountPercentage();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDiscountPercentageWhenOdd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 23);  // March 23, 2025
        Date date = calendar.getTime();
        Week week = new Week(date);

        // Arrange
        discountCalculator = new DiscountCalculator(week);
        int expected = 5;

        // Act
        int actual = discountCalculator.getDiscountPercentage();

        // Asser
        assertEquals(expected, actual);
    }
}
