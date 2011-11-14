import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.tdd.exercise7.Invoice;
import br.com.caelum.tdd.exercise7.InvoiceFilter;
import br.com.caelum.tdd.exercise7.State;


public class InvoiceFilterTests {

	@Test
	public void shouldRemoveInvoicesLessThan2000() {
		Invoice nf1 = new Invoice(200.0, Calendar.getInstance(), State.CA);
		Invoice nf2 = new Invoice(3200.0, Calendar.getInstance(), State.NY);
		
		List<Invoice> testList = Arrays.asList(nf1, nf2);
		
		List<Invoice> filteredList = new InvoiceFilter().filter(testList);
		
		assertEquals(1, filteredList.size());
		assertEquals(nf2, filteredList.get(0));
	}

	@Test
	public void shouldRemoveInvoicesBetween2000And2500AndWereCreateBeforeThanAMonth() {
		Calendar twoMonthsAgo = Calendar.getInstance();
		twoMonthsAgo.add(Calendar.MONTH, -2);
		Invoice nf1 = new Invoice(2200.0, twoMonthsAgo, State.CA);
		Invoice nf2 = new Invoice(2200.0, Calendar.getInstance(), State.NY);
		
		List<Invoice> testList = Arrays.asList(nf1, nf2);
		
		List<Invoice> filteredList = new InvoiceFilter().filter(testList);
		
		assertEquals(1, filteredList.size());
		assertEquals(nf2, filteredList.get(0));
	}
	
}
