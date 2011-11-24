package ee.itcollege.team11;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * The persistent class for the INTSIDENT database table.
 * 
 */
@Entity
@RooToString
@RooEntity
public class Intsident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INTSIDENT_ID")
	private Long intsidentId;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	@Column(name="GPS_LATITUUD")
	private BigDecimal gpsLatituud;

	@Column(name="GPS_LONGITUUD")
	private BigDecimal gpsLongituud;

	private String kirjeldus;

	private String kommentaar;

	private String kood;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String nimetus;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

    @Temporal( TemporalType.DATE)
	@Column(name="TOIMUMISE_ALGUS")
	private Date toimumiseAlgus;

    @Temporal( TemporalType.DATE)
	@Column(name="TOIMUMISE_LOPP")
	private Date toimumiseLopp;

	//bi-directional many-to-one association to IntsidendiLiik
    @ManyToOne
	@JoinColumn(name="INTSIDENDI_LIIK_ID")
	private IntsidendiLiik intsidendiLiik;

	//bi-directional many-to-one association to Piiriloik
    @ManyToOne
	@JoinColumn(name="PIIRILOIK_ID")
	private Piiriloik piiriloik;

	//bi-directional many-to-one association to IsikIntsidendi
	@OneToMany(mappedBy="intsident")
	private Set<IsikIntsidendi> isikIntsidendis;

	//bi-directional many-to-one association to ObjektIntsidendi
	@OneToMany(mappedBy="intsident")
	private Set<ObjektIntsidendi> objektIntsidendis;

	//bi-directional many-to-one association to PiirivalvurIntsidendi
	@OneToMany(mappedBy="intsident")
	private Set<PiirivalvurIntsidendi> piirivalvurIntsidendis;

	//bi-directional many-to-one association to VahtkondIntsidendi
	@OneToMany(mappedBy="intsident")
	private Set<VahtkondIntsidendi> vahtkondIntsidendis;

    public Intsident() {
    }

	public Long getIntsidentId() {
		return this.intsidentId;
	}

	public void setIntsidentId(Long intsidentId) {
		this.intsidentId = intsidentId;
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

	public BigDecimal getGpsLatituud() {
		return this.gpsLatituud;
	}

	public void setGpsLatituud(BigDecimal gpsLatituud) {
		this.gpsLatituud = gpsLatituud;
	}

	public BigDecimal getGpsLongituud() {
		return this.gpsLongituud;
	}

	public void setGpsLongituud(BigDecimal gpsLongituud) {
		this.gpsLongituud = gpsLongituud;
	}

	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
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

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
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

	public Date getToimumiseAlgus() {
		return this.toimumiseAlgus;
	}

	public void setToimumiseAlgus(Date toimumiseAlgus) {
		this.toimumiseAlgus = toimumiseAlgus;
	}

	public Date getToimumiseLopp() {
		return this.toimumiseLopp;
	}

	public void setToimumiseLopp(Date toimumiseLopp) {
		this.toimumiseLopp = toimumiseLopp;
	}

	public IntsidendiLiik getIntsidendiLiik() {
		return this.intsidendiLiik;
	}

	public void setIntsidendiLiik(IntsidendiLiik intsidendiLiik) {
		this.intsidendiLiik = intsidendiLiik;
	}
	
	public Piiriloik getPiiriloik() {
		return this.piiriloik;
	}

	public void setPiiriloik(Piiriloik piiriloik) {
		this.piiriloik = piiriloik;
	}
	
	public Set<IsikIntsidendi> getIsikIntsidendis() {
		return this.isikIntsidendis;
	}

	public void setIsikIntsidendis(Set<IsikIntsidendi> isikIntsidendis) {
		this.isikIntsidendis = isikIntsidendis;
	}
	
	public Set<ObjektIntsidendi> getObjektIntsidendis() {
		return this.objektIntsidendis;
	}

	public void setObjektIntsidendis(Set<ObjektIntsidendi> objektIntsidendis) {
		this.objektIntsidendis = objektIntsidendis;
	}
	
	public Set<PiirivalvurIntsidendi> getPiirivalvurIntsidendis() {
		return this.piirivalvurIntsidendis;
	}

	public void setPiirivalvurIntsidendis(Set<PiirivalvurIntsidendi> piirivalvurIntsidendis) {
		this.piirivalvurIntsidendis = piirivalvurIntsidendis;
	}
	
	public Set<VahtkondIntsidendi> getVahtkondIntsidendis() {
		return this.vahtkondIntsidendis;
	}

	public void setVahtkondIntsidendis(Set<VahtkondIntsidendi> vahtkondIntsidendis) {
		this.vahtkondIntsidendis = vahtkondIntsidendis;
	}
	
}