package test;

import calculator.Trigonometric;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
//import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameter;

class Sin {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
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
	
	@ParameterizedTest(name = "test Quadrant {2}")
	@MethodSource("FourQuadrantsProvider")
	void testQuadrantsCoverage(double x, double expected, String quadrantName) {
		CalculateSin(x, expected);
	}
	
	static Stream<Arguments> EdgesProvider() {
	    return Stream.of(
	    		Arguments.of(0, 0, "0"), 
	    		Arguments.of(Math.PI/2, 1.0, "PI/2"),
	    		Arguments.of(Math.PI, 0, "PI"),
	    		Arguments.of((Math.PI/2) * 3, -1.0, "3*PI/2"),
	    		Arguments.of(Math.PI * 2, -1.0, "2*PI")
	    		);
	}
	
	@ParameterizedTest(name = "test edge {2}")
	@MethodSource("EdgesProvider")
	void testEdge(double x, double expected, String valueName) {
		CalculateSin(x, expected);
	}
	
}
