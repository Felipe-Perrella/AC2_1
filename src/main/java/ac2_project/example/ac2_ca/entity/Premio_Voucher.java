package ac2_project.example.ac2_ca.entity;	
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Premio_Voucher {
    private int qtdVoucher;
    // Construtor padrão necessário para o JPA
    protected Premio_Voucher() {}
    
    public Premio_Voucher(int vouchers) {
    	this.qtdVoucher = vouchers;
    }

    public void recebeVoucher(Integer qtdVoucher) {
    	this.qtdVoucher = getQtdVoucher() + qtdVoucher;
    }

    public int getQtdVoucher() {
        return qtdVoucher;
    }
    
    public void gastaVoucher(Integer qtdVoucher) {
    	if (this.qtdVoucher < 1) {
    		throw new IllegalArgumentException("Você não tem Vouchers!");
    	}
    	this.qtdVoucher = this.qtdVoucher - qtdVoucher;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premio_Voucher voucher = (Premio_Voucher) o;
        return Objects.equals(qtdVoucher, voucher.qtdVoucher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtdVoucher);
    }
	
}