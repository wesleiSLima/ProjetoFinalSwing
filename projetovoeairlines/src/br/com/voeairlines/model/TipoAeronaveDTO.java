package br.com.voeairlines.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TipoAeronaveDTO {

	// atributo
	private int id;
	private String descricao;
	private List<AeronaveDTO> aeronave = new ArrayList<AeronaveDTO>();

	// construtores
	public TipoAeronaveDTO() {
		super();
	}

	public TipoAeronaveDTO(int id, String descricao, List<AeronaveDTO> aeronave) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.aeronave = aeronave;
	}



	// get e set
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AeronaveDTO> getAeronave() {
		return aeronave;
	}

	public void setAeronave(List<AeronaveDTO> aeronave) {
		this.aeronave = aeronave;
	}
	
	//metodos
	
	public void cadastrarTipo(TipoAeronaveDTO tipo) {
		
	}

	@Override
	public String toString() {
		return getDescricao();
	}

	
	


}
