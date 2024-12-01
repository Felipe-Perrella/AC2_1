package ac2_project.example.ac2_ca.entity.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ac2_project.example.ac2_ca.entity.*;


public class PremioTest {
	
	 @Test
	    void testRecebeVoucher() {
	        Premio premio = new Premio();
	        Premio_Voucher voucher = new Premio_Voucher(2);
	        premio.setVouchers(voucher);
	        
	        assertEquals(2, premio.getQntVouchers());

	        premio.getVoucher().recebeVoucher(3);
	        assertEquals(5, premio.getQntVouchers());
	    }

	    @Test
	    void testGastaVoucher() {
	        Premio premio = new Premio();
	        Premio_Voucher voucher = new Premio_Voucher(5);
	        premio.setVouchers(voucher);
	        
	        assertEquals(5, premio.getQntVouchers());

	        premio.getVoucher().gastaVoucher(2);
	        assertEquals(3, premio.getQntVouchers());
	    }

	    @Test
	    void testGastaVoucherSemVouchersDisponiveis() {
	        Premio premio = new Premio();
	        Premio_Voucher voucher = new Premio_Voucher(0);
	        premio.setVouchers(voucher);
	        
	        assertEquals(0, premio.getQntVouchers());

	        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> premio.getVoucher().gastaVoucher(1));
	        assertEquals("Você não tem Vouchers!", exception.getMessage());
	    }

	    @Test
	    void testGastaVoucherComQuantidadeExata() {
	        Premio premio = new Premio();
	        Premio_Voucher voucher = new Premio_Voucher(3);
	        premio.setVouchers(voucher);
	        
	        assertEquals(3, premio.getQntVouchers());

	        premio.getVoucher().gastaVoucher(3);
	        assertEquals(0, premio.getQntVouchers());
	    }

	    @Test
	    void testEqualsComMesmoObjeto() {
	        Premio_Voucher voucher = new Premio_Voucher(5);
	        assertTrue(voucher.equals(voucher));
	    }

	    @Test
	    void testEqualsComObjetosIguais() {
	        Premio_Voucher voucher1 = new Premio_Voucher(5);
	        Premio_Voucher voucher2 = new Premio_Voucher(5);
	        assertTrue(voucher1.equals(voucher2));
	        assertEquals(voucher1.hashCode(), voucher2.hashCode());
	    }

	    @Test
	    void testEqualsComObjetosDiferentes() {
	        Premio_Voucher voucher1 = new Premio_Voucher(5);
	        Premio_Voucher voucher2 = new Premio_Voucher(3);
	        assertFalse(voucher1.equals(voucher2));
	    }
}
