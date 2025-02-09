                                                    # Fractions

Simple solutions for working with fractions in Java.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven or Gradle (depending on your build system preference)

### Installing

1. Clone the repository:
   ```bash
   git clone https://github.com/justinburgess/fractions.git
   cd fractions

2. Build the project using Maven:
   ```bash
   mvn clean install
   
3. Run the tests to ensure everything is set up correctly:
    ```bash
   mvn test
   
4. Or test with Gradle:
   ```bash
   gradle test

## Usage

Example of how to use the library:

    import com.example.fractions.Fraction;
    
    public class Main {
        public static void main(String[] args) {
            Fraction fraction1 = new Fraction(1, 2); // 1/2
            Fraction fraction2 = new Fraction(3, 4); // 3/4
            Fraction result = fraction1.add(fraction2);
            System.out.println(result); // Prints the result of 1/2 + 3/4
        }
    }

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements
* Me
* Myself
* I