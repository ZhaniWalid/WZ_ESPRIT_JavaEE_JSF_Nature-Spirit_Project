package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
 

@Entity
@XmlRootElement
public class MemberNews implements Serializable{
	@EmbeddedId
	private MemberNewsId memberNewsId;
	private String Comment;
	private int State_News; //State_News = 0 => Bad News / State_News = 1 => Good News
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name = "Id_Member", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member member;

	
	@ManyToOne
	@JoinColumn(name = "Id_News", referencedColumnName = "idNews", updatable = false, insertable = false)
	private News news;

	public MemberNews(String Comment, Member member, News news) {
		super();
		this.Comment = Comment;
		this.member = member;
		this.news = news;
		this.State_News=0;
		this.memberNewsId= new MemberNewsId(member.getId_Member(),news.getIdNews());
	}

	public MemberNews(String Comment, int State_News, Member member, News news) {
		super();
		this.Comment = Comment;
		this.State_News = State_News;
		this.member = member; 
		this.news = news;
	}

	public MemberNewsId getMemberNewsId() {
		return memberNewsId;
	}

	public void setMemberNewsId(MemberNewsId memberNewsId) {
		this.memberNewsId = memberNewsId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public int getState_News() {
		return State_News;
	}

	public void setState_News(int state_News) {
		State_News = state_News;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comment == null) ? 0 : Comment.hashCode());
		result = prime * result + State_News;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberNews other = (MemberNews) obj;
		if (Comment == null) {
			if (other.Comment != null)
				return false;
		} else if (!Comment.equals(other.Comment))
			return false;
		if (State_News != other.State_News)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberNews [Comment=" + Comment + ", State_News=" + State_News + ", member=" + member + ", news=" + news
				+ "]";
	}  
		
}
