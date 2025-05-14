
# JFreeChart Testing Project

## Overview

This project contains a set of test cases designed to validate the functionality of the JFreeChart framework and related classes. The tests cover essential classes like `Year`, `DiscountCalculator`, and `DiscountManager`, ensuring their correctness and stability. The project includes IntelliJ setup, necessary JAR files, and modified JavaDocs for the JFreeChart application.

## Project Structure

- **JFreeChart Test Files**  
  The project includes three test files that test different classes and their methods:
  1. `YearTest.java`: Tests the `org.jfree.data.time.Year` class (all constructors and methods).
  2. `DiscountCalculatorTest.java`: Tests the methods of the `DiscountCalculator` class.
  3. `DiscountManagerTest.java`: Tests the `DiscountManager` class functions without dependencies on other classes.

- **Libraries**  
  Includes the necessary JAR files for the JFreeChart library for compiling and testing.

- **Modified JavaDocs**  
  A zip file containing the JavaDocs for the JFreeChart application and documentation for the `DiscountCalculator` and `DiscountManagerTest` classes.

## Prerequisites

Before you begin, ensure that you have the following installed:

- Java Development Kit (JDK) 8 or higher.
- IntelliJ IDEA (or any Java IDE).
- Required JAR files for JFreeChart (included in the project).

## Testing Results

The test files are designed to evaluate the functionality of specific methods and features in the JFreeChart framework and related classes. The results are summarized below:

- **YearTest**: Validates all constructors and methods of `org.jfree.data.time.Year`.
- **DiscountCalculatorTest**: Tests all methods in the `DiscountCalculator` class.
- **DiscountManagerTest**: Tests the `DiscountManager` class functions independently.

## Bugs Report

A comprehensive bugs report should be submitted along with the following details:

1. **Method to be tested**: Name of the method and class.
2. **Test Cases**: Specific cases tested.
3. **Test Status**: Mark each test as "Passed" or "Failed".
4. **Notes**: Any additional observations or bug reports.

## Example Bugs Report Template

| Method | Test Case | Status  | Notes           |
|--------|-----------|---------|-----------------|
| `Year.getYear()` | Valid Year | Passed  | -               |
| `DiscountCalculator.calculate()` | Negative Discount | Failed  | Incorrect discount calculation with negative value. |

## Documentation

The modified JavaDocs zip file includes:

- **JFreeChart documentation**: Information on how to use the JFreeChart framework.
- **DiscountCalculator & DiscountManager**: Documentation for these two classes, detailing their methods and usage.

## License

This project is open-source and licensed under the MIT License.
