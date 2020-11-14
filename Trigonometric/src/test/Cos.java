package test;

import calculator.Trigonometric;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameter;

class Cos {

	void Calculate(double x, double expected) {
		System.out.println(x + "=>" + Math.cos(x));
		assertEquals(expected, Trigonometric.Cos(x));
	}
	
	static Stream<Arguments> FourQuadrantsProvider() {
	    return Stream.of(
	    		Arguments.of(Math.PI/4, 0.7071067811865476, "I"), 
	    		Arguments.of(Math.PI/4 * 3, 0.7071067811865475, "II"),
	    		Arguments.of(Math.PI/4 * 5, -0.7071067811865477, "III"),
	    		Arguments.of(Math.PI/4 * 7, 0.7071067811865474, "IV")
	    		);
	}
	
	static Stream<Arguments> EdgesProvider() {
	    return Stream.of(
	    		Arguments.of(0, 1, "0"), 
	    		Arguments.of(Math.PI/2, 6.123233995736766E-17, "PI/2"),
	    		Arguments.of(Math.PI, -1, "PI"),
	    		Arguments.of((Math.PI/2) * 3, -1.8369701987210297E-16, "3*PI/2"),
	    		Arguments.of(Math.PI * 2, 1.0, "2*PI")
	    		);
	}
	
	@ParameterizedTest(name = "test Quadrant {2}")
	@MethodSource("FourQuadrantsProvider")
	void testQuadrantCoverage(double x, double expected, String quadrantName) {
		Calculate(x, expected);
	}
	
	@ParameterizedTest(name = "test edge {2}")
	@MethodSource("EdgesProvider")
	void testEdge(double x, double expected, String valueName) {
		Calculate(x, expected);
	}
	
}
