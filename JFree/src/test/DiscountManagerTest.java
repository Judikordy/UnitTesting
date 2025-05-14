package test;
import JFree.DiscountCalculator;
import JFree.DiscountManager;
import JFree.IDiscountCalculator;
import org.jfree.data.time.Week;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import static org.junit.Assert.*;

// 1- discountseasonFALSE **
// 2- discountseasonTRUEANDSpecialWeekTRUE return price * 0.8   **
// 3- discountseasonTRUEANDSpecialWeekFALSEANDgetdiscountpercentageISEVEN   **
// 4- discountseasonTRUEANDSpecialWeekFALSEANDgetdiscountpercentageISODD    **

public class DiscountManagerTest {

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsFalse() throws Exception {
        // Arrange
        boolean isDiscountsSeason = false;
        double originalPrice = 100.0;
        double expectedPrice = 100.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {

                // make sure that none of the functions are called
            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act
        double calculate = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice,calculate,0.1);
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
    }

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsTrue() throws Exception {
        // Arrange
        DiscountCalculator discountCalculator = new DiscountCalculator(new Week());
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = originalPrice * 0.8;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                allowing(mockedDependency).isTheSpecialWeek();
                will(returnValue(true));
                // make sure that none of the functions are called
            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act
        double calculate = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice,calculate,0.1);
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
    }

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsFalseAndGetDiscountPercentageIsEven() throws Exception {
        // Arrange
        DiscountCalculator discountCalculator = new DiscountCalculator(new Week());
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = originalPrice * 0.93;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                allowing(mockedDependency).isTheSpecialWeek();
                will(returnValue(false));
                allowing(mockedDependency).getDiscountPercentage();
                will(returnValue(7));
                // make sure that none of the functions are called
            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act
        double calculate = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice,calculate,0.1);
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
    }

    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsFalseAndGetDiscountPercentageIsOdd() throws Exception {
        // Arrange
        DiscountCalculator discountCalculator = new DiscountCalculator(new Week());
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = originalPrice * 0.95;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                allowing(mockedDependency).isTheSpecialWeek();
                will(returnValue(false));
                allowing(mockedDependency).getDiscountPercentage();
                will(returnValue(5));
                // make sure that none of the functions are called
            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act
        double calculate = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        mockingContext.assertIsSatisfied();
        assertEquals(expectedPrice,calculate,0.1);
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
    }
}
