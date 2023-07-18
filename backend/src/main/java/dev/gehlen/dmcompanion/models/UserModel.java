package dev.gehlen.dmcompanion.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String nickname;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@OneToMany(mappedBy = "user")
	private List<CharacterModel> characters;
	@OneToMany(mappedBy = "master")
	private List<CampaignModel> masteredCampaigns;
	@ManyToMany(mappedBy = "players")
	private List<CampaignModel> playedCampaigns;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "TB_USER_FRIED",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "friend_id") }
	)
	private List<UserModel> friends;

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public List<CharacterModel> getCharacters()
	{
		return characters;
	}

	public void setCharacters(List<CharacterModel> characters)
	{
		this.characters = characters;
	}

	public List<CampaignModel> getMasteredCampaigns()
	{
		return masteredCampaigns;
	}

	public void setMasteredCampaigns(List<CampaignModel> masteredCampaigns)
	{
		this.masteredCampaigns = masteredCampaigns;
	}

	public List<CampaignModel> getPlayedCampaigns()
	{
		return playedCampaigns;
	}

	public void setPlayedCampaigns(List<CampaignModel> playedCampaigns)
	{
		this.playedCampaigns = playedCampaigns;
	}

	public List<UserModel> getFriends()
	{
		return friends;
	}

	public void setFriends(List<UserModel> friends)
	{
		this.friends = friends;
	}
}
