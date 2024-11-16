package ac2_project.example.ac2_ca.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.*;


public class PremioTest {
	
	 	@Test
	    void testRecebeVoucher() {
	        Premio premio = new Premio();
	        Premio_Voucher voucher = new Premio_Voucher(2);
	        premio.setVouchers(voucher);
	        assertEquals(2, premio.getQntVouchers().getQtdVoucher());
	        
	        premio.getQntVouchers().recebeVoucher(3);
	        assertEquals(5, premio.getQntVouchers().getQtdVoucher());
	       
	    }
}
