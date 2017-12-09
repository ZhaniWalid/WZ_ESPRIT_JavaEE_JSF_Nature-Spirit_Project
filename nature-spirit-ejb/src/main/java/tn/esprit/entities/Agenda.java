package tn.esprit.entities;

import java.io.Serializable;

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
public class Agenda implements Serializable {

	@EmbeddedId
	private AgendaId agendaId;

	
	@ManyToOne
	@JoinColumn(name = "Id_Member", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member member;
	
	
	@ManyToOne
	@JoinColumn(name = "Id_Event", referencedColumnName = "id_Event", updatable = false, insertable = false)
	private Event event;

	private static final long serialVersionUID = 1L;

	public Agenda() {
		super();
	}

	public Agenda(Member member, Event event) {
		super();
		this.member = member;
		this.event = event;
		this.agendaId = new AgendaId(member.getId_Member(), event.getId_Event());

	}

	public AgendaId getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(AgendaId agendaId) {
		this.agendaId = agendaId;
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

}
