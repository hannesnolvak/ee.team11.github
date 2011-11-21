package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the RIIK database table.
 * 
 */
@Entity
public class Riik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RIIK_ID")
	private int riikId;

	@Column(name="ANSI_KOOD")
	private String ansiKood;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	@Column(name="ISO_KOOD")
	private String isoKood;

	private String kommentaar;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

	//bi-directional many-to-one association to Kodakondsus
	@OneToMany(mappedBy="riik")
	private Set<Kodakondsus> kodakondsuses;

    public Riik() {
    }

	public int getRiikId() {
		return this.riikId;
	}

	public void setRiikId(int riikId) {
		this.riikId = riikId;
	}

	public String getAnsiKood() {
		return this.ansiKood;
	}

	public void setAnsiKood(String ansiKood) {
		this.ansiKood = ansiKood;
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

	public String getIsoKood() {
		return this.isoKood;
	}

	public void setIsoKood(String isoKood) {
		this.isoKood = isoKood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
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

	public Set<Kodakondsus> getKodakondsuses() {
		return this.kodakondsuses;
	}

	public void setKodakondsuses(Set<Kodakondsus> kodakondsuses) {
		this.kodakondsuses = kodakondsuses;
	}
	
}