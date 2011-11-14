package br.com.caelum.tdd.exercise6;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.tdd.exercise6.Candle;
import br.com.caelum.tdd.exercise6.MaximumIndicator;

public class MaximumIndicatorTests {

	@Test
	public void shouldReturnTheMaximumCandleValue() {
		double amount = new MaximumIndicator().calculate(1, Arrays.asList(
				candleWithMaximum(10.0), candleWithMaximum(12.0),
				candleWithMaximum(11.0)));

		assertEquals(12.0, amount, 0.00001);

	}

	private Candle candleWithMaximum(double maximum) {
		return new Candle(0, 0, 0, maximum, Calendar.getInstance());
	}
}
