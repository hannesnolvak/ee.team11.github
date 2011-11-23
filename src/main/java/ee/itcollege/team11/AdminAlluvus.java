package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;


/**
 * The persistent class for the ADMIN_ALLUVUS database table.
 * 
 */

@RooToString
@RooEntity
@Table(name="ADMIN_ALLUVUS")
public class AdminAlluvus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ALLUVUS_ID")
	private int adminAlluvusId;

	private String alates;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String kommentaar;

	private String kuni;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="ALLUV_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus1;

	//bi-directional many-to-one association to RiigiAdminYksus
    @ManyToOne
	@JoinColumn(name="YLEMUS_YKSUS_ID")
	private RiigiAdminYksus riigiAdminYksus2;

    public AdminAlluvus() {
    }

	public int getAdminAlluvusId() {
		return this.adminAlluvusId;
	}

	public void setAdminAlluvusId(int adminAlluvusId) {
		this.adminAlluvusId = adminAlluvusId;
	}

	public String getAlates() {
		return this.alates;
	}

	public void setAlates(String alates) {
		this.alates = alates;
	}

	public String getAvaja() {
		return this.avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Date getAvatud() {
		return this.avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getKuni() {
		return this.kuni;
	}

	public void setKuni(String kuni) {
		this.kuni = kuni;
	}

	public Date getMuudetud() {
		return this.muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return this.muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public Date getSuletud() {
		return this.suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

	public String getSulgeja() {
		return this.sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public RiigiAdminYksus getRiigiAdminYksus1() {
		return this.riigiAdminYksus1;
	}

	public void setRiigiAdminYksus1(RiigiAdminYksus riigiAdminYksus1) {
		this.riigiAdminYksus1 = riigiAdminYksus1;
	}
	
	public RiigiAdminYksus getRiigiAdminYksus2() {
		return this.riigiAdminYksus2;
	}

	public void setRiigiAdminYksus2(RiigiAdminYksus riigiAdminYksus2) {
		this.riigiAdminYksus2 = riigiAdminYksus2;
	}
	
}