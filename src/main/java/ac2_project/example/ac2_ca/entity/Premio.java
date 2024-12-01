package ac2_project.example.ac2_ca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_Premio")
@Getter
@Setter

public class Premio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Embedded
	private Premio_Voucher voucher;
	
	public void setVouchers(Premio_Voucher voucher) {
        this.voucher = voucher;
    }
	
	public int getQntVouchers() {
		return this.voucher != null ? this.voucher.getQtdVoucher() : 0;
    }
	
}
