package ac2_project.example.ac2_ca.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_Premio")
public class Premio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Embedded
	private Premio_Voucher voucher;
	
	public void setVouchers(Premio_Voucher voucher) {
        this.voucher = voucher;
    }
	
	public Premio_Voucher getQntVouchers() {
        return voucher;
    }
	
}
