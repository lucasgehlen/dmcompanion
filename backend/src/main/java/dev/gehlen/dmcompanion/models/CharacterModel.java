package dev.gehlen.dmcompanion.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_CHARACTER")
public class CharacterModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private UUID id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private UserModel user;

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public UserModel getUser()
	{
		return user;
	}

	public void setUser(UserModel user)
	{
		this.user = user;
	}
}
