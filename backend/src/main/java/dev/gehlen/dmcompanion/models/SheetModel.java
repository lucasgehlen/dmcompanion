package dev.gehlen.dmcompanion.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_SHEET")
public class SheetModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private UUID id;
}
