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

class Sin {

	void CalculateSin(double x, double expected) {
		System.out.println(x + "=>" + Math.sin(x));
//		System.out.println(Math.sin(x));
		assertEquals(expected, Trigonometric.Sin(x));
	}
	
	static Stream<Arguments> FourQuadrantsProvider() {
	    return Stream.of(
	    		Arguments.of(Math.PI/4, 0.7071067811865475, "I"), 
	    		Arguments.of(Math.PI/4 * 3, 0.7071067811865476, "II"),
	    		Arguments.of(Math.PI/4 * 5, 0.7071067811865475, "III"),
	    		Arguments.of(Math.PI/4 * 7, -0.7071067811865477, "IV")
	    		);
	}
	
	static Stream<Arguments> EdgesProvider() {
	    return Stream.of(
	    		Arguments.of(0, 0, "0"), 
	    		Arguments.of(Math.PI/2, 1.0, "PI/2"),
	    		Arguments.of(Math.PI, 1.2246467991473532E-16, "PI"),
	    		Arguments.of((Math.PI/2) * 3, -1.0, "3*PI/2"),
	    		Arguments.of(Math.PI * 2, -2.4492935982947064E-16, "2*PI")
	    		);
	}
	
	@ParameterizedTest(name = "test Quadrant {2}")
	@MethodSource("FourQuadrantsProvider")
	void testQuadrantCoverage(double x, double expected, String quadrantName) {
		CalculateSin(x, expected);
	}
	
	@ParameterizedTest(name = "test edge {2}")
	@MethodSource("EdgesProvider")
	void testEdge(double x, double expected, String valueName) {
		CalculateSin(x, expected);
	}
	
}
