package test;

import calculator.Trigonometric;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Tan {

	void Calculate(double x, double expected) {
		System.out.println(x + "=>" + Math.tan(x));
		assertEquals(expected, Trigonometric.Tan(x));
	}
	
	static Stream<Arguments> FourQuadrantsProvider() {
	    return Stream.of(
	    		Arguments.of(Math.PI/4, 1, "I"), 
	    		Arguments.of(Math.PI/4 * 3, -1, "II"),
	    		Arguments.of(Math.PI/4 * 5, 1, "III"),
	    		Arguments.of(Math.PI/4 * 7, -1, "IV")
	    		);
	}
	
	static Stream<Arguments> EdgesProvider() {
	    return Stream.of(
	    		Arguments.of(0, 0, "0"), 
//	    		Arguments.of(Math.PI/2, 6.123233995736766E-17, "PI/2"),
	    		Arguments.of(Math.PI, 0, "PI"),
//	    		Arguments.of((Math.PI/2) * 3, -1.8369701987210297E-16, "3*PI/2"),
	    		Arguments.of(Math.PI * 2, 0, "2*PI")
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
