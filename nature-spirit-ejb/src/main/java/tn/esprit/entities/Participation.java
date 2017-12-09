package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Agenda
 *
 */
@Entity
@XmlRootElement
public class Participation implements Serializable {

	@EmbeddedId
	private ParticipationId participationId;
	private String opinions;
	private Integer evaluation;

	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "Id_Member", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member member;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "Id_Event", referencedColumnName = "id_Event", updatable = false, insertable = false)
	private Event event;

	private static final long serialVersionUID = 1L;

	public Participation() {
		super();
	}

	public Participation(String opinions, Integer evaluation, Member member, Event event) {

		this.participationId = new ParticipationId(member.getId_Member(), event.getId_Event(), event.getDate_Event());
		this.opinions = opinions;
		this.evaluation = evaluation;
		this.member = member;
		this.event = event;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ParticipationId getParticipationId() {
		return participationId;
	}

	public void setParticipationId(ParticipationId participationId) {
		this.participationId = participationId;
	}

	public String getOpinions() {
		return opinions;
	}

	public void setOpinions(String opinions) {
		this.opinions = opinions;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

}
