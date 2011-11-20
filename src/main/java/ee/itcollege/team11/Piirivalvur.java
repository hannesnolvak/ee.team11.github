package ee.itcollege.team11;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PIIRIVALVUR database table.
 * 
 */
@Entity
public class Piirivalvur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PIIRIVALVUR_ID")
	private int piirivalvurId;

	private String avaja;

    @Temporal( TemporalType.DATE)
	private Date avatud;

	private String eesnimed;

	private String isikukood;

    @Temporal( TemporalType.DATE)
	private Date muudetud;

	private String muutja;

	private String perekonnanimi;

	@Column(name="SODURI_KOOD")
	private String soduriKood;

	private String sugu;

    @Temporal( TemporalType.DATE)
	private Date suletud;

	private String sulgeja;

    public Piirivalvur() {
    }

	public int getPiirivalvurId() {
		return this.piirivalvurId;
	}

	public void setPiirivalvurId(int piirivalvurId) {
		this.piirivalvurId = piirivalvurId;
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

	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
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

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSoduriKood() {
		return this.soduriKood;
	}

	public void setSoduriKood(String soduriKood) {
		this.soduriKood = soduriKood;
	}

	public String getSugu() {
		return this.sugu;
	}

	public void setSugu(String sugu) {
		this.sugu = sugu;
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

}